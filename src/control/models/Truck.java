//package control.models;
//
//public class Truck extends Vehicle {
//    public Truck(String marka, String model, String nomer, int years) {
//        super(marka, model, nomer, years);
//    }
//
//    @Override
//    public void diagnostic() {
//        System.out.println("[Диагностика] Сканирование ЭБУ грузовика " + getNomer() + "...");
//    }
//
//    @Override
//    public void remont() {
//        System.out.println("[Ремонт] Ремонт подвески грузовика " + getNomer() + "...");
//        try { Thread.sleep(2000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
//    }
//
//    @Override
//    public String getRemontDescription() {
//        return "Выполнен капитальный ремонт грузовика " + getNomer();
//    }
//}