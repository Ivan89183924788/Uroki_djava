//package autoservice.model_a;
//import autoservice.interface_a.Repairable;
//import autoservice.model_a.Vihicle_type;
//
//public class Car_a extends Vehicle_a implements Repairable {
//    private final String col_mest;
//    private final double obiem_dvig;
//
//    public String getCol_mest() {
//        return col_mest;
//    }
//
//    public double getObiem_dvig() {
//        return obiem_dvig;
//    }
//
//    public Car_a(String years, String nomer, String model, String marka,double priceRemont, String col_mest, double obiem_dvig) {
//        super(Vihicle_type.CAR,years, nomer, model, marka,priceRemont);
//        this.col_mest = col_mest;
//        this.obiem_dvig = obiem_dvig;
//    }
//
//    @Override
//    public String toString() {
//        return "Car_a{" +  "years='" + getYears() + '\'' +
//                ", nomer='" + getNomer() + '\'' +
//                ", model='" + getModel() + '\'' +
//                ", marka='" + getMarka() + '\'' +
//                "col_mest='" + col_mest + '\'' +
//                ", obiem_dvig=" + obiem_dvig +
//                '}';
//    }
//
//    @Override
//    public void remont() {
//        System.out.println("Выполнить ремонт автомобиля "+ getMarka());
//    }
//    @Override
//    public String getRemontDescription(){
//        return "Ремонт  автомобиля марка "+getMarka()+" гос.номер "+ getNomer();
//    }
//}
