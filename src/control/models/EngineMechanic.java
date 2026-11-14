//package control.models;
//
//public class EngineMechanic implements Mechanic {
//    private final String name;
//    public EngineMechanic(String name) { this.name = name; }
//
//    @Override
//    public String getRole() { return "Механик по двигателям"; }
//
//    @Override
//    public void workOn(Vehicle vehicle) {
//        System.out.println(name + " (специалист по двигателям) приступил к работе над " + vehicle.getNomer());
//        vehicle.diagnostic();
//        vehicle.remont();
//        System.out.println(name + " завершил работу над " + vehicle.getNomer());
//    }
//}