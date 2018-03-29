package nl.shadeblackwolf.engine.combat.combattantbuilding.attackmodule;

import nl.shadeblackwolf.engine.combat.combattantbuilding.AttackModule;

public class StunModule implements AttackModule{
    private int chance;

    public StunModule(int chance) {
        this.chance = chance;
    }

    public int getChance() {
        return chance;
    }
}