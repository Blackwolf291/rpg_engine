package nl.shadeblackwolf.engine.combat.implementationhelp;

import nl.shadeblackwolf.engine.combat.Move;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AutonomousCombattantTest {
    @Test
    public void createWithName(){
        AutonomousCombattant combattant = AutonomousCombattant.builder().withName("Giant Ape").withMove((a,b)->{}).build();
        assertThat(combattant.getName(), is("Giant Ape"));
    }

    @Test
    public void oneMove(){
        Move mockMove = mock(Move.class);
        AutonomousCombattant combattant = AutonomousCombattant.builder().withName("Giant Ape").withMove(mockMove).build();

        combattant.doMove(new ArrayList<>(), new ArrayList<>());

        verify(mockMove).performMove(any(), any());
    }
}