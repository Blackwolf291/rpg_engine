package nl.shadeblackwolf.engine.combat.matchers.attackmodule;

import nl.shadeblackwolf.engine.combat.combattantbuilding.attackmodule.FlinchModule;
import nl.shadeblackwolf.engine.combat.matchers.SingleRunTypeSafeDiagnosingMatcher;
import org.hamcrest.Description;

public class FlinchModuleMatcher extends SingleRunTypeSafeDiagnosingMatcher<FlinchModule> {

    private final int chance;

    public FlinchModuleMatcher(int chance) {
        this.chance = chance;
    }

    @Override
    public boolean matchesType(Class clazz) {
        return clazz.equals(FlinchModule.class);
    }

    @Override
    protected boolean matchesSafely(FlinchModule flinchModule, Description mismatchDescription) {
        if (flinchModule.getChance() == chance) {
            return true;
        }
        mismatchDescription.appendText("{flinch chance was ").appendValue(flinchModule.getChance()).appendText("}");
        return false;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("{flinch chance is ").appendValue(chance).appendText("}");
    }
}