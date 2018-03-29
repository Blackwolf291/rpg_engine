package nl.shadeblackwolf.engine.combat.combattantbuilding.attackmodule;

import nl.shadeblackwolf.engine.combat.combattantbuilding.AttackModule;

public class SleepModule implements AttackModule {
    private int chance;

    public SleepModule(int chance) {
        this.chance = chance;
    }

    public int getChance() {
        return chance;
    }
}