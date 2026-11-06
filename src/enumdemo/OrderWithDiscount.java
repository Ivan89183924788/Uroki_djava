//package enumdemo;
//
//public class OrderWithDiscount {
//    private final String id;
//    private final double baseAmount;
//    private final DiscontType discontType;
//
//    public OrderWithDiscount(String id,double baseAmount,DiscontType discontType){
//        this.id=id;
//        this.baseAmount=baseAmount;
//        this.discontType=discontType;
//    }
//
//    public double getFinalAmount(){
//        return discontType.apply(baseAmount);
//    }
//
//    public String getDescription(){
//        String typeName=discontType.name();
//        String val=switch (discontType){
//            case PERCENT->discontType.getValue()+"%";
//            case FIXED->discontType.getValue()+" руб";
//            case NONE->"без скидки";
//        };
//        return id+": "+baseAmount+"->"+getFinalAmount();
//
//    };
////    private double value(){
////        return discontType.getValue();
////    }
//
//}
