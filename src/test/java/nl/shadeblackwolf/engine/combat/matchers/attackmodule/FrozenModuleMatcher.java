package nl.shadeblackwolf.engine.combat.matchers.attackmodule;

import nl.shadeblackwolf.engine.combat.combattantbuilding.attackmodule.FrozenModule;
import nl.shadeblackwolf.engine.combat.matchers.SingleRunTypeSafeDiagnosingMatcher;
import org.hamcrest.Description;

public class FrozenModuleMatcher extends SingleRunTypeSafeDiagnosingMatcher<FrozenModule> {

    private final int chance;

    public FrozenModuleMatcher(int chance) {
        this.chance = chance;
    }

    @Override
    public boolean matchesType(Class clazz){
        return clazz.equals(FrozenModule.class);
    }

    @Override
    protected boolean matchesSafely(FrozenModule frozenModule, Description mismatchDescription) {
        if(frozenModule.getChance() == chance){
            return true;
        }
        mismatchDescription.appendText("{frozen chance was ").appendValue(frozenModule.getChance()).appendText("}");
        return false;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("{frozen chance is ").appendValue(chance).appendText("}");
    }
}