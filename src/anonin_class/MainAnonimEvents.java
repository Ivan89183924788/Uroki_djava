//package anonin_class;
//
//public class MainAnonimEvents {
//    public static void main(String[] args){
//        EventHsndler handler=new EventHsndler() {
//            @Override
//            public void onEvent(String eventName) {
//                System.out.println("[EVENT] получено событие: "+ eventName);
//                if("ORDER_CREATED".equals(eventName)){
//                    System.out.println("[LOG] Начинаем обработку заказа...");
//                }
//            }
//        };
//        handler.onEvent("ORDER_CREATED");
//        handler.onEvent("PAYMENT_RECEIVED");
//    }
//}
