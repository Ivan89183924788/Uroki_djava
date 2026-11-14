//package control.models;
//
//import java.util.List;
//
//public class Main {
//    public static void main(String[] args) throws InterruptedException {
//        AutoService service = new AutoService();
//
//
//        service.addVehicle(new Car("Toyota", "Camry", "A001AA", 2020));
//        service.addVehicle(new Motorcycle("Yamaha", "R1", "B002BB", 2019));
//        service.addVehicle(new Truck("Volvo", "FH16", "C003CC", 2018));
//        service.addVehicle(new Car("BMW", "X5", "D004DD", 2021));
//        service.addVehicle(new Motorcycle("Kawasaki", "Ninja", "E005EE", 2022));
//
//
//        List<Mechanic> mechanics = List.of(
//                new EngineMechanic("Иван (Двигатель)"),
//                new Electrician("Петр (Электрик)"),
//                new UniversalMechanic("Сергей (Универсал)")
//        );
//
//
//        service.startService(mechanics);
//
//
//        service.showRepaired();
//    }
//}

