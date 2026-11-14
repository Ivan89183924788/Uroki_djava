//package autoservice.pattern;
//
//import autoservice.model_a.*;
//
//import java.time.Year;
//
//public class VehicleFactory {
//    public static Vehicle_a create(Vihicle_type type,String years,String nomer,String model,String marka,double priceRemont){
//        return switch (type){
//            case CAR -> new Car_a(years,nomer,model,marka,priceRemont,"5 мест",2.0);
//            case TRUCK -> new Truck_a(years,nomer,model,marka,priceRemont,10.0);
//            case MOTOCICLE -> new Motocicle_a(years,nomer,model,marka,priceRemont,1.5,2);
//        };
//    }
//
//    public static Car_a createdCar(String years,String nomer,String model,String marka,double priceRemont,String colMest,double obiem){
//        return new Car_a(years,nomer,model,marka,priceRemont,colMest,obiem);
//    }
//
//    public static Truck_a createdTruck(String years,String nomer,String model,String marka,double priceRemont,double gruzopodyemnosty){
//        return new Truck_a(years,nomer,model,marka,priceRemont,gruzopodyemnosty);
//    }
//
//    public static Motocicle_a createdMotocicle(String years,String nomer,String model,String marka,double priceRemont,double trassa,int coles){
//        return new Motocicle_a(years,nomer,model,marka,priceRemont,trassa,coles);
//    }
//}
