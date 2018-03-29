package nl.shadeblackwolf.engine.combat.matchers.attackmodule;

import nl.shadeblackwolf.engine.combat.combattantbuilding.attackmodule.DeathModule;
import nl.shadeblackwolf.engine.combat.matchers.SingleRunTypeSafeDiagnosingMatcher;
import org.hamcrest.Description;

public class DeathModuleMatcher extends SingleRunTypeSafeDiagnosingMatcher<DeathModule> {

    private final int chance;

    public DeathModuleMatcher(int chance) {
        this.chance = chance;
    }

    @Override
    public boolean matchesType(Class clazz){
        return clazz.equals(DeathModule.class);
    }

    @Override
    protected boolean matchesSafely(DeathModule deathModule, Description mismatchDescription) {
        if(deathModule.getChance() == chance){
            return true;
        }
        mismatchDescription.appendText("{death chance was ").appendValue(deathModule.getChance()).appendText("}");
        return false;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("{death chance is ").appendValue(chance).appendText("}");
    }
}