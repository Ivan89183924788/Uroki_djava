//package control.models;
//
//public class UniversalMechanic implements Mechanic {
//    private final String name;
//    public UniversalMechanic(String name) { this.name = name; }
//
//    @Override
//    public String getRole() { return "Универсальный механик"; }
//
//    @Override
//    public void workOn(Vehicle vehicle) {
//        System.out.println(name + " (универсал) работает над " + vehicle.getNomer());
//        vehicle.diagnostic();
//        vehicle.remont();
//        System.out.println(name + " завершил работу над " + vehicle.getNomer());
//    }
//}