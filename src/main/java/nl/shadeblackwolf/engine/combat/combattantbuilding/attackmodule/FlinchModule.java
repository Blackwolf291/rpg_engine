package nl.shadeblackwolf.engine.combat.combattantbuilding.attackmodule;

import nl.shadeblackwolf.engine.combat.combattantbuilding.AttackModule;

public class FlinchModule implements AttackModule {
    private int chance;

    public FlinchModule(int chance) {
        this.chance = chance;
    }

    public int getChance() {
        return chance;
    }
}