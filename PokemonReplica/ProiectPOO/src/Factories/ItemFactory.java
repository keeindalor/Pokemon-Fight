package Factories;

import Entities.Item;

public class ItemFactory {
    public static ItemFactory itemFactory;
    private ItemFactory(){}
    public static ItemFactory GetInstance() {
        if (itemFactory == null) {
            itemFactory = new ItemFactory();
        }
        return itemFactory;
    }
    public Item createItem(String nume) {
        if (nume == null)
            return null;
        switch (nume) {
            case "Scut":
                return new Item.ItemBuilder(nume)
                        .defense(2)
                        .special_defense(2)
                        .build();
            case "Vesta":
                return new Item.ItemBuilder(nume)
                        .hp(10)
                        .build();
            case "Sabiuta":
                return new Item.ItemBuilder(nume)
                        .attack(3)
                        .build();
            case "Bagheta Magica":
                return new Item.ItemBuilder(nume)
                        .special_attack(3)
                        .build();
            case "Vitamine":
                return new Item.ItemBuilder(nume)
                        .hp(2)
                        .attack(2)
                        .special_attack(2)
                        .build();
            case "Brad de Craciun":
                return new Item.ItemBuilder(nume)
                        .attack(3)
                        .defense(1)
                        .build();
            case "Pelerina":
                return new Item.ItemBuilder(nume)
                        .special_defense(3)
                        .build();
        }
        throw new IllegalArgumentException("Nu exista itemul " + nume);
    }
}
