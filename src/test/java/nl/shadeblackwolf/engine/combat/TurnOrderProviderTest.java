package nl.shadeblackwolf.engine.combat;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public abstract class TurnOrderProviderTest {
    @Test
    public void identicalSort() {
        List<Combattant> run1 = getTurnOrderProvider().getTurnOrder(partyFromClass(), enemiesFromClass());
        List<Combattant> run2 = getTurnOrderProvider().getTurnOrder(partyFromClass(), enemiesFromClass());
        for (int combattant = 0; combattant < run1.size(); combattant++) {
            assertThat("Run 1 and 2 differ at entry " + combattant, run1.get(combattant).getName(), is(run2.get(combattant).getName()));
        }
    }

    private <T extends Enemy> List<T> enemiesFromClass() {
        List<T> party = new ArrayList<>();
        char name = 'Z';
        for (int enemyCount = 0; enemyCount < getMaxEnemies(); enemyCount++, name--) {
            T enemy = mock(getEnemyClass());
            when(enemy.getName()).thenReturn("name " + name);
            party.add(enemy);
        }
        return party;
    }

    private <T extends Ally> List<T> partyFromClass() {
        List<T> party = new ArrayList<>();
        char name = 'a';
        for (int partySize = 0; partySize < getMaxPartySize(); partySize++, name++) {
            T ally = mock(getAllyClass());
            when(ally.getName()).thenReturn("name " + name);
            party.add(ally);
        }
        return party;
    }

    protected abstract TurnOrderProvider getTurnOrderProvider();

    protected abstract int getMaxEnemies();

    protected abstract <T extends Enemy> Class<T> getEnemyClass();

    protected abstract int getMaxPartySize();

    protected abstract <T extends Ally> Class<T> getAllyClass();

}
