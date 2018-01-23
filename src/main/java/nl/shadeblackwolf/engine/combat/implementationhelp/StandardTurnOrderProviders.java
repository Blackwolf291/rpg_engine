package nl.shadeblackwolf.engine.combat.implementationhelp;

import nl.shadeblackwolf.engine.combat.Ally;
import nl.shadeblackwolf.engine.combat.Combattant;
import nl.shadeblackwolf.engine.combat.Enemy;
import nl.shadeblackwolf.engine.combat.TurnOrderProvider;

import java.util.ArrayList;
import java.util.List;

public enum StandardTurnOrderProviders implements TurnOrderProvider{
    PARTY_ORDER {
        @Override
        public <A extends Ally, E extends Enemy> List<Combattant> getTurnOrder(List<A> party, List<E> enemies) {
            List<Combattant> order = new ArrayList<>();
            order.addAll(party);
            order.addAll(enemies);
            return order;
        }
    }
}
