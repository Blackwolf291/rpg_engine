package nl.shadeblackwolf.engine.combat.combattantbuilding.attackmodule;

import nl.shadeblackwolf.engine.combat.combattantbuilding.AttackModule;

public class DamageModule implements AttackModule {
    private int damage;

    public DamageModule(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
}