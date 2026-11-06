//package interfacedemo;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MainPeportableDemo {
//    public static void main(String[] args) {
//        List<Reportable> items = new ArrayList<>();
//        items.add(new OrderItem("ORD-101", 120.3, true));
//        items.add(new OrderItem("ORD-102", 45.7, false));
//        items.add(new OrderItem("ORD-103", 65.3, true));
//        items.add(new OrderItem("ORD-104", 1346.3, false));
//        items.add(new OrderItem("ORD-105", 433.3, true));
//
//        System.out.println("=== Отчет по элементам (Reportable) ===");
//        for(Reportable r:items){
//            if(!r.isValid()){
//                System.out.println("[WARN]"+ r.getValidationMessage());
//            }
//            System.out.println(r.render());
//        }
//    }
//}
