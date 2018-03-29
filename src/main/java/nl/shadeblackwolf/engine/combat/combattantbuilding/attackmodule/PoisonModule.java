package nl.shadeblackwolf.engine.combat.combattantbuilding.attackmodule;

import nl.shadeblackwolf.engine.combat.combattantbuilding.AttackModule;

public class PoisonModule implements AttackModule {
    private int chance;

    public PoisonModule(int chance) {
        this.chance = chance;
    }

    public int getChance() {
        return chance;
    }
}