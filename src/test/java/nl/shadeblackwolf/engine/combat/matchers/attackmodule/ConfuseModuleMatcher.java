package nl.shadeblackwolf.engine.combat.matchers.attackmodule;

import nl.shadeblackwolf.engine.combat.combattantbuilding.attackmodule.ConfuseModule;
import nl.shadeblackwolf.engine.combat.combattantbuilding.attackmodule.DeathModule;
import nl.shadeblackwolf.engine.combat.matchers.SingleRunTypeSafeDiagnosingMatcher;
import org.hamcrest.Description;

public class ConfuseModuleMatcher extends SingleRunTypeSafeDiagnosingMatcher<ConfuseModule> {

    private final int chance;

    public ConfuseModuleMatcher(int chance) {
        this.chance = chance;
    }

    @Override
    public boolean matchesType(Class clazz){
        return clazz.equals(ConfuseModule.class);
    }

    @Override
    protected boolean matchesSafely(ConfuseModule confuseModule, Description mismatchDescription) {
        if(confuseModule.getChance() == chance){
            return true;
        }
        mismatchDescription.appendText("{confuse chance was ").appendValue(confuseModule.getChance()).appendText("}");
        return false;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("{confuse chance is ").appendValue(chance).appendText("}");
    }
}