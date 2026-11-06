//package pattern.builder;
//
//import pattern.factory.CharacterType;
//
//record Position(int x, int y){}
//
//class CharacterData{
//    final String name;
//    final CharacterType type;
//    final Position spawn;
//    final int level;
//
//    private CharacterData(String name,CharacterType type,Position spawn,int level){
//        this.name=name;
//        this.type=type;
//        this.spawn=spawn;
//        this.level=level;
//    }
//
//    static class Builder{
//        private String name;
//        private CharacterType type;
//        private Position spawn=new Position(0,0);
//        private int level=1;
//
//        Builder name(String name){this.name=name; return this;}
//        Builder type(CharacterType type){this.type=type;return this;}
//        Builder spawn(Position spawn){this.spawn=spawn;return this;}
//        Builder level(int level){this.level=level; return this;}
//
//        CharacterData build(){
//            if(name==null || name.isBlank()) throw new IllegalStateException("name обязателен");
//            System.out.println("[Builder] Сборка персонажа: "+ name);
//            return new CharacterData(name,type,spawn,level);
//        }
//
//    }
//    static Builder builder(){return new Builder();}
//
//    @Override
//    public String toString(){
//        return name+"("+type+"),уровень "+ level+",спавн "+spawn;
//    }
//}
//
//class Main{
//    public static void main(String[] args){
//        CharacterData c=CharacterData.builder()
//                .name("Эльмира")
//                .type(CharacterType.ARCHER)
//                .spawn(new Position(12,44))
//                .level(5)
//                .build();
//        System.out.println(c);
//    }
//}

