//package game.model;
//
//import game.collections.Inventory;
//import game.exceptions.GameException;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//public class Player implements Comparable<Player>{
//    private final int id;
//    private String  name;
//    private Character character;
//    private long gold;
//    private Inventory<Object> inventory;
//    private List<Quest> quests;
//    private Set<String> achievements;
//
//    public int getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public long getGold() {
//        return gold;
//    }
//
//    public void addGold(long amount){gold+=amount;};
//    public void spendGold(long amount) throws GameException {
//        if (gold < amount) throw new GameException("Недостаточно золота");
//        gold-=amount;
//    }
//
//    public void setCharacter(Character c){character=c;}
//
//    public Character getCharacter() {
//        return character;
//    }
//
//    public Inventory<Object> getInventory() {
//        return inventory;
//    }
//
//    public List<Quest> getQuests() {
//        return quests;
//    }
//
//    public Set<String> getAchievements() {
//        return achievements;
//    }
//
//    public void completeQuest(Quest q){
//        q.complete();
//        achievements.add("Выполнено: "+ q.getTitle());
//    }
//
////    public Player(int id, String name, long gold) {
////        this.id = id;
////        this.name = name;
////        this.gold = gold;
////        this.inventory = inventory;
////        this.quests = quests;
////        this.achievements = achievements;
////    }
//public Player(int id, String name) {
//    this.id = id;
//    this.name = name;
//    this.gold = 0;
//    // инициализируем коллекции, чтобы не было NullPointerException
//    this.inventory = new Inventory<>();
//    this.quests = new ArrayList<>();
//    this.achievements = new HashSet<>();
//    // character пока null — нормально
//}
//
////
////    @Override
////    public int compareTo(Player other){
////        return Long.compare(this.gold,other.gold);
////    }
//
//    @Override
//    public int compareTo(Player other) {
//        int goldCompare = Long.compare(other.gold, this.gold); // сортировка по убыванию золота
//        if (goldCompare != 0) return goldCompare;
//        return Integer.compare(this.id, other.id); // при равном золоте — по ID
//    }
//
//
//    @Override
//    public boolean equals(Object o){
//        if(this==o) return true;
//        if(!(o instanceof Player p)) return false;
//        return id==p.id;
//
//    }
//
//    @Override
//    public int hashCode(){return Integer.hashCode(id);}
//
//    @Override
//    public String toString(){
//        String charName=(character==null)? "без персонажа":character.getName();
//        return "Player{id=" + id + ", name='" + name + "', char='" + charName + "', gold=" + gold + "}";
//    }
//
//
//}
