package Arene.Strategy;

import Entities.Antrenor;

public class SpecialAttack implements Strategy{
    String log;

    public SpecialAttack() {
        this.log ="";
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
        if (inamic.pokemonCurent.getSpecial_defense() > aliat.pokemonCurent.getSpecial_attack()){
            damage_produs = 0;
        }
        else {
            damage_produs = aliat.pokemonCurent.getSpecial_attack() - inamic.pokemonCurent.getSpecial_defense();
        }
        log += "\t\t" + aliat.pokemonCurent.getNume() + " attacked " + inamic.pokemonCurent.getNume() +
                " using special attack (-" + damage_produs + " HP).\n" + "\t\t" + inamic.pokemonCurent.getNume() + " " +
                inamic.pokemonCurent.getHP() + " HP left\n";
        inamic.pokemonCurent.setHP(inamic.pokemonCurent.getHP() - damage_produs);
        return log;
    }

    @Override
    public boolean Accept(String attack) {
        return attack.equals("Special");
    }
}
