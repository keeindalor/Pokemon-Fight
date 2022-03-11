package Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Antrenor {
    private final String nume;
    private final int varsta;
    private final Pokemon[] pokemons;
    public Pokemon pokemonCurent;
    public String currentAttack;

    private Antrenor (AntrenorBuilder builder) {
        this.nume = builder.nume;
        this.varsta = builder.varsta;
        this.pokemons = builder.pokemons;
        pokemonCurent = null;
    }

    public String getNume() {
        return nume;
    }

    public int getVarsta() {
        return varsta;
    }

    public Pokemon[] getPokemons() {
        return pokemons;
    }

    public void Restore() {
        for (Pokemon pokemon : pokemons)
            pokemon.Reload();
    }

    public static class AntrenorBuilder {
        private final String nume;
        private final int varsta;
        private Pokemon[] pokemons;
        public AntrenorBuilder(String nume, int varsta) {
            this.nume = nume;
            this.varsta = varsta;
        }
        public AntrenorBuilder Pokemon(Pokemon[] pokemons) {
            this.pokemons = pokemons;
            return this;
        }
        public Antrenor build() {
            return new Antrenor(this);
        }
    }
    public Boolean poateLupta () {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getHP() > 0)
                return true;
        }
        return false;
    }
    public void EnhancePokemons() {
        for (Pokemon pokemon : pokemons) {
            pokemon.AddItemStats();
        }
    }
    public String alegeAtacul(Pokemon adversar) {
        List<String> posibilitati = new ArrayList<>();
        if (adversar.getDefense() < pokemonCurent.getAttack()) {
            posibilitati.add("Normal");
        }
        if (adversar.getSpecial_defense() < pokemonCurent.getSpecial_attack()) {
            posibilitati.add("Special");
        }
        if (pokemonCurent.getAbilitiy1() != null && !pokemonCurent.getAbilitiy1().isOnCd()) {
            posibilitati.add("Ability1");
        }
        if (pokemonCurent.getAbilitiy2() != null && !pokemonCurent.getAbilitiy2().isOnCd()) {
            posibilitati.add("Ability2");
        }
        if (posibilitati.size() == 0) {
            if (pokemonCurent.getAttack() != 0) {
                posibilitati.add("Normal");
            }
            else {
                posibilitati.add("Special");
            }
        }
        Random random = new Random();
        int i = random.nextInt(posibilitati.size());
        currentAttack = posibilitati.get(i);
        return posibilitati.get(i);
    }

}
