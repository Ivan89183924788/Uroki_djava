//package game.patterns;
//
//import game.model.*;
//import game.model.Character;
//import java.util.Optional;
//
//public class CharacterBuilder {
//    private String name;
//    private CharacterType type;
//    private Weapon weapon;
//    private String armor;
//    private String pet;
//    private String ability;
//
//    public CharacterBuilder setName(String name) { this.name = name; return this; }
//    public CharacterBuilder setType(CharacterType t) { this.type = t; return this; }
//    public CharacterBuilder setWeapon(Weapon w) { this.weapon = w; return this; }
//    public CharacterBuilder setArmor(String a) { this.armor = a; return this; }
//    public CharacterBuilder setPet(String p) { this.pet = p; return this; }
//    public CharacterBuilder setAbility(String ab) { this.ability = ab; return this; }
//
//    public Character build() {
//        Character c = game.patterns.CharacterFactory.create(type, name);
//        if (c instanceof Warrior w && weapon != null) w.equip(weapon);
//        // можно добавить обработку брони/питомца/способности как достижений или эффектов
//        GameLogger.getInstance().log("Создан персонаж: " + name + ", тип: " + type);
//        return c;
//    }
//}
