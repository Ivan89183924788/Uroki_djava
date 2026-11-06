//package pattern.povedencheskie.chain;
//public class CashPayment implements IPayment{
//    private IPayment next;
//    private double balance=10003;
//    @Override
//    public void setNext(IPayment payment){
//        this.next=payment;
//    }
//    @Override
//    public void pay(double amount){
//        if (balance>=amount){
//            System.out.println("Оплата кеш картой");
//            System.out.println("Сумма "+amount+ " руб");
//        } else if(next !=null){
//            System.out.println("На карте недостаточно средств");
//            next.pay(amount);
//        }
//    }
//}