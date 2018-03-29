package nl.shadeblackwolf.engine.combat.implementationhelp;

import nl.shadeblackwolf.engine.combat.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static nl.shadeblackwolf.engine.combat.implementationhelp.StandardTurnOrderProviders.PARTY_ORDER;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class StandardTurnOrderProvidersTest extends TurnOrderProviderTest{

    private MockAlly z;
    private MockAlly y;
    private MockEnemy a;
    private MockEnemy b;

    @Before
    public void setup(){
        z = new MockAlly().withName("z");
        y = new MockAlly().withName("y");
        a = new MockEnemy().withName("a");
        b = new MockEnemy().withName("b");
    }

    @Test
    public void assertCorrectOrder(){
        List<Combattant> turnOrder = PARTY_ORDER.getTurnOrder(
                asList(z, y),
                asList(a, b));
        assertThat(turnOrder, equalTo(asList(z, y, a, b)));
    }

    @Override
    protected TurnOrderProvider getTurnOrderProvider() {
        return PARTY_ORDER;
    }

    @Override
    protected int getMaxEnemies() {
        return 5;
    }

    @Override
    protected Class<MockEnemy> getEnemyClass() {
        return MockEnemy.class;
    }

    @Override
    protected int getMaxPartySize() {
        return 4;
    }

    @Override
    protected Class<MockAlly> getAllyClass() {
        return MockAlly.class;
    }

    private class MockEnemy implements Enemy{
        private String name;

        MockEnemy withName(String name){
            this.name = name;
            return this;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public void doMove(List<Ally> allies, List<Enemy> enemies) {

        }
    }

    private class MockAlly implements Ally{
        private String name;

        MockAlly withName(String name){
            this.name = name;
            return this;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public void doMove(List<Ally> allies, List<Enemy> enemies) {

        }
    }
}