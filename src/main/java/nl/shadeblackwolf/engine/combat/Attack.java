package nl.shadeblackwolf.engine.combat;

import nl.shadeblackwolf.engine.combat.combattantbuilding.AttackModule;

import java.util.List;

public interface Attack {
    List<AttackModule> getModules();

    int getAccuracy();

    Target getTarget();
}