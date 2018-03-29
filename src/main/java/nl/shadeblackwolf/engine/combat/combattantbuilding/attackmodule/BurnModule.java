package nl.shadeblackwolf.engine.combat.combattantbuilding.attackmodule;

import nl.shadeblackwolf.engine.combat.combattantbuilding.AttackModule;

public class BurnModule implements AttackModule {
    private int chance;

    public BurnModule(int chance) {
        this.chance = chance;
    }

    public int getChance() {
        return chance;
    }
}