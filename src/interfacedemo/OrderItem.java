//package interfacedemo;
//
//public class OrderItem implements Reportable{
//    private final String id;
//    private final double amount;
//    private final boolean isShipped;
//
//    public OrderItem(String id,double amount,boolean isShipped){
//        this.id=id;
//        this.amount=amount;
//        this.isShipped=isShipped;
//    }
//    @Override
//    public boolean isValid(){
//        return amount>0;
//    }
//
//    @Override
//    public String getValidationMessage(){
//        if (amount<=0) return "Ошибка: сумма должна быть положительной";
//        return "OK";
//    }
//
//    @Override
//    public String render(){
//        String status=isShipped?"доставлен": " в обработке";
//        return String.format("Заказ %s: %.2f руб. [%s]",id,amount,status);
//    }
//}
