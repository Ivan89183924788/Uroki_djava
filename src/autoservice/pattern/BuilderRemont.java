//package autoservice.pattern;
//
//import autoservice.enum_a.RepairStatus;
//import autoservice.enum_a.Srochnosty;
//import autoservice.interface_a.Payment;
//import autoservice.model_a.Client_a;
//import autoservice.model_a.RepairOrder_a;
//import autoservice.model_a.Vehicle_a;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//public class BuilderRemont {
//    private final String orderNumber;
//    private final Client_a client_a;
//    private final List<Vehicle_a> vehicle_a=new ArrayList<>();
//    private LocalDate dataRemont;
//    private RepairStatus statusRemont;
//    private Srochnosty srochnosty;
//    private String comment;
//    private final List<String> raboty=new ArrayList<>();
//    private final List<String> dopraboty=new ArrayList<>();
//
//    public BuilderRemont(String orderNumber, Client_a client_a, LocalDate dataRemont) {
//        this.orderNumber = orderNumber;
//        this.client_a = client_a;
//        this.dataRemont = dataRemont;
//    }
//
//    public BuilderRemont setVehicle(Vehicle_a vehicle){
//        vehicle_a.add(vehicle);
//        return this;
//    }
//
//    public BuilderRemont setRabota_1(String rabota){
//        raboty.add(rabota);
//        return this;
//    }
//
//    public BuilderRemont setRaboty(List<String> raboty){
//        this.raboty.addAll(raboty);
//        return this;
//    }
//
//    public BuilderRemont setDopRabota(String dopRab){
//        dopraboty.add(dopRab);
//        return this;
//    }
//    public BuilderRemont setSrochnosty(Srochnosty srochnosty){
//        this.srochnosty=srochnosty;
//        return this;
//    }
//
//    public BuilderRemont setComment(String comment){
//        this.comment=comment;
//        return this;
//    }
//
//    public BuilderRemont setStatusRemont(RepairStatus statusRemont){
//        this.statusRemont=statusRemont;
//        return this;
//    }
//
//    public RepairOrder_a build(){
//        if(orderNumber==null || orderNumber.isBlank()){
//            throw new IllegalArgumentException("Номер заказа обязателен");
//        }
//        if (client_a==null){
//            throw new IllegalArgumentException("Клиент обязателен");
//        }
//        if(dataRemont==null){
//            throw new IllegalArgumentException("Дата ремонта обязательна");
//        }
//        return new RepairOrder_a(orderNumber,client_a,dataRemont,statusRemont,
//        srochnosty,comment,raboty,dopraboty,vehicle_a);
//    }
//}
