package nl.shadeblackwolf.engine.combat.matchers.attackmodule;

import nl.shadeblackwolf.engine.combat.combattantbuilding.attackmodule.PoisonModule;
import nl.shadeblackwolf.engine.combat.matchers.SingleRunTypeSafeDiagnosingMatcher;
import org.hamcrest.Description;

public class PoisonModuleMatcher extends SingleRunTypeSafeDiagnosingMatcher<PoisonModule> {

    private final int chance;

    public PoisonModuleMatcher(int chance) {
        this.chance = chance;
    }

    @Override
    public boolean matchesType(Class clazz) {
        return clazz.equals(PoisonModule.class);
    }

    @Override
    protected boolean matchesSafely(PoisonModule poisonModule, Description mismatchDescription) {
        if (poisonModule.getChance() == chance) {
            return true;
        }
        mismatchDescription.appendText("{poison chance was ").appendValue(poisonModule.getChance()).appendText("}");
        return false;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("{poison chance is ").appendValue(chance).appendText("}");
    }
}