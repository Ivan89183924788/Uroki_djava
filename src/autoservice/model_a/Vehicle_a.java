//package autoservice.model_a;
//
//import autoservice.interface_a.Repairable;
//
//public class Vehicle_a implements Repairable {
//    private final Vihicle_type type;
//    private final String years;
//    private final String nomer;
//    private final String model;
//    private final String marka;
//    private double priceRemont;
//
//    public double getPriceRemont() {
//        return priceRemont;
//    }
//
//    public Vehicle_a(Vihicle_type type, String years, String nomer, String marka,String model, double priceRemont) {
//        this.type=type;
//        this.years = years;
//        this.nomer = nomer;
//        this.model = model;
//        this.marka = marka;
//        this.priceRemont = priceRemont;
//    }
//
//    public Vihicle_type getType() {
//        return type;
//    }
//
//    @Override
//    public String toString() {
//        return "Vehicle_a{" +
//                "type=" + type +
//                ", years='" + years + '\'' +
//                ", nomer='" + nomer + '\'' +
//                ", model='" + model + '\'' +
//                ", marka='" + marka + '\'' +
//                ", priceRemont=" + priceRemont +
//                '}';
//    }
//
//    public String getYears() {
//        return years;
//    }
//
//    public String getNomer() {
//        return nomer;
//    }
//
//    public String getModel() {
//        return model;
//    }
//
//    public String getMarka() {
//        return marka;
//    }
//    @Override
//    public String getRemontDescription(){
//        return "Ремонт транспорта";
//    }
//
//
//    @Override
//    public void remont(){
//        System.out.println("Выполнить ремонт транспорта "+marka);
//    }
//        public void setPrice(double price) {
//        if (price < 0) throw new IllegalArgumentException("Price cannot be negative");
//        this.priceRemont = price;
//    }
//
//}
