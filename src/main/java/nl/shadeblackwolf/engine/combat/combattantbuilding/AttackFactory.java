package nl.shadeblackwolf.engine.combat.combattantbuilding;

import nl.shadeblackwolf.engine.combat.Attack;
import nl.shadeblackwolf.engine.combat.Target;
import nl.shadeblackwolf.engine.combat.combattantbuilding.attackmodule.*;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class AttackFactory {
    private Map<String, Attack> attacks = new HashMap<>();
    public AttackFactory(Path... paths){
        Arrays.stream(paths).map(Path::toAbsolutePath).map(this::read).map(JSONObject::new).forEach(this::processMoves);
    }

    private void processMoves(JSONObject jsonMoves) {
        jsonMoves.keySet().forEach(name -> attacks.put(name, createAttack(jsonMoves.getJSONObject(name))));

    }

    private Attack createAttack(JSONObject move) {
        AttackBuilder attack = new AttackBuilder();
        if(move.has("accuracy")){
            attack.setAccuracy(move.getInt("accuracy"));
        }
        if(move.has("effects")) {
            JSONObject effects = move.getJSONObject("effects");
            if (effects.has("damage")) {
                attack.addModule(new DamageModule(effects.getInt("damage")));
            }
            if (effects.has("death")) {
                attack.addModule(new DeathModule(effects.getInt("death")));
            }
            if (effects.has("burn")) {
                attack.addModule(new BurnModule(effects.getInt("burn")));
            }
            if (effects.has("confuse")) {
                attack.addModule(new ConfuseModule(effects.getInt("confuse")));
            }
            if (effects.has("frozen")) {
                attack.addModule(new FrozenModule(effects.getInt("frozen")));
            }
            if (effects.has("stun")) {
                attack.addModule(new StunModule(effects.getInt("stun")));
            }
        }
        if(move.has("target")){
            attack.setTarget(Target.valueOf(move.getString("target").toUpperCase()));
        }
        return attack.build();
    }

    private String read(Path path){
        try {
            return new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new CouldNotReadFile(path, e);
        }
    }

    public Attack get(String name) {
        return attacks.get(name);
    }

    private class CouldNotReadFile extends RuntimeException {
        CouldNotReadFile(Path path, IOException e) {
            super(path.toString(), e);
        }
    }
}