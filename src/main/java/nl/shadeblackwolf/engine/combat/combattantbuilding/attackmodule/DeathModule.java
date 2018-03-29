package nl.shadeblackwolf.engine.combat.combattantbuilding.attackmodule;

import nl.shadeblackwolf.engine.combat.combattantbuilding.AttackModule;

public class DeathModule implements AttackModule {
    private int chance;

    public DeathModule(int chance) {
        this.chance = chance;
    }

    public int getChance() {
        return chance;
    }
}