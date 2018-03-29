package nl.shadeblackwolf.engine.combat.matchers.attackmodule;

import nl.shadeblackwolf.engine.combat.combattantbuilding.attackmodule.StunModule;
import nl.shadeblackwolf.engine.combat.matchers.SingleRunTypeSafeDiagnosingMatcher;
import org.hamcrest.Description;

public class StunModuleMatcher  extends SingleRunTypeSafeDiagnosingMatcher<StunModule> {

    private final int chance;

    public StunModuleMatcher(int chance) {
        this.chance = chance;
    }

    @Override
    public boolean matchesType(Class clazz){
        return clazz.equals(StunModule.class);
    }

    @Override
    protected boolean matchesSafely(StunModule stunModule, Description mismatchDescription) {
        if(stunModule.getChance() == chance){
            return true;
        }
        mismatchDescription.appendText("{stun chance was ").appendValue(stunModule.getChance()).appendText("}");
        return false;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("{stun chance is ").appendValue(chance).appendText("}");
    }
}