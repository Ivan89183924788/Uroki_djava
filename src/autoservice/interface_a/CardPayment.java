//package pizza.interfaces;
//
//public class CardPayment implements Payment {
//    private final String cardNumber;
//
//    public CardPayment(String cardNumber) {
//        this.cardNumber = cardNumber;
//    }
//
//    @Override
//    public boolean pay(double amount) {
//        // Имитация оплаты
//        System.out.println("Оплата картой (последние 4 цифры: " +
//                cardNumber.substring(cardNumber.length() - 4) + ") на сумму " + amount);
//        return true;
//    }
//
//    @Override
//    public String getPaymentType() {
//        return "Card";
//    }
//}
