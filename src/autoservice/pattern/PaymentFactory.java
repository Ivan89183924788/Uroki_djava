//package autoservice.pattern;
//
//import autoservice.interface_a.CardPayment;
//import autoservice.interface_a.CashPayment;
//import autoservice.interface_a.Payment;
//import autoservice.interface_a.SbpPayment;
//
//import java.util.Locale;
//
//public class PaymentFactory {
//    public static Payment create(String paymentType,String param){
//        return switch (paymentType.toLowerCase()){
//            case "card"->new CardPayment(param);
//            case "cash"-> new CashPayment(param);
//            case "sbp"-> new SbpPayment(param);
//            default -> throw new IllegalArgumentException(
//                    "Неизвестный способ оплаты: "+ paymentType
//            );
//        };
//    }
//}
