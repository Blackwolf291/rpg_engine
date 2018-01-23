package nl.shadeblackwolf.engine.combat.implementationhelp;

import nl.shadeblackwolf.engine.combat.Ally;
import nl.shadeblackwolf.engine.combat.Enemy;
import nl.shadeblackwolf.engine.combat.Move;

import java.util.ArrayList;
import java.util.List;

public class AutonomousCombattant implements Ally, Enemy{
    private String name;
    private Move move;

    public static AutonomousCombattantBuilder builder(){return new AutonomousCombattantBuilder();}

    private AutonomousCombattant(){}

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void doMove(List<Ally> allies, List<Enemy> enemies) {
        move.performMove(allies,enemies);
    }

    public static class AutonomousCombattantBuilder{
        AutonomousCombattant combattant;

        private AutonomousCombattantBuilder(){
            combattant = new AutonomousCombattant();
        }

        public AutonomousCombattant build() {
            if(combattant.name == null) {
                throw new CombattantHasNoName();
            }
            if(combattant.move == null) {
                throw new CombattantHasNoMoves();
            }
            return combattant;
        }

        public AutonomousCombattantBuilder withName(String name) {
            combattant.name = name;
            return this;
        }

        public AutonomousCombattantBuilder withMove(Move move) {
            combattant.move = move;
            return this;
        }

        private class CombattantHasNoMoves extends RuntimeException {
        }

        private class CombattantHasNoName extends RuntimeException {
        }
    }
}
