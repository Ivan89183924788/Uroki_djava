//package control.models;
//
//import java.util.Collections;
//import java.util.List;
//import java.util.ArrayList;
//import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.LinkedBlockingQueue;
//
//public class AutoService {
//    private final BlockingQueue<Vehicle> queue = new LinkedBlockingQueue<>();
////    private final List<Vehicle> repairedList = new ArrayList<>();
//private final List<Vehicle> repairedList = Collections.synchronizedList(new ArrayList<>());
//
//
//    public void addVehicle(Vehicle v) {
//        queue.offer(v);
//        System.out.println("В очередь добавлен: " + v);
//    }
//
//    // ВАЖНО: Параметр теперь List<Mechanic>, а не массив и не одиночный объект
//    public void startService(List<Mechanic> mechanics) throws InterruptedException {
//        System.out.println("\n=== АВТОСЕРВИС ОТКРЫТ ===");
//
//        List<Thread> threads = new ArrayList<>();
//
//        for (Mechanic m : mechanics) {
//            Thread t = new Thread(() -> {
//                while (true) {
//                    try {
//                        // take() блокирует поток, если очередь пуста, и ждет элемент.
//                        // Это надежнее, чем poll(), который сразу вернет null.
//                        Vehicle current = queue.take();
//
//                        m.workOn(current);
//                        repairedList.add(current);
//
//                    } catch (InterruptedException e) {
//                        System.out.println(Thread.currentThread().getName() + " прерван.");
//                        Thread.currentThread().interrupt();
//                        break;
//                    }
//                }
//            }, m.getRole() + " (" + m.getClass().getSimpleName() + ")");
//
//            threads.add(t);
//            t.start();
//        }
//
//        // Ждем завершения всех потоков
//        for (Thread t : threads) {
//            t.join();
//        }
//
//        System.out.println("\n=== АВТОСЕРВИС ЗАКРЫТ ===");
//    }
//
//    public void showRepaired() {
//        System.out.println("\n--- ОТРЕМОНТИРОВАННЫЕ ТРАНСПОРТНЫЕ СРЕДСТВА ---");
//        if (repairedList.isEmpty()) {
//            System.out.println("Ничего не отремонтировано.");
//            return;
//        }
//        synchronized (repairedList) {
//            for (Vehicle v : repairedList) {
//                System.out.println(v.getRemontDescription());
//            }
//        }
//
//    }
//
//}


