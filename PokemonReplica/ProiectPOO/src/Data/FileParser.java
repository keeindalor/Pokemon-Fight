package Data;

import Entities.Antrenor;
import Entities.Item;
import Entities.Pokemon;
import Factories.ItemFactory;
import Factories.PokemonFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileParser {
    public FileParser(){}
    public Antrenor[] citesteAntrenori(String file) {
        Antrenor[] antrenors = new Antrenor[2];
        Pokemon[] pokemons1 = new Pokemon[3];
        Pokemon[] pokemons2 = new Pokemon[3];

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            assert br != null;
            String nume = br.readLine();
            int varsta = Integer.parseInt(br.readLine());
            for (int i = 0; i < 3; i ++) {
                ItemFactory itemFactory = ItemFactory.GetInstance();
                PokemonFactory pokemonFactory = PokemonFactory.GetInstance();
                String line = br.readLine();
                String[] info = line.split(";");
                Item[] items = new Item[]{itemFactory.createItem(info[1]),
                        itemFactory.createItem(info[2]),
                        itemFactory.createItem(info[3])};
                pokemons1[i] = pokemonFactory.createPokemon(info[0], items);

            }
            antrenors[0] = new Antrenor.AntrenorBuilder(nume, varsta)
                    .Pokemon(pokemons1)
                    .build();
            antrenors[0].EnhancePokemons();
            nume = br.readLine();
            varsta = Integer.parseInt(br.readLine());

            for (int i = 0; i < 3; i ++) {
                String line = br.readLine();
                String[] info = line.split(";");
                Item[] items = new Item[]{ItemFactory.itemFactory.createItem(info[1]),
                        ItemFactory.itemFactory.createItem(info[2]),
                        ItemFactory.itemFactory.createItem(info[3])};
                pokemons2[i] = PokemonFactory.pokemonFactory.createPokemon(info[0], items);
            }

            antrenors[1] = new Antrenor.AntrenorBuilder(nume, varsta)
                    .Pokemon(pokemons2)
                    .build();
            antrenors[1].EnhancePokemons();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return antrenors;
    }
}
