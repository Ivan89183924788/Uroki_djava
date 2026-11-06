//package enumdemo;
//
//public enum DiscontType {
//    PERCENT(15.0){
//        @Override
//        public double apply(double amount){
//            return amount*(100-getValue())/100.0;
//        }
//    },
//    FIXED(200.0){
//        @Override
//        public double apply(double amount){
//            double result=amount -getValue();
//            return Math.max(0,result);
//        }
//    },
//    NONE(0.0){
//        @Override
//        public double apply(double amount){
//            return amount;
//        }
//    };
//
//    private  final double value;
//
//    DiscontType(double value){
//        this.value=value;
//    }
//
//    public abstract double apply(double amount);
//
//    public double getValue(){
//        return value;
//    }
//}
