//package game.model;
//
//import game.interfaces.Attackable;
//import game.interfaces.Healable;
//
//public abstract class Character implements Attackable, Healable {
//    protected String name;
//    protected int level;
//    protected int health;
//    protected final CharacterType type;
//    protected Position position;
//
//    protected Character(String name, CharacterType type) {
//        this.name = name;
//        this.type = type;
//        this.level = 1;
//        this.health = 100;
//        this.position = new Position(0, 0);
//    }
//
//    public CharacterType getType() { return type; }
//    public String getName() { return name; }
//    public int getLevel() { return level; }
//    public Position getPosition() { return position; }
//
//    public void setPosition(Position pos) { this.position = pos; }
//    public void gainExp(int exp) { /* можно усложнить: повышать уровень */ }
//
//    @Override
//    public int getHealth() { return health; }
//
////    @Override
////    public void heal(int amount) {
////        health = Math.min(100, health + amount);
////    }
//
////    public void heal(int amount) {
////        health = Math.max(0, Math.min(100, health + amount));
////    }
//    @Override
//    public void heal(int amount) {
//        System.out.println("[" + this.getName() + "] heal called with amount=" + amount);
//        health = Math.max(0, Math.min(100, health + amount));
//    }
//
//
//    // Полиморфная атака: базовая реализация
//    @Override
//    public int attack(Attackable target) {
//        int damage = 10; // базовый урон
//        if (target instanceof Healable h) {
//            h.heal(-damage); // упрощённо: считаем отрицательный heal как урон
//        }
//        return damage;
//    }
//}

