package nl.shadeblackwolf.engine.combat.combattantbuilding.attackmodule;

import nl.shadeblackwolf.engine.combat.combattantbuilding.AttackModule;

public class ConfuseModule  implements AttackModule {
    private int chance;

    public ConfuseModule(int chance) {
        this.chance = chance;
    }

    public int getChance() {
        return chance;
    }
}