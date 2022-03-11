package Factories;

import Entities.Abilitiy;
import Entities.Item;
import Entities.Pokemon;

public class PokemonFactory {
    public static PokemonFactory pokemonFactory;
    private PokemonFactory(){}
    public static PokemonFactory GetInstance() {
        if (pokemonFactory == null) {
            pokemonFactory = new PokemonFactory();
        }
        return pokemonFactory;
    }
    public Pokemon createPokemon(String nume, Item[] items) {
        if (nume == null)
            return null;
        switch (nume) {
            case "Neutrel1":
                return new Pokemon.PokemonBuilder(nume)
                        .HP(10)
                        .attack(3)
                        .defense(1)
                        .special_defense(1)
                        .abilitiy2(null)
                        .abilitiy1(null)
                        .build();
            case "Neutrel2":
                return new Pokemon.PokemonBuilder(nume)
                        .HP(20)
                        .attack(4)
                        .defense(1)
                        .special_defense(1)
                        .abilitiy1(null)
                        .abilitiy2(null)
                        .build();
            case "Pikachu":
                return new Pokemon.PokemonBuilder(nume)
                        .HP(35)
                        .special_attack(4)
                        .defense(2)
                        .special_defense(3)
                        .abilitiy1(new Abilitiy.AbilityBuilder()
                                .dmg(6)
                                .cd(4)
                                .build())
                        .abilitiy2(new Abilitiy.AbilityBuilder()
                                .dmg(4)
                                .stun(true)
                                .dodge(true)
                                .cd(5)
                                .build())
                        .items(items)
                        .build();
            case "Bulbasaur":
                return new Pokemon.PokemonBuilder(nume)
                        .HP(42)
                        .special_attack(5)
                        .defense(3)
                        .special_defense(1)
                        .abilitiy1(new Abilitiy.AbilityBuilder()
                                .dmg(6)
                                .stun(true)
                                .cd(4)
                                .build())
                        .abilitiy2(new Abilitiy.AbilityBuilder()
                                .dmg(5)
                                .cd(3)
                                .build())
                        .items(items)
                        .build();
            case "Charmander":
                return new Pokemon.PokemonBuilder(nume)
                        .HP(50)
                        .attack(4)
                        .defense(3)
                        .special_defense(2)
                        .abilitiy1(new Abilitiy.AbilityBuilder()
                                .dmg(4)
                                .stun(true)
                                .cd(4)
                                .build())
                        .abilitiy2(new Abilitiy.AbilityBuilder()
                                .dmg(7)
                                .cd(6)
                                .build())
                        .items(items)
                        .build();
            case "Squirtle":
                return new Pokemon.PokemonBuilder(nume)
                        .HP(60)
                        .special_attack(3)
                        .defense(5)
                        .special_defense(5)
                        .abilitiy1(new Abilitiy.AbilityBuilder()
                                .dmg(4)
                                .cd(3)
                                .build())
                        .abilitiy2(new Abilitiy.AbilityBuilder()
                                .dmg(2)
                                .stun(true)
                                .cd(2)
                                .build())
                        .items(items)
                        .build();
            case "Snorlax":
                return new Pokemon.PokemonBuilder(nume)
                        .HP(62)
                        .attack(3)
                        .defense(6)
                        .special_defense(4)
                        .abilitiy1(new Abilitiy.AbilityBuilder()
                                .dmg(4)
                                .stun(true)
                                .cd(5)
                                .build())
                        .abilitiy2(new Abilitiy.AbilityBuilder()
                                .dodge(true)
                                .cd(5)
                                .build())
                        .items(items)
                        .build();
            case "Vulpix":
                return new Pokemon.PokemonBuilder(nume)
                        .HP(36)
                        .attack(5)
                        .defense(2)
                        .special_defense(4)
                        .abilitiy1(new Abilitiy.AbilityBuilder()
                                .dmg(8)
                                .stun(true)
                                .cd(6)
                                .build())
                        .abilitiy2(new Abilitiy.AbilityBuilder()
                                .dmg(2)
                                .dodge(true)
                                .cd(7)
                                .build())
                        .items(items)
                        .build();
            case "Eevee":
                return new Pokemon.PokemonBuilder(nume)
                        .HP(39)
                        .special_attack(4)
                        .defense(3)
                        .special_defense(3)
                        .abilitiy1(new Abilitiy.AbilityBuilder()
                                .dmg(5)
                                .cd(3)
                                .build())
                        .abilitiy2(new Abilitiy.AbilityBuilder()
                                .dmg(3)
                                .stun(true)
                                .cd(3)
                                .build())
                        .items(items)
                        .build();
            case "Jigglypuff":
                return new Pokemon.PokemonBuilder(nume)
                        .HP(34)
                        .attack(4)
                        .defense(2)
                        .special_defense(3)
                        .abilitiy1(new Abilitiy.AbilityBuilder()
                                .dmg(4)
                                .stun(true)
                                .cd(4)
                                .build())
                        .abilitiy2(new Abilitiy.AbilityBuilder()
                                .dmg(3)
                                .stun(true)
                                .cd(4)
                                .build())
                        .items(items)
                        .build();
            case "Meowth":
                return new Pokemon.PokemonBuilder(nume)
                        .HP(41)
                        .attack(3)
                        .defense(4)
                        .special_defense(2)
                        .abilitiy1(new Abilitiy.AbilityBuilder()
                                .dmg(5)
                                .dodge(true)
                                .cd(4)
                                .build())
                        .abilitiy2(new Abilitiy.AbilityBuilder()
                                .dmg(1)
                                .stun(true)
                                .dodge(true)
                                .cd(3)
                                .build())
                        .items(items)
                        .build();
            case "Psyduck":
                return new Pokemon.PokemonBuilder(nume)
                        .HP(43)
                        .attack(3)
                        .defense(3)
                        .special_defense(3)
                        .abilitiy1(new Abilitiy.AbilityBuilder()
                                .dmg(2)
                                .cd(4)
                                .build())
                        .abilitiy2(new Abilitiy.AbilityBuilder()
                                .dmg(2)
                                .stun(true)
                                .cd(5)
                                .build())
                        .items(items)
                        .build();
        }
        throw new IllegalArgumentException("Nu exista numele " + nume);
    }
}
