//package final_metod.DTO;
//
//public abstract class PaymentMethod {
//    protected final String name;
//
//    public PaymentMethod(String name){
//        this.name=name;
//    }
//    public abstract double calculateFee(double amount);
//
//    public final void process(double amount){
//        double fee=calculateFee(amount);
//        double total=amount+fee;
//        System.out.println("[PAYMENT] Метод: "+ name+ "| Сумма: "+ amount+
//                "| Комиссия: "+ fee +"| Итого: "+ total);
//    }
//}
