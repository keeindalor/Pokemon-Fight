package Arene;

import Arene.Strategy.*;
import Data.FileParser;
import Entities.Antrenor;

import java.io.*;
import java.util.*;

public class Arena implements Runnable {
    public Antrenor aliat;
    public Antrenor inamic;
    public int cdAnt1Ab1, cdAnt1Ab2, cdAnt2Ab1, cdAnt2Ab2;
    StringBuilder log = new StringBuilder("");
    public Arena(String file) {
        FileParser parser = new FileParser();
        Antrenor[] antrenors = new Antrenor[2];
        antrenors = parser.citesteAntrenori(file);
        aliat = antrenors[0];
        inamic = antrenors[1];

    }

    @Override
    public void run() {
        int i = 0, j = 0;
        while (aliat.poateLupta() && inamic.poateLupta()) {
            aliat.pokemonCurent = aliat.getPokemons()[i];
            inamic.pokemonCurent = inamic.getPokemons()[j];

            while (aliat.pokemonCurent.getHP() > 0 && inamic.pokemonCurent.getHP() > 0) {
                String miscareAnt1 = aliat.alegeAtacul(inamic.pokemonCurent);
                String miscareAnt2 = inamic.alegeAtacul(aliat.pokemonCurent);
                Strategy tipAttack1 = tipAtac(miscareAnt1);
                Strategy tipAttack2 = tipAtac(miscareAnt2);
                log.append(tipAttack1.Attack(aliat, inamic));
                log.append(tipAttack2.Attack(inamic,aliat));

                aliat.pokemonCurent.getAbilitiy1().decreaseCd();
                aliat.pokemonCurent.getAbilitiy2().decreaseCd();
                inamic.pokemonCurent.getAbilitiy1().decreaseCd();
                inamic.pokemonCurent.getAbilitiy2().decreaseCd();

            }
            if (aliat.pokemonCurent.getHP() <= 0) {
                i++;
                inamic.pokemonCurent.Reload();

            }
            if (inamic.pokemonCurent.getHP() <= 0) {
                j++;
                aliat.pokemonCurent.Reload();
            }
            if (aliat.pokemonCurent.getHP() > 0) {
                log.append(aliat.pokemonCurent.getNume()).append(" a castigat\n");
            }
            else {
                log.append(inamic.pokemonCurent.getNume()).append(" a castigat\n");
            }

        }

        System.out.println("Doresti logger in fisier? Y/N");
        Scanner scanner = new Scanner(System.in);
        String info = scanner.nextLine();
        if (info.equals("Y")) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("Logger"));
                writer.write(String.valueOf(log));
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println(log);
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
