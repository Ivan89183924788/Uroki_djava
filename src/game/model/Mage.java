//package game.model;
//
//import game.interfaces.Attackable;
//import game.interfaces.Healable;
//
//public class Mage extends Character{
//    public Mage(String name){
//        super(name,CharacterType.MAGE);
//    }
//    @Override
//    public int attack(Attackable target){
//        int dmg=20+(int)(Math.random()*10);
//        if(target instanceof Healable h) h.heal(-dmg);
//        return dmg;
//    }
//    @Override
//    public void heal(int amount){
//        super.heal(amount*2);
//    }
//}
