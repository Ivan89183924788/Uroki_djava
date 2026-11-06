//package pizza.models;
//
//import java.util.Comparator;
//
//public class OrderComparators {
//    public static final Comparator<Order> BY_NUMBER =
//            Comparator.comparing(Order::getOrderNumber);
//
//    public static final Comparator<Order> BY_CUSTOMER_NAME =
//            Comparator.comparing(o -> o.getCustomer() == null ? "" : o.getCustomer().getName());
//
//    public static final Comparator<Order> BY_TOTAL =
//            Comparator.comparingDouble(Order::calculateTotal);
//}
