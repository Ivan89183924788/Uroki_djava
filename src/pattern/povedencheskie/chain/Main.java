//package pattern.povedencheskie.chain;
//
//public class Main {
//    public static void main(String[] args){
//        IPayment card=new CardPayment();
//        IPayment cash=new CashPayment();
//        IPayment sbp=new SbpPayment();
//        card.setNext(sbp);
//        sbp.setNext(cash);
//        card.pay(6000);
//    }
//}
