package nl.shadeblackwolf.engine.combat.combattantbuilding;

import nl.shadeblackwolf.engine.combat.*;

import java.util.*;

import static nl.shadeblackwolf.engine.combat.Target.ENEMY;

class AttackBuilder {
    private List<AttackModule> modules = new ArrayList<>();
    private int accuracy = 100;
    private Target target = ENEMY;

    Attack build() {
        return new Attack() {
            @Override
            public List<AttackModule> getModules() {
                return modules;
            }

            @Override
            public int getAccuracy() {
                return accuracy;
            }

            @Override
            public Target getTarget() {
                return target;
            }
        };
    }

    void addModule(AttackModule attackModule) {
        modules.add(attackModule);
    }

    void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public void setTarget(Target target) {
        this.target = target;
    }
}