//package pattern.prototype;
//interface Prototype<T>{
//    T clone();
//}
//class Enemy implements Prototype<Enemy> {
//    private String name;
//    private int hp;
//
//    Enemy(String name,int hp){
//        this.name=name;
//        this.hp=hp;
//    }
//
//    @Override
//    public Enemy clone(){
//        System.out.println("[Prototype] Клонирован враг: "+ name);
//        return new Enemy(this.name,this.hp);
//    }
//    void info(){
//        System.out.println(name+",HP="+hp);
//    }
//}
//
//class Main{
//    public static void main(String[] args){
//        Enemy original=new Enemy("Гоблин",56);
//        original.info();
//
//        Enemy clone1=original.clone();
//        clone1.info();
//    }
//}
