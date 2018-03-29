package nl.shadeblackwolf.engine.combat.combattantbuilding.attackmodule;

import nl.shadeblackwolf.engine.combat.combattantbuilding.AttackModule;

public class FrozenModule implements AttackModule {
    private int chance;

    public FrozenModule(int chance) {
        this.chance = chance;
    }

    public int getChance() {
        return chance;
    }
}