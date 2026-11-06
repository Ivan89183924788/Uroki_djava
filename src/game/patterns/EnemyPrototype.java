//package game.patterns;
//
//import game.model.Character;
//import game.model.Warrior;
//import game.model.Position;
//
//public class EnemyPrototype {
//    private static Character prototype = new Warrior("Стандартный враг");
//
//    public static Character clone() {
//        // упрощённое «клонирование» — создаём нового с теми же параметрами
//        Character clone = new Warrior(prototype.getName() + "_clone");
//        clone.setPosition(prototype.getPosition());
//        return clone;
//    }
//}


//package game.patterns;
//
//import game.model.Character;
//import game.model.Warrior;
//import game.model.Position;  // <-- обязательно
//
//public class EnemyPrototype {
//    private static Character prototype = new Warrior("Стандартный враг");
//
//    public static Character clone() {
//        String cloneName = prototype.getName() + "_clone";
//        Character clone = new Warrior(cloneName);
//
//        // копируем позицию
//        Position originalPos = prototype.getPosition();
//        clone.setPosition(new Position(originalPos.getX(), originalPos.getY()));
//
//        return clone;
//    }
//}


//
//package game.patterns;
//
//import game.model.Character;
//import game.model.Warrior;
//import game.model.Position;  // обязательно импортируем Position
//
//public class EnemyPrototype {
//    private static final Character prototype = new Warrior("Стандартный враг");
//
//        public static Character createClone() {
//        String cloneName = prototype.getName() + "_clone";
//        Character clone = new Warrior(cloneName);
//
//        // Копируем позицию: record даёт методы x() и y()
//        Position originalPos = prototype.getPosition();
//        clone.setPosition(new Position(originalPos.x(), originalPos.y()));
//
//        return clone;
//    }
//}



