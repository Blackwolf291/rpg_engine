package nl.shadeblackwolf.engine.combat.matchers.attackmodule;

import nl.shadeblackwolf.engine.combat.combattantbuilding.attackmodule.BurnModule;
import nl.shadeblackwolf.engine.combat.matchers.SingleRunTypeSafeDiagnosingMatcher;
import org.hamcrest.Description;

public class BurnModuleMatcher extends SingleRunTypeSafeDiagnosingMatcher<BurnModule> {

    private final int chance;

    public BurnModuleMatcher(int chance) {
        this.chance = chance;
    }

    @Override
    public boolean matchesType(Class clazz){
        return clazz.equals(BurnModule.class);
    }

    @Override
    protected boolean matchesSafely(BurnModule burnModule, Description mismatchDescription) {
        if(burnModule.getChance() == chance){
            return true;
        }
        mismatchDescription.appendText("{burn chance was ").appendValue(burnModule.getChance()).appendText("}");
        return false;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("{burn chance is ").appendValue(chance).appendText("}");
    }
}