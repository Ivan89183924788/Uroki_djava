//package enumdemo;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MainDiscountDemo {
//    public static void main(String[] args){
//        List<OrderWithDiscount> orders=new ArrayList<>();
//        orders.add(new OrderWithDiscount("ORD-301",1500.0,DiscontType.PERCENT));
//        orders.add(new OrderWithDiscount("ORD-302",800.0,DiscontType.FIXED));
//        orders.add(new OrderWithDiscount("ORD-303",200.0,DiscontType.FIXED));
//        orders.add(new OrderWithDiscount("ORD-304",999.0,DiscontType.NONE));
//
//        System.out.println("=== Скидки через enum ===");
//        for(OrderWithDiscount o:orders){
//            System.out.println(o.getDescription());
//        }
//    }
//}
