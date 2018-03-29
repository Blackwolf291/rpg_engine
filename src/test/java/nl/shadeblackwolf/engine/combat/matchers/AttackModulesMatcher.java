package nl.shadeblackwolf.engine.combat.matchers;

import nl.shadeblackwolf.engine.combat.Attack;
import nl.shadeblackwolf.engine.combat.combattantbuilding.AttackModule;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;

public class AttackModulesMatcher extends SingleRunTypeSafeDiagnosingMatcher<Attack> {
    private final SingleRunTypeSafeDiagnosingMatcher[] matchers;

    AttackModulesMatcher(SingleRunTypeSafeDiagnosingMatcher... modules) {
        this.matchers = modules;
    }

    @Override
    protected boolean matchesSafely(Attack attack, Description mismatchDescription) {
        boolean result = true;
        for(AttackModule module : attack.getModules()){
            if(Arrays.stream(matchers).filter(matcher -> matcher.matchesType(module.getClass())).noneMatch(matcher -> matcher.matches(module))){
                handleMismatch(module, findModuleMatcher(module), result, mismatchDescription);
                result = false;
            }
        }
        for(SingleRunTypeSafeDiagnosingMatcher matcher : matchers){
            if(attack.getModules().stream().noneMatch(module -> matcher.matchesType(module.getClass()))){
                handleMismatch(null, matcher, result, mismatchDescription);
                result = false;
            }
        }
        if(!result){
            mismatchDescription.appendText("]");
        }
        return result;
    }

    private void handleMismatch(AttackModule module, Matcher<?> moduleMatcher, boolean firstMissing, Description mismatchDescription) {
        if(firstMissing){
            mismatchDescription.appendText("modules [");
        } else {
            mismatchDescription.appendText(", ");
        }
        if(moduleMatcher == null){
            mismatchDescription.appendText(module.getClass().getSimpleName() + " not expected");
        }else if(module == null){
            mismatchDescription.appendText(((Class)((ParameterizedType)moduleMatcher.getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getSimpleName() + " not found");
        } else {
            moduleMatcher.describeMismatch(module, mismatchDescription);
        }
    }

    private Matcher findModuleMatcher(AttackModule module) {
        return Arrays.stream(matchers).filter(matcher -> matcher.matchesType(module.getClass())).findFirst().orElse(null);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("modules [");
        Arrays.stream(matchers).forEach(module -> module.describeTo(description));
        description.appendText("]");
    }

}