package Arene.Strategy;

import Entities.Antrenor;

public class NormalAttack implements Strategy {
    String log;

    public NormalAttack() {
        this.log = "";
    }

    @Override
    public String Attack(Antrenor aliat, Antrenor inamic) {
        int damage_produs;
        if (aliat.pokemonCurent.Stunned()) {
            damage_produs = 0;
            log += "\t\t" + aliat.pokemonCurent.getNume() + " cannot attack this round because is stunned\n";
            aliat.pokemonCurent.setStunned(0);
            return log;
        }
        if (inamic.currentAttack.equals("Ability1") && inamic.pokemonCurent.getAbilitiy1().isDodge()) {
            damage_produs = 0;
            log += "\t\t" + aliat.pokemonCurent.getNume() + " has attacked but " + inamic.pokemonCurent.getNume() +
                    "has dodged the damaged\n";
            return log;
        }
        if (inamic.currentAttack.equals("Ability2") && inamic.pokemonCurent.getAbilitiy2().isDodge()) {
            damage_produs = 0;
            log += "\t\t" + aliat.pokemonCurent.getNume() + " has attacked but " + inamic.pokemonCurent.getNume() +
                    "has dodged the damaged\n";
            return log;
        }
        if (inamic.pokemonCurent.getDefense() > aliat.pokemonCurent.getAttack()){
            damage_produs = 0;
        }
        else {
            damage_produs = aliat.pokemonCurent.getAttack() - inamic.pokemonCurent.getDefense();
        }
        inamic.pokemonCurent.setHP(inamic.pokemonCurent.getHP() - damage_produs);
        log += "\t\t" + aliat.pokemonCurent.getNume() + " attacked " + inamic.pokemonCurent.getNume() +
                " using normal attack (-" + damage_produs + " HP).\n" + "\t\t" + inamic.pokemonCurent.getNume() + " " +
                inamic.pokemonCurent.getHP() + " HP left\n";
        return log;
    }

    @Override
    public boolean Accept(String attack) {
        return attack.equals("Normal");
    }

}
