//package game.model;
//
//import game.interfaces.Attackable;
//import game.interfaces.Healable;
//
//public class Archer extends Character{
//    public Archer(String name){
//        super(name,CharacterType.ARCHER);
//    }
//
//    @Override
//    public int attack(Attackable target){
//        int dmg=12;
//        if (Math.random()<0.2) dmg*=2;
//        if(target instanceof Healable h) h.heal(-dmg);
//        return dmg;
//    }
//}
