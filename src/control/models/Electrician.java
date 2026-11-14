//package control.models;
//
//public class Electrician implements Mechanic {
//    private final String name;
//    public Electrician(String name) { this.name = name; }
//
//    @Override
//    public String getRole() { return "Электрик"; }
//
//    @Override
//    public void workOn(Vehicle vehicle) {
//        System.out.println(name + " (электрик) проверяет проводку " + vehicle.getNomer());
//        vehicle.diagnostic();
//        // Электрики могут не делать полный ремонт, только диагностику в этой модели
//        System.out.println(name + " завершил диагностику " + vehicle.getNomer());
//    }
//}