//package autoservice.model_a;
//
//import autoservice.interface_a.Repairable;
//
//public class Truck_a extends Vehicle_a implements Repairable {
//    private final double gruzopodyemnosty;
//
//    @Override
//    public String toString() {
//        return "Truck_a{"+  "years='" + getYears() + '\'' +
//                ", nomer='" + getNomer() + '\'' +
//                ", model='" + getModel() + '\'' +
//                ", marka='" + getMarka() + '\''   +
//                "gruzopodyemnosty=" + gruzopodyemnosty +
//                '}';
//    }
//
//    public double getGruzopodyemnosty() {
//        return gruzopodyemnosty;
//    }
//
//    public Truck_a(String years, String nomer, String model, String marka,double priceRemont, double gruzopodyemnosty) {
//        super(Vihicle_type.TRUCK, years,nomer, model, marka,priceRemont);
//        this.gruzopodyemnosty = gruzopodyemnosty;
//    }
//    @Override
//    public void remont(){
//        System.out.println("Выполнить ремонт грузовика "+getMarka());
//    }
//    @Override
//    public String getRemontDescription(){
//        return "Ремонт грузового автомобиля марка "+getMarka()+" гос.номер "+ getNomer();
//    }
//}

