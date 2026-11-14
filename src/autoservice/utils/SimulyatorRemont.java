//package autoservice.utils;
//
//import autoservice.enum_a.RepairStatus;
//import autoservice.model_a.RepairOrder_a;
//import autoservice.pattern.Logger;
//
//import java.time.LocalDate;
//import java.util.Map;
//import java.util.Queue;
//import java.util.concurrent.TimeUnit;
//
//public class SimulyatorRemont implements Runnable{
//    private final Queue<String> queue;
//    private final Map<String, RepairOrder_a> repairOrdersById;
//    private volatile boolean running=true;
//
//    public SimulyatorRemont(Queue<String> queue, Map<String, RepairOrder_a> repairOrdersById) {
//        this.queue = queue;
//        this.repairOrdersById = repairOrdersById;
//    }
//
//    @Override
//    public void run() {
//        while (running) {
//            String number = queue.poll();
//            if (number == null) {
//                try {
//                    TimeUnit.SECONDS.sleep(3);
//                } catch (InterruptedException e) {
//                }
//                continue;
//            }
//            RepairOrder_a o = repairOrdersById.get(number);
//            if (o == null) continue;
//
//            o.changeStatus(RepairStatus.REPAIR);
//            Logger.getInstance().log("Заказ " + number + " перешел в статус REPAIR");
//
//            try {
//                TimeUnit.SECONDS.sleep(4);
//            } catch (InterruptedException e) {
//
//            }
//            o.changeStatus(RepairStatus.COMPLETED);
//            Logger.getInstance().log("Заказ " + number + " готов(COMPLETED)");
//        }
//    }
//    public void stop(){
//        running =false;
//    }
//}
