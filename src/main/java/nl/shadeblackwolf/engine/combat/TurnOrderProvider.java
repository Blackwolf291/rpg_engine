package nl.shadeblackwolf.engine.combat;

import java.util.List;

public interface TurnOrderProvider {

    /*
        Must return the same order if called with the same combattants in the same state.
        It may not return null, and it's arguments are never null.
     */
    <A extends Ally,E extends Enemy> List<Combattant> getTurnOrder(List<A> party, List<E> enemies);
}
