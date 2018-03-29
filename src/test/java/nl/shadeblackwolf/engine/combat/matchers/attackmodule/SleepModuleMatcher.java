package nl.shadeblackwolf.engine.combat.matchers.attackmodule;

import nl.shadeblackwolf.engine.combat.combattantbuilding.attackmodule.SleepModule;
import nl.shadeblackwolf.engine.combat.matchers.SingleRunTypeSafeDiagnosingMatcher;
import org.hamcrest.Description;

public class SleepModuleMatcher extends SingleRunTypeSafeDiagnosingMatcher<SleepModule> {

    private final int chance;

    public SleepModuleMatcher(int chance) {
        this.chance = chance;
    }

    @Override
    public boolean matchesType(Class clazz) {
        return clazz.equals(SleepModule.class);
    }

    @Override
    protected boolean matchesSafely(SleepModule sleepModule, Description mismatchDescription) {
        if (sleepModule.getChance() == chance) {
            return true;
        }
        mismatchDescription.appendText("{sleep chance was ").appendValue(sleepModule.getChance()).appendText("}");
        return false;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("{sleep chance is ").appendValue(chance).appendText("}");
    }
}