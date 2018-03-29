package nl.shadeblackwolf.engine.combat.matchers;

import nl.shadeblackwolf.engine.combat.Attack;
import nl.shadeblackwolf.engine.combat.Target;
import nl.shadeblackwolf.engine.combat.matchers.attackmodule.*;
import org.hamcrest.Matcher;

public class CustomMatchers {

    public static Matcher<Attack> isMoveThat(AttackModulesMatcher modulesMatcher, MoveAccuracyMatcher accuracyMatcher, TargetMatcher targetMatcher) {
        return new AttackMatcher(accuracyMatcher, targetMatcher, modulesMatcher);
    }

    public static DamageModuleMatcher isDamageModule(int damage) {
        return new DamageModuleMatcher(damage);
    }


    public static DeathModuleMatcher isDeathModule(int chance) {
        return new DeathModuleMatcher(chance);
    }

    public static BurnModuleMatcher isBurnModule(int chance){
        return new BurnModuleMatcher(chance);
    }

    public static FrozenModuleMatcher isFrozenModule(int chance){
        return new FrozenModuleMatcher(chance);
    }

    public static ConfuseModuleMatcher isConfuseModule(int chance){
        return new ConfuseModuleMatcher(chance);
    }

    public static StunModuleMatcher isStunModule(int chance){
        return new StunModuleMatcher(chance);
    }

    public static SleepModuleMatcher isSleepModule(int chance){
        return new SleepModuleMatcher(chance);
    }

    public static PoisonModuleMatcher isPoisonModule(int chance){
        return new PoisonModuleMatcher(chance);
    }

    public static FlinchModuleMatcher isFlinchModule(int chance){
        return new FlinchModuleMatcher(chance);
    }

    public static MoveAccuracyMatcher hasMissChance(int missChance) {
        return new MoveAccuracyMatcher(missChance);
    }

    public static MoveAccuracyMatcher canNotMiss() {
        return new MoveAccuracyMatcher(0);
    }

    public static AttackModulesMatcher hasAttackModules(SingleRunTypeSafeDiagnosingMatcher... modules) {
        return new AttackModulesMatcher(modules);
    }

    public static AttackModulesMatcher hasNoAttackModules() {
        return new AttackModulesMatcher();
    }

    public static TargetMatcher hasTarget(Target target) {
        return new TargetMatcher(target);
    }

}