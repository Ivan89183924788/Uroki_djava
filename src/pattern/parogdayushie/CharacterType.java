//package pattern.factory;
//
//
//public enum CharacterType { WARRIOR, MAGE, ARCHER }
//
//abstract class Character {
//    protected String name;
//    Character(String name) { this.name = name; }
//    public abstract void attack();
//}
//
//class Warrior extends Character {
//    Warrior(String name) { super(name); }
//    @Override public void attack() { System.out.println(name + " бьёт мечом!"); }
//}
//
//class Mage extends Character {
//    Mage(String name) { super(name); }
//    @Override public void attack() { System.out.println(name + " кидает огненный шар!"); }
//}
//
//class Archer extends Character {
//    Archer(String name) { super(name); }
//    @Override public void attack() { System.out.println(name + " стреляет из лука!"); }
//}
//
//class CharacterFactory {
//    public static Character create(CharacterType type, String name) {
//        switch (type) {
//            case WARRIOR -> {
//                System.out.println("[Factory] Создан Warrior");
//                return new Warrior(name);
//            }
//            case MAGE -> {
//                System.out.println("[Factory] Создан Mage");
//                return new Mage(name);
//            }
//            case ARCHER -> {
//                System.out.println("[Factory] Создан Archer");
//                return new Archer(name);
//            }
//            default -> throw new IllegalArgumentException("Неизвестный тип");
//        }
//    }
//}
//
//class Main {
//    public static void main(String[] args) {
//        Character c1 = CharacterFactory.create(CharacterType.WARRIOR, "Алекс");
//        Character c2 = CharacterFactory.create(CharacterType.MAGE, "Борис");
//        c1.attack();
//        c2.attack();
//    }
//}


