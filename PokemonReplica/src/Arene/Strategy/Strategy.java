package Arene.Strategy;

import Entities.Antrenor;

public interface Strategy {

    String Attack(Antrenor a1, Antrenor a2);
    boolean Accept (String attack);

}
