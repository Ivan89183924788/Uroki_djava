package lambda_virajenie;

import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.function.Consumer;
//
//public class MainConsumerLambda {
//    public static void main(String[] args){
//        List<String> orders=List.of("ORD-201","ORD-202","ORD-203");
//
//        Consumer<String> logger=order-> System.out.println("[LOG] Обработка заказа: "+ order);
//        processOrdersSync(orders,logger);
//    }
//    private static void processOrdersSync(List<String> orders,Consumer<String> handler){
//        System.out.println("[SYNC] Старт синхроной обработки заказов...");
//        for(String order:orders){
//            handler.accept(order);
//        }
//        System.out.println("[SYNC] Обработка завершена.");
//    }
//}
