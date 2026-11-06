//package final_metod.DTO;
//
//public class PriceUtils {
//    private PriceUtils(){
//        throw new AssertionError("Utility class,do not instantiate");
//    }
//
//    public static double applyDiscount(double amount,double percent){
//        if(percent<0 || percent>100){
//            throw new IllegalArgumentException("Percent must beetwin 0 and 100");
//        }
//        return amount*(100-percent)/100.0;
//    }
//
//    public static String formatPrice(double amount){
//        return String.format("%.2f руб", amount);
//    }
//}
