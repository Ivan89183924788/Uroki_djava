//package game.model;
//
//import game.interfaces.Attackable;
//import game.interfaces.Healable;
//import game.model.CharacterType;
//
//public class Warrior extends Character{
//    private Weapon weapon;
//
//    public Warrior(String name){
//        super(name,CharacterType.WARRIOR);
//    }
//    public void equip(Weapon w){weapon=w;}
//    @Override
//    public int attack(Attackable target){
//        int base=15;
//        int extra=(weapon !=null)?weapon.getDamage():0;
//        int total=base+extra;
//        if (target instanceof Healable h)h.heal(-total);
//        return total;
//    }
//}
