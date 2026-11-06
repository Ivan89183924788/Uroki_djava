//package com.hous.orders;
//
//public class PremiumOrder extends Order{
//    private final double premiumRate;
//
//    public PremiumOrder(String id,double amount,double premiumRate){
//        super(id, amount);
//        this.premiumRate=premiumRate;
//    }
//    @Override
//    public double getFinalAmount(){
//        return amount*premiumRate;
//    }
//    @Override
//    public String getDescription(){
//        return "премиум-заказ (наценка х"+ premiumRate+")";
//    }
//}
