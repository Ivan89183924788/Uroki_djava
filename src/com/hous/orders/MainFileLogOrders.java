//package com.hous.orders;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class MainFileLogOrders {
//    public static void main(String[] args){
//        try{
//            FileOrderLogger logger=new FileOrderLogger("orders.log");
//
//            List<Order> orders=new ArrayList<>();
//            orders.add(new SimpleOrder("ORD-101",1200.0));
//            orders.add(new PremiumOrder("ORD-102",17000.0,1.2));
//            orders.add(new SimpleOrder("ORD-103",1260.0));
//            orders.add(new PremiumOrder("ORD-104",15000.0,1.5));
//
//            for (Order o:orders){
//                o.record(logger);
//            }
//            logger.close();
//            System.out.println("Заказа записаны в orders.log");
//        } catch (IOException e){
//            System.out.println("Ошибка работы с файлом: "+ e.getMessage());
//        }
//    }
//}
