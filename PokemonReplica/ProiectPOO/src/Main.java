import Arene.Arena;
import Arene.ArenaNeutra1;
import Arene.ArenaNeutra2;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 4; i ++) {
            String file_name = "Fight" + i + ".txt";
            ArenaNeutra1 neutra1 = new ArenaNeutra1(file_name);
            ArenaNeutra2 neutra2 = new ArenaNeutra2(file_name);
            List<String> posibilitati = Arrays.asList("Neutrel1", "Neutrel2", "Impreuna");
            Random random = new Random();
            int index = random.nextInt(posibilitati.size());
            while (!posibilitati.get(index).equals("Impreuna")) {
                if (posibilitati.get(index).equals("Neutrel1")) {
                    neutra1.Fight();
                }
                if (posibilitati.get(index).equals("Neutrel2")) {
                    neutra2.Fight();
                }
                index = random.nextInt(posibilitati.size());
            }
            ExecutorService service = Executors.newCachedThreadPool();
            service.execute(new Arena(file_name));
            service.shutdown();
        }
    }
}
