//package pizza.utils;
//
//import pizza.enums.OrderStatus;
//import java.util.Queue;
//import java.util.concurrent.TimeUnit;
//
//public class CookingSimulator implements Runnable {
//    private final Queue<String> queue; // храним номера заказов
//    private final java.util.Map<String, pizza.models.Order> ordersById;
//    private volatile boolean running = true;
//
//    public CookingSimulator(Queue<String> queue, java.util.Map<String, pizza.models.Order> ordersById) {
//        this.queue = queue;
//        this.ordersById = ordersById;
//    }
//
//    @Override
//    public void run() {
//        while (running) {
//            String number = queue.poll();
//            if (number == null) {
//                // Нет заказов — ждём
//                try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) {}
//                continue;
//            }
//
//            pizza.models.Order o = ordersById.get(number);
//            if (o == null) continue;
//
//            // NEW -> COOKING
//            o.changeStatus(OrderStatus.COOKING);
//            pizza.patterns.Logger.getInstance().log("Заказ " + number + " перешёл в статус COOKING");
//
//            try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) {}
//
//            // COOKING -> READY
//            o.changeStatus(OrderStatus.READY);
//            pizza.patterns.Logger.getInstance().log("Заказ " + number + " готов (READY)");
//        }
//    }
//
//    public void stop() {
//        running = false;
//    }
//}
