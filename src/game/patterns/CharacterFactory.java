//package game.patterns;
//
//import game.model.*;
//import game.model.Character;
//
//public class CharacterFactory {
//    public static Character create(CharacterType type, String name) {
//        switch (type) {
//            case WARRIOR -> new Warrior(name);
//            case MAGE -> new Mage(name);
//            case ARCHER -> new Archer(name);
//            default -> throw new IllegalArgumentException("Неизвестный тип");
//        }
//    }
//}

//package game.patterns;
//import game.model.Character;
//
//import game.model.*;
//
//public class CharacterFactory {
//    public static Character create(CharacterType type, String name) {
//        switch (type) {
//            case WARRIOR:
//                return new Warrior(name);
//            case MAGE:
//                return new Mage(name);
//            case ARCHER:
//                return new Archer(name);
//            default:
//                throw new IllegalArgumentException("Неизвестный тип");
//        }
//    }
//}
