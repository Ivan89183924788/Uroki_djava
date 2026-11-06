//package pattern.singleton;
//
//public class GameLogger {
//    private GameLogger(){
//        System.out.println("[Logger] Создан логгер");
//    }
//
//    private static final GameLogger INSTANCE =new GameLogger();
//
//    public static GameLogger getInstance(){
//        return INSTANCE;
//    }
//
//    public void log(String msg){
//        System.out.println("[LOG] "+msg);
//    }
//}
//
//class Main{
//    public static void main(String[] args){
//        GameLogger l1=GameLogger.getInstance();
//        GameLogger l2=GameLogger.getInstance();
//
//        l1.log("Старт сервера");
//        l2.log("Устал Старт сервера");
//        System.out.println("l1==l2? "+(l1==l2));
//    }
//}
