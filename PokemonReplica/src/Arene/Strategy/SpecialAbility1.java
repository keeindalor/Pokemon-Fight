package Arene.Strategy;

import Entities.Antrenor;

public class SpecialAbility1 implements Strategy{
    String log;

    public SpecialAbility1() {
        this.log = "";
    }

    @Override
    public String Attack(Antrenor aliat, Antrenor inamic) {
        int damage_produs;
        aliat.pokemonCurent.getAbilitiy1().setRemainingCd(aliat.pokemonCurent.getAbilitiy1().getCd());
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
                    " has dodged the damaged\n";
            return log;
        }

        if (aliat.pokemonCurent.getAbilitiy2().isStun()) {
            inamic.pokemonCurent.setStunned(1);
        }
        inamic.pokemonCurent.setHP(inamic.pokemonCurent.getHP() - aliat.pokemonCurent.getAbilitiy1().getDamage());

        damage_produs = aliat.pokemonCurent.getAbilitiy1().getDamage();
        log += "\t\t" + aliat.pokemonCurent.getNume() + " attacked " + inamic.pokemonCurent.getNume() +
                " using Special Ability 1 (-" + damage_produs + " HP).\n" + "\t\t" + inamic.pokemonCurent.getNume() + " " +
                inamic.pokemonCurent.getHP() + " HP left\n" + "\t\t" + aliat.pokemonCurent.getNume() + " special ability:" +
        aliat.pokemonCurent.getAbilitiy1().getRemainingCd() + " CD, damage:" + aliat.pokemonCurent.getAbilitiy1().getDamage()
        + " dodge: " + aliat.pokemonCurent.getAbilitiy1().isDodge() + " stun: " + aliat.pokemonCurent.getAbilitiy1().isStun() + "\n";
        return log;
    }

    @Override
    public boolean Accept(String attack) {
        return attack.equals("Ability1");
    }
}
