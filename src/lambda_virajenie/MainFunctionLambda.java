//package lambda_virajenie;
//
//import java.util.function.Function;
//
//public class MainFunctionLambda {
//    public static void main(String[] args){
//        double amount=1000.0;
//
//        Function<Double,Double> percentDiscount=amt->amt*(1-0.15);
//        Function<Double,Double> fixedDiscount=amt->Math.max(0,amt-200);
//
//        System.out.println("Сумма до скидки: "+ amount);
//        System.out.println("С процентной скидкой: "+ applyDiscountSync(amount,percentDiscount));
//        System.out.println("С фиксированной скидкой: "+applyDiscountSync(amount,fixedDiscount));
//    }
//    private static double applyDiscountSync(double amount,Function<Double,Double> discountStrategy){
//        return discountStrategy.apply(amount);
//    }
//}
