//package pizza.models;
//
//import pizza.enums.OrderStatus;
//import java.util.*;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//
//public class Statistics {
//
//    public static Order getMostExpensive(List<Order> orders) {
//        return orders.stream()
//                .max(Comparator.comparingDouble(Order::calculateTotal))
//                .orElse(null);
//    }
//
//    public static Order getCheapest(List<Order> orders) {
//        return orders.stream()
//                .min(Comparator.comparingDouble(Order::calculateTotal))
//                .orElse(null);
//    }
//
//    public static double getAverageCost(List<Order> orders) {
//        if (orders.isEmpty()) return 0.0;
//        return orders.stream()
//                .mapToDouble(Order::calculateTotal)
//                .average()
//                .orElse(0.0);
//    }
//
//    public static Map<OrderStatus, Long> getCountByStatus(List<Order> orders) {
//        return orders.stream()
//                .collect(Collectors.groupingBy(Order::getStatus, Collectors.counting()));
//    }
//
//    public static Customer getMostActiveCustomer(List<Order> orders, Map<String, Customer> customersById) {
//        Map<String, Long> countByCustomerId = orders.stream()
//                .filter(o -> o.getCustomer() != null)
//                .collect(Collectors.groupingBy(
//                        o -> o.getCustomer().getId(),
//                        Collectors.counting()
//                ));
//
//        String bestId = countByCustomerId.entrySet().stream()
//                .max(Map.Entry.comparingByValue())
//                .map(Map.Entry::getKey)
//                .orElse(null);
//
//        return bestId != null ? customersById.get(bestId) : null;
//    }
//
//    public static String getMostOrderedPizzaName(List<Order> orders) {
//        return orders.stream()
//                .flatMap(o -> o.getPizzas().stream())
//                .collect(Collectors.groupingBy(Pizza::getName, Collectors.counting()))
//                .entrySet().stream()
//                .max(Map.Entry.comparingByValue())
//                .map(Map.Entry::getKey)
//                .orElse(null);
//    }
//
//    public static long countOrdersAboveAmount(List<Order> orders, double amount) {
//        return orders.stream()
//                .filter(o -> o.calculateTotal() > amount)
//                .count();
//    }
//}
