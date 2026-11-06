//package pizza.utils;
//
//import pizza.models.Order;
//import pizza.models.Customer;
//import java.io.*;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.List;
//
//public class DataPersistence {
//    private static final String FILE_PATH = "completed_orders.txt";
//
//    public static void saveCompletedOrders(List<Order> allOrders) {
//        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH, false))) {
//            for (Order o : allOrders) {
//                if (o.getStatus() == pizza.enums.OrderStatus.COMPLETED) {
//                    writer.println(serializeOrder(o));
//                }
//            }
//        } catch (IOException e) {
//            pizza.patterns.Logger.getInstance().log("Ошибка при сохранении заказов: " + e.getMessage());
//        }
//    }
//
//    public static List<Order> loadOrders() {
//        List<Order> loaded = new java.util.ArrayList<>();
//        if (!Files.exists(Paths.get(FILE_PATH))) {
//            return loaded;
//        }
//        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                Order o = deserializeOrder(line);
//                if (o != null) loaded.add(o);
//            }
//        } catch (IOException e) {
//            pizza.patterns.Logger.getInstance().log("Ошибка при чтении заказов: " + e.getMessage());
//        }
//        return loaded;
//    }
//
//    // Очень простой формат: number|customerName|total|status
//    private static String serializeOrder(Order o) {
//        return o.getOrderNumber() + "|" +
//                o.getCustomer().getName() + "|" +
//                o.calculateTotal() + "|" +
//                o.getStatus();
//    }
//
//    private static Order deserializeOrder(String line) {
//        String[] parts = line.split("\\|", -1);
//        if (parts.length < 4) return null;
//        // Для простоты: создаём «заглушку» заказа — в реальном проекте нужно хранить все поля
//        // Здесь мы просто восстанавливаем базовую информацию для статистики
//        String number = parts[0];
//        String customerName = parts[1];
//        double total = Double.parseDouble(parts[2]);
//        pizza.enums.OrderStatus status = pizza.enums.OrderStatus.valueOf(parts[3]);
//
//        // Создаём фиктивного клиента (для демо)
//        Customer c = new Customer("loaded_" + number, customerName);
//        Order o = new Order(number, c);
//        o.changeStatus(status);
//        // В этом простом формате мы не можем восстановить список пицц,
//        // поэтому для полноценной загрузки нужно хранить JSON/XML или свой формат.
//        return o;
//    }
//}

