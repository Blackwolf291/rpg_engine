package nl.shadeblackwolf.engine.combat.matchers;

import nl.shadeblackwolf.engine.combat.Attack;
import org.hamcrest.Description;

public class MoveAccuracyMatcher extends SingleRunTypeSafeDiagnosingMatcher<Attack> {
    private final int missChance;

    MoveAccuracyMatcher(int missChance) {
        this.missChance = missChance;
    }

    @Override
    protected boolean matchesSafely(Attack attack, Description mismatchDescription) {
        if(100- missChance != attack.getAccuracy()){
            mismatchDescription.appendText("misschance was ").appendValue(100-attack.getAccuracy()).appendText("%");
            return false;
        }
        return true;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("misschance is ").appendValue(missChance).appendText("%");
    }
}