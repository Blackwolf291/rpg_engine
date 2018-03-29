package nl.shadeblackwolf.engine.combat.combattantbuilding;

import nl.shadeblackwolf.engine.combat.Attack;
import org.junit.Test;

import java.lang.reflect.Field;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import static nl.shadeblackwolf.engine.combat.Target.*;
import static nl.shadeblackwolf.engine.combat.matchers.CustomMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AttackFactoryTest {
    @Test
    public void noPaths_noMoves() throws NoSuchFieldException, IllegalAccessException {
        AttackFactory attackFactory = new AttackFactory();
        assertThat(getAttacks(attackFactory).size(), is(0));
    }

    @Test
    public void onePath_createsSplash() throws NoSuchFieldException, IllegalAccessException {
        Path splashPath = Paths.get("src/test/resources/combattantbuilding/splash.moves.json").toAbsolutePath();
        AttackFactory attackFactory = new AttackFactory(splashPath);
        Attack splash = attackFactory.get("splash");
        assertThat(getAttacks(attackFactory).size(), is(1));
        assertThat(splash, isMoveThat(hasNoAttackModules(), canNotMiss(), hasTarget(ENEMY)));
    }

    @Test
    public void onePath_createsArmageddon() throws NoSuchFieldException, IllegalAccessException {
        Path splashPath = Paths.get("src/test/resources/combattantbuilding/armageddon.moves.json").toAbsolutePath();
        AttackFactory attackFactory = new AttackFactory(splashPath);
        Attack armageddon = attackFactory.get("armageddon");
        assertThat(getAttacks(attackFactory).size(), is(1));
        assertThat(armageddon, isMoveThat(
                hasAttackModules(
                        isDamageModule(500),
                        isDeathModule(50),
                        isBurnModule(50),
                        isFrozenModule(50),
                        isConfuseModule(50),
                        isStunModule(50),
                        isSleepModule(50),
                        isPoisonModule(50),
                        isFlinchModule(75)),
                hasMissChance(95), hasTarget(ENEMIES)));
    }

    private Map<String, Attack> getAttacks(AttackFactory attackFactory) throws NoSuchFieldException, IllegalAccessException {
        Field attacksField = attackFactory.getClass().getDeclaredField("attacks");
        attacksField.setAccessible(true);
        return (Map<String, Attack>) attacksField.get(attackFactory);
    }

}