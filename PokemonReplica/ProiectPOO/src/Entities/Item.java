package Entities;

public class Item {
    private final String nume;
    private int hp = 0;
    private int attack = 0;
    private int special_attack = 0;
    private int defense = 0;
    private int special_defense = 0;

    private Item(ItemBuilder builder) {
       this.nume = builder.nume;
       this.hp = builder.hp;
       this.attack = builder.attack;
       this.defense = builder.defense;
       this.special_attack = builder.special_attack;
       this.special_defense = builder.special_defense;
    }

    public String getNume() {
        return nume;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getSpecial_attack() {
        return special_attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpecial_defense() {
        return special_defense;
    }

    public static class ItemBuilder {

        private int hp, attack, special_attack, defense, special_defense;
        private final String nume;

        public ItemBuilder (String nume) {
            this.nume = nume;
        }
        public ItemBuilder hp (int hp) {
            this.hp = hp;
            return this;
        }
        public ItemBuilder attack (int attack) {
            this.attack = attack;
            return this;
        }
        public ItemBuilder defense(int defense) {
            this.defense = defense;
            return this;
        }
        public ItemBuilder special_attack (int special_attack) {
            this.special_attack = special_attack;
            return this;
        }
        public ItemBuilder special_defense (int special_defense) {
            this.special_defense = special_defense;
            return this;
        }
        public Item build() {
            return new Item(this);
        }
    }

}
