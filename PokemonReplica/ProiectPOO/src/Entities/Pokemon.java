package Entities;

public class Pokemon {
    private final String nume;
    private int max_HP = 0;
    private int HP = 0;
    private int attack = 0;
    private int special_attack = 0;
    private int defense = 0;
    private int special_defense = 0;
    private Abilitiy abilitiy1 = null, abilitiy2 = null;
    private Item[] items = new Item[3];
    private int stunned = 0;

    private Pokemon(PokemonBuilder builder) {
       this.nume = builder.nume;
       this.HP = builder.HP;
       this.max_HP = builder.HP;
       this.attack = builder.attack;
       this.defense = builder.defense;
       this.special_attack = builder.special_attack;
       this.special_defense = builder.special_defense;
       this.abilitiy1 = builder.abilitiy1;
       this.abilitiy2 = builder.abilitiy2;
       this.items = builder.items;
    }

    public void Reload() {
        HP = max_HP;
        stunned = 0;
    }
    public void AddStats() {
        max_HP = max_HP + 1;
        if (attack != 0) {
            attack = attack + 1;
        }
        else {
            special_attack = special_attack + 1;
        }
        if (defense != 0) {
            defense = defense + 1;
        }
        else {
            special_defense = special_defense + 1;
        }
    }
    public void AddItemStats() {
        for (Item item : items) {
            if (item.getHp() != 0) {
                max_HP += item.getHp();
                setHP(max_HP);
            }
            if (item.getAttack() != 0) {
                setAttack(getAttack() + item.getAttack());
            }
            if (item.getSpecial_attack() != 0) {
                setSpecial_attack(getSpecial_attack() + item.getSpecial_attack());
            }
            if (item.getDefense() != 0) {
                setDefense(getDefense() + item.getDefense());
            }
            if (item.getSpecial_defense() != 0) {
                setSpecial_defense(getSpecial_defense() + item.getSpecial_defense());
            }
        }
    }

    public String getNume() {
        return nume;
    }

    public int getMax_HP() {
        return max_HP;
    }

    public void setMax_HP(int max_HP) {
        this.max_HP = max_HP;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getSpecial_attack() {
        return special_attack;
    }

    public void setSpecial_attack(int special_attack) {
        this.special_attack = special_attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpecial_defense() {
        return special_defense;
    }

    public void setSpecial_defense(int special_defense) {
        this.special_defense = special_defense;
    }

    public Abilitiy getAbilitiy1() {
        return abilitiy1;
    }

    public Abilitiy getAbilitiy2() {
        return abilitiy2;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public int getStunned() {
        return stunned;
    }

    public void setStunned(int stunned) {
        this.stunned = stunned;
    }

    public boolean Stunned() {
        return stunned != 0;
    }
    public void NotStunned() {
        if (this.Stunned())
            stunned = 0;
    }

    public static class PokemonBuilder {
        private final String nume;
        private int HP, max_HP, attack, defense, special_attack, special_defense;
        private Abilitiy abilitiy1, abilitiy2;
        private Item[] items;

        public PokemonBuilder(String nume) {
            this.nume = nume;
        }
        public PokemonBuilder HP (int HP) {
            this.HP = HP;
            this.max_HP = HP;
            return this;
        }
        public PokemonBuilder attack (int attack) {
            this.attack = attack;
            return this;
        }
        public PokemonBuilder defense(int defense) {
            this.defense = defense;
            return this;
        }
        public PokemonBuilder special_attack (int special_attack) {
            this.special_attack = special_attack;
            return this;
        }
        public PokemonBuilder special_defense (int special_defense) {
            this.special_defense = special_defense;
            return this;
        }
        public PokemonBuilder abilitiy1 (Abilitiy abilitiy1) {
            this.abilitiy1 = abilitiy1;
            return this;
        }
        public PokemonBuilder abilitiy2 (Abilitiy abilitiy2) {
            this.abilitiy2 = abilitiy2;
            return this;
        }
        public PokemonBuilder items (Item[] items) {
            this.items = items;
            return this;
        }
        public Pokemon build() {
            return new Pokemon(this);
        }

    }
    @Override
    public String toString()
    {
        StringBuilder caracteristics = new StringBuilder("Entities.Pokemon{");
        caracteristics.append(this.nume).append(", ");
        caracteristics.append("MAX_HP=").append(this.max_HP).append(", ");
        caracteristics.append("HP=").append(this.HP).append(", ");
        if(attack != 0)
            caracteristics.append("Attack=").append(this.attack).append(", ");
        if(special_attack != 0)
            caracteristics.append("Arene.Strategy.SpecialAttack=").append(this.special_attack).append(", ");
        caracteristics.append("Defense=").append(this.defense).append(", ");
        caracteristics.append("SpecialDefense="+this.special_defense);

        caracteristics.append("}");
        return caracteristics.toString();
    }
}
