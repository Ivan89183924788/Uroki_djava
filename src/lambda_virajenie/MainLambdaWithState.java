//package lambda_virajenie;
//
//import java.util.List;
//import java.util.function.Consumer;
//
//public class MainLambdaWithState {
//    public static void main(String[] args){
//        int threshold=500;
//
//        Consumer<Double> conditionalLogger=amount->{
//            if(amount>threshold){
//                System.out.println("[HIGH] Сумма "+ amount + " превышает порог "+ threshold);
//            } else {
//                System.out.println("[OK] Сумма "+ amount +" в норме.");
//            }
//        };
//        List<Double> transactions=List.of(300.9,443.5,66.3,63244.6,78.6,5654.0);
//        logTransactionsSync(transactions,conditionalLogger);
//    }
//
//    private static void logTransactionsSync(List<Double> amounts,Consumer<Double> logger){
//        System.out.println("[SYNC] Логирование транзакции...");
//        for(Double amount:amounts){
//            logger.accept(amount);
//        }
//        System.out.println("[SYNC] Готово.");
//    }
//}
