//package pizza.interfaces;
//
//public class SbpPayment implements Payment {
//    private final String phoneNumber; // номер телефона для СБП
//
//    public SbpPayment(String phoneNumber) {
//        if (phoneNumber == null || phoneNumber.isBlank()) {
//            throw new IllegalArgumentException("Номер телефона для СБП не может быть пустым");
//        }
//        this.phoneNumber = phoneNumber;
//    }
//
//    @Override
//    public boolean pay(double amount) {
//        // Имитация перевода через СБП
//        System.out.println("Перевод через СБП на номер " + phoneNumber + " на сумму " + amount);
//        return true;
//    }
//
//    @Override
//    public String getPaymentType() {
//        return "SBP";
//    }
//}
