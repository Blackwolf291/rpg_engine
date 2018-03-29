package nl.shadeblackwolf.engine.combat;

import java.util.ArrayList;
import java.util.List;

public interface Combattant {
    String getName();

    void doMove(List<Ally> allies, List<Enemy> enemies);
}