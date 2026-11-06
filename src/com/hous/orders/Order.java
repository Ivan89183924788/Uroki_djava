//package com.hous.orders;
//
//public abstract class Order {
//    protected final String id;
//    protected double amount;
//
//    public Order(String id,double amount){
//        this.id=id;
//        this.amount=amount;
//    }
//
//    public abstract double getFinalAmount();
//    public abstract String getDescription();
//
//    public void record(OrderLogger logger){
//        String msg="Заказы "+id+"("+getDescription()+") -итого: "+getFinalAmount();
//        logger.log(msg);
//    }
//}
