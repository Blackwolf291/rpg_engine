package nl.shadeblackwolf.engine.combat.matchers;

import nl.shadeblackwolf.engine.combat.Attack;
import nl.shadeblackwolf.engine.combat.Target;
import org.hamcrest.Description;

public class TargetMatcher extends SingleRunTypeSafeDiagnosingMatcher<Attack> {
    private final Target target;

    TargetMatcher(Target target) {
        this.target = target;
    }

    @Override
    protected boolean matchesSafely(Attack attack, Description mismatchDescription) {
        if(attack.getTarget() != target){
            mismatchDescription.appendText("target was ").appendValue(attack.getTarget());
            return false;
        }
        return true;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("target is ").appendValue(target);
    }
}