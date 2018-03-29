package nl.shadeblackwolf.engine.combat;

import java.util.List;

public interface Move {
    void performMove(List<Ally> allies, List<Enemy> enemies);
}