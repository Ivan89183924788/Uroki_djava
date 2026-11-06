//package com.hous.orders;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MainConsoleLogOrders {
//    public static void main(String[] args){
//        ConsoleOrderLogger logger=new ConsoleOrderLogger();
//
//        List<Order> orders=new ArrayList<>();
//
//        orders.add(new SimpleOrder("ORD-201",330.6));
//        orders.add(new PremiumOrder("ORD-202",1330.6,1.2));
//        orders.add(new SimpleOrder("ORD-203",730.6));
//        orders.add(new PremiumOrder("ORD-204",330.6,1.1));
//
//        for(Order o:orders){
//            o.record(logger);
//        }
//        logger.printSummary();
//    }
//}
