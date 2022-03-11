package Arene;

import Arene.Strategy.*;
import Data.FileParser;
import Entities.Antrenor;
import Entities.Pokemon;
import Factories.PokemonFactory;

import java.util.Arrays;
import java.util.List;

public class ArenaNeutra2 {
    public Antrenor aliat;
    public Antrenor inamic;
    StringBuilder log = new StringBuilder("");
    public ArenaNeutra2(String file) {
        FileParser parser = new FileParser();
        Antrenor[] antrenors = new Antrenor[2];
        antrenors = parser.citesteAntrenori(file);
        aliat = antrenors[0];
        inamic = antrenors[1];
    }
    public void Fight() {
        Pokemon[] pokemons = new Pokemon[1];
        pokemons[0] = PokemonFactory.pokemonFactory.createPokemon("Neutrel2", null);
        Antrenor neutru = new Antrenor.AntrenorBuilder("neutru", 0)
                .Pokemon(pokemons)
                .build();

        while (aliat.poateLupta() && neutru.poateLupta()) {
            aliat.pokemonCurent = aliat.getPokemons()[0];
            neutru.pokemonCurent = neutru.getPokemons()[0];
            //System.out.println(aliat.pokemonCurent.getHP() + " " + neutru.pokemonCurent.getHP());
            while (aliat.pokemonCurent.getHP() > 0 && neutru.pokemonCurent.getHP() > 0) {
                String miscareAnt1 = aliat.alegeAtacul(neutru.pokemonCurent);
                String miscareAnt2 = neutru.alegeAtacul(aliat.pokemonCurent);
                Strategy tipAttack1 = tipAtac(miscareAnt1);
                Strategy tipAttack2 = tipAtac(miscareAnt2);
                log.append(tipAttack1.Attack(aliat, neutru));
                log.append(tipAttack2.Attack(neutru,aliat));

                aliat.pokemonCurent.getAbilitiy1().decreaseCd();
                aliat.pokemonCurent.getAbilitiy2().decreaseCd();
            }
        }
        aliat.pokemonCurent.Reload();
        aliat.pokemonCurent.AddStats();
        neutru.pokemonCurent.Reload();
        System.out.println(log);
        if (aliat.pokemonCurent.getHP() > 0) {
            System.out.println(aliat.pokemonCurent.getNume() + " a castigat.\n");
        }
        log = new StringBuilder("");
        while (inamic.poateLupta() && neutru.poateLupta()) {
            inamic.pokemonCurent = inamic.getPokemons()[0];
            neutru.pokemonCurent = neutru.getPokemons()[0];

            while (inamic.pokemonCurent.getHP() > 0 && neutru.pokemonCurent.getHP() > 0) {
                String miscareAnt1 = inamic.alegeAtacul(neutru.pokemonCurent);
                String miscareAnt2 = neutru.alegeAtacul(inamic.pokemonCurent);
                Strategy tipAttack1 = tipAtac(miscareAnt1);
                Strategy tipAttack2 = tipAtac(miscareAnt2);
                log.append(tipAttack1.Attack(inamic, neutru));
                log.append(tipAttack2.Attack(neutru,inamic));

                inamic.pokemonCurent.getAbilitiy1().decreaseCd();
                inamic.pokemonCurent.getAbilitiy2().decreaseCd();
            }
        }
        inamic.pokemonCurent.Reload();
        inamic.pokemonCurent.AddStats();
        neutru.pokemonCurent.Reload();
        System.out.println(log);
        if (inamic.pokemonCurent.getHP() > 0) {
            System.out.println(inamic.pokemonCurent.getNume() + " a castigat.\n");
        }

    }
    Strategy tipAtac (String miscare) {
        List<Strategy> posibilities = Arrays.asList(new NormalAttack(), new SpecialAttack(),
                new SpecialAbility1(), new SpecialAbility2());
        for (Strategy strategy : posibilities) {
            if (strategy.Accept(miscare)) {
                return strategy;
            }
        }
        return null;
    }
}
