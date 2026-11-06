//package pizza.patterns;
//
//import pizza.interfaces.CardPayment;
//import pizza.interfaces.CashPayment;
//import pizza.interfaces.Payment;
//import pizza.interfaces.SbpPayment;
//
//public class PaymentFactory {
//    public static Payment createPayment(String type, String details) {
//        switch (type.toLowerCase()) {
//            case "card":
//                return new CardPayment(details);
//            case "cash":
//                return new CashPayment(details);
//            case "sbp":
//                return new SbpPayment(details);
//            default:
//                throw new IllegalArgumentException("Unknown payment type: " + type);
//        }
//    }
//}
