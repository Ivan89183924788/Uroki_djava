////package autoservice.model_a;
////
////import autoservice.enum_a.RepairStatus;
////import autoservice.enum_a.Srochnosty;
////import autoservice.interface_a.Payment;
////
////import java.time.LocalDate;
////import java.time.format.DateTimeParseException;
////import java.util.*;
////
////public class RepairOrder_a implements Comparable<RepairOrder_a> {
////    private final String orderNumber;
////    private final Client_a client_a;
////
////
////
////    private final List<Vehicle_a> vehicle_a=new ArrayList<>();
////    private Payment payment;
////    private LocalDate dataRemont;
////    private RepairStatus statusRemont;
////    private Srochnosty srochnosty;
////    private String comment;
////    private final List<String> raboty=new ArrayList<>();
////    private final List<String> dopraboty=new ArrayList<>();
////
////    public RepairOrder_a(String orderNumber, Client_a client_a, LocalDate dataRemont,
////                         RepairStatus statusRemont, Srochnosty srochnosty, String comment,
////                         List<String> raboty, List<String> dopraboty,
////                         List<Vehicle_a> vehicles) {
////
////        this.orderNumber = orderNumber;
////        this.client_a = client_a;
////        this.dataRemont = dataRemont;
////        this.statusRemont = (statusRemont != null) ? statusRemont : RepairStatus.NEW;
////        this.srochnosty = (srochnosty != null) ? srochnosty : Srochnosty.OBICHNIY;
////        this.comment = (comment != null) ? comment : "";
////        if (raboty != null) this.raboty.addAll(raboty);
////        if (dopraboty != null) this.dopraboty.addAll(dopraboty);
////        if (vehicles != null) this.vehicle_a.addAll(vehicles);
////    }
////
////
////
////
////    @Override
////    public boolean equals(Object obj){
////        if(this==obj){
////            return true;
////        }
////        if(!(obj instanceof RepairOrder_a other)) return false;
////        return Objects.equals(this.orderNumber,other.orderNumber);
////    }
////
////    @Override
////    public int hashCode(){
////        return Objects.hash(orderNumber);
////    }
////
////
////    public void addVehicle(Vehicle_a vehicle){
////        if(this.statusRemont!=RepairStatus.NEW){
////            throw new IllegalStateException("Нельзя добавлять машины не в статусе NEW");
////        }
////        vehicle_a.add(vehicle);
////    }
////
////    public boolean removeVehicle(String vehicleNomer){
////        return vehicle_a.removeIf(v->Objects.equals(v.getNomer(),vehicleNomer));
////    }
////
////
////    @Override
////    public String toString() {
////        return "RepairOrder_a{" +
////                "orderNumber='" + orderNumber + '\'' +
////                ", client_a=" + client_a +
////                ", vehicle_a=" + vehicle_a +
////                ", payment=" + payment +
////                ", dataRemont=" + dataRemont +
////                ", statusRemont=" + statusRemont +
////                '}';
////    }
////
////    public String getOrderNumber() {
////        return orderNumber;
////    }
////
////    public Client_a getClient_a() {
////        return client_a;
////    }
////
////    public List<Vehicle_a> getVehicle_a() {
////        return new ArrayList<>(vehicle_a);
////    }
////    public Payment getPayment() {
////        return payment;
////    }
////    public List<String> getDopraboty() {
////        return new ArrayList<>(dopraboty);
////    }
////
////    public Srochnosty getSrochnosty() {
////        return srochnosty;
////    }
////
////    public String getComment() {
////        return comment;
////    }
////
////    public List<String> getRaboty() {
////        return new ArrayList<>(raboty);
////    }
////
////
////
////    public LocalDate getDataRemont() {
////        return dataRemont;
////    }
////
////    public RepairStatus getStatusRemont() {
////        return statusRemont;
////    }
////
////    public void setPayment(Payment payment) {
////        this.payment = payment;
////    }
////    public void setDataRemont(LocalDate dataRemont) {
////        this.dataRemont = dataRemont;
////    }
////    public void setDataRemontStroka(String s){
////        try{
////            this.dataRemont=LocalDate.parse(s);
////        }catch (DateTimeParseException e){
////            throw new IllegalArgumentException("Неверный формат даты: "+
////                    s+ ".Ожидается ГГГГ-ММ-ДД, например 2026-11-10");
////        }
////    }
////
////
////
////    public double calculateTotal() {
////        double sum = 0.0;
////        for (Vehicle_a p : vehicle_a) {
////            sum += p.getPriceRemont();
////        }
////        return sum;
////    }
////
////    @Override
////    public int compareTo(RepairOrder_a o) {
////        return Double.compare(this.calculateTotal(), o.calculateTotal());
////    }
////
////
////
////
////    public void changeStatus(RepairStatus newRepairStatus){
////        if(newRepairStatus==null){
////            throw new IllegalArgumentException("Статус не должен быть null");
////        }
////        this.statusRemont = newRepairStatus;
////    }
////
////}
//
//
//
//package autoservice.model_a;
//
//import autoservice.enum_a.RepairStatus;
//import autoservice.enum_a.Srochnosty;
//import autoservice.interface_a.Payment;
//import autoservice.interface_a.Service;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeParseException;
//import java.util.*;
//
//public class RepairOrder_a implements Comparable<RepairOrder_a> {
//    private final String orderNumber;
//    private final Client_a client_a;
//    private final List<Vehicle_a> vehicle_a = new ArrayList<>();
//    private Payment payment;
//    private LocalDate dataRemont;
//    private RepairStatus statusRemont;
//    private Srochnosty srochnosty;
//    private String comment;
//    private final List<String> raboty = new ArrayList<>();
//    private final List<String> dopraboty = new ArrayList<>();
//    private final List<Service> services = new ArrayList<>(); // новые услуги
//
//    public RepairOrder_a(String orderNumber, Client_a client_a, LocalDate dataRemont,
//                         RepairStatus statusRemont, Srochnosty srochnosty, String comment,
//                         List<String> raboty, List<String> dopraboty,
//                         List<Vehicle_a> vehicles) {
//
//        this.orderNumber = orderNumber;
//        this.client_a = client_a;
//        this.dataRemont = dataRemont;
//        this.statusRemont = (statusRemont != null) ? statusRemont : RepairStatus.NEW;
//        this.srochnosty = (srochnosty != null) ? srochnosty : Srochnosty.OBICHNIY;
//        this.comment = (comment != null) ? comment : "";
//        if (raboty != null) this.raboty.addAll(raboty);
//        if (dopraboty != null) this.dopraboty.addAll(dopraboty);
//        if (vehicles != null) this.vehicle_a.addAll(vehicles);
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) return true;
//        if (!(obj instanceof RepairOrder_a other)) return false;
//        return Objects.equals(this.orderNumber, other.orderNumber);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(orderNumber);
//    }
//
//    public void addVehicle(Vehicle_a vehicle) {
//        if (this.statusRemont != RepairStatus.NEW) {
//            throw new IllegalStateException("Нельзя добавлять машины не в статусе NEW");
//        }
//        vehicle_a.add(vehicle);
//    }
//
//    public boolean removeVehicle(String vehicleNomer) {
//        return vehicle_a.removeIf(v -> Objects.equals(v.getNomer(), vehicleNomer));
//    }
//
//    // Новый метод: добавить услугу
//    public void addService(Service service) {
//        services.add(service);
//    }
//
//    @Override
//    public String toString() {
//        return "RepairOrder_a{" +
//                "orderNumber='" + orderNumber + '\'' +
//                ", client_a=" + client_a +
//                ", vehicle_a=" + vehicle_a +
//                ", payment=" + payment +
//                ", dataRemont=" + dataRemont +
//                ", statusRemont=" + statusRemont +
//                '}';
//    }
//
//    public String getOrderNumber() { return orderNumber; }
//    public Client_a getClient_a() { return client_a; }
//    public List<Vehicle_a> getVehicle_a() { return new ArrayList<>(vehicle_a); }
//    public Payment getPayment() { return payment; }
//    public List<String> getDopraboty() { return new ArrayList<>(dopraboty); }
//    public Srochnosty getSrochnosty() { return srochnosty; }
//    public String getComment() { return comment; }
//    public List<String> getRaboty() { return new ArrayList<>(raboty); }
//    public LocalDate getDataRemont() { return dataRemont; }
//    public RepairStatus getStatusRemont() { return statusRemont; }
//
//    public void setPayment(Payment payment) { this.payment = payment; }
//    public void setDataRemont(LocalDate dataRemont) { this.dataRemont = dataRemont; }
//
//    public void setDataRemontStroka(String s) {
//        try {
//            this.dataRemont = LocalDate.parse(s);
//        } catch (DateTimeParseException e) {
//            throw new IllegalArgumentException("Неверный формат даты: " +
//                    s + ". Ожидается ГГГГ-ММ-ДД, например 2026-11-10");
//        }
//    }
//
//    // Обновлённый расчёт: авто + услуги
//    public double calculateTotal() {
//        double sum = 0.0;
//        for (Vehicle_a v : vehicle_a) {
//            sum += v.getPriceRemont();
//        }
//        for (Service s : services) {
//            sum += s.getPrice();
//        }
//        return sum;
//    }
//
//    public List<Service> getServices() {
//        return new ArrayList<>(services);
//    }
//
//    @Override
//    public int compareTo(RepairOrder_a o) {
//        return Double.compare(this.calculateTotal(), o.calculateTotal());
//    }
//
//    public void changeStatus(RepairStatus newRepairStatus) {
//        if (newRepairStatus == null) {
//            throw new IllegalArgumentException("Статус не должен быть null");
//        }
//        this.statusRemont = newRepairStatus;
//    }
//}
