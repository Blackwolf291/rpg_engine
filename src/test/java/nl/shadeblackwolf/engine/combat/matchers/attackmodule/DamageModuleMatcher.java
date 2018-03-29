package nl.shadeblackwolf.engine.combat.matchers.attackmodule;

import nl.shadeblackwolf.engine.combat.combattantbuilding.attackmodule.DamageModule;
import nl.shadeblackwolf.engine.combat.matchers.SingleRunTypeSafeDiagnosingMatcher;
import org.hamcrest.Description;

import static org.hamcrest.core.Is.is;

public class DamageModuleMatcher extends SingleRunTypeSafeDiagnosingMatcher<DamageModule> {
    private final int damage;

    public DamageModuleMatcher(int damage) {
        this.damage = damage;
    }

    @Override
    public boolean matchesType(Class clazz){
        return clazz.equals(DamageModule.class);
    }

    @Override
    protected boolean matchesSafely(DamageModule damageModule, Description mismatchDescription) {
        if(!is(damage).matches(damageModule.getDamage())){
            mismatchDescription.appendText("{damage was ").appendValue(damageModule.getDamage()).appendText("}");
            return false;
        }
        return true;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("{damage is ").appendValue(damage).appendText("}");
    }

}