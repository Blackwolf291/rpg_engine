package nl.shadeblackwolf.engine.combat.matchers;

import nl.shadeblackwolf.engine.combat.Attack;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

public class AttackMatcher extends SingleRunTypeSafeDiagnosingMatcher<Attack> {
    private final MoveAccuracyMatcher accuracyMatcher;
    private final TargetMatcher targetMatcher;
    private final AttackModulesMatcher modulesMatcher;

    AttackMatcher(MoveAccuracyMatcher accuracyMatcher, TargetMatcher targetMatcher, AttackModulesMatcher modulesMatcher) {
        this.accuracyMatcher = accuracyMatcher;
        this.targetMatcher = targetMatcher;
        this.modulesMatcher = modulesMatcher;
    }

    @Override
    protected boolean matchesSafely(Attack attack, Description mismatchDescription) {
        boolean result = testMultipleMatchers(attack, mismatchDescription, accuracyMatcher, targetMatcher, modulesMatcher);
        if (!result) {
            mismatchDescription.appendText("}");
        }
        return result;
    }

    @SafeVarargs
    private final boolean testMultipleMatchers(Attack attack, Description mismatchDescription, Matcher<Attack>... matchers){
        boolean result = true;
        for(Matcher<Attack> matcher : matchers){
            result = testMatcher(attack, matcher, mismatchDescription, result);
        }
        return result;
    }

    private boolean testMatcher(Attack attack, Matcher<Attack> attackMatcher, Description mismatchDescription, boolean result) {
        if (!attackMatcher.matches(attack)) {
            if(result){
                mismatchDescription.appendText("{");
            } else {
                mismatchDescription.appendText(", ");
            }
            attackMatcher.describeMismatch(attack, mismatchDescription);
            return false;
        }
        return result;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("{");
        accuracyMatcher.describeTo(description);
        description.appendText(", ");
        targetMatcher.describeTo(description);
        description.appendText(", ");
        modulesMatcher.describeTo(description);
        description.appendText("}");
    }
}