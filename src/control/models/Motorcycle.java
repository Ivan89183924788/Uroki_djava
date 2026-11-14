//package control.models;
//
//public class Motorcycle extends Vehicle {
//    public Motorcycle(String marka, String model, String nomer, int years) {
//        super(marka, model, nomer, years);
//    }
//
//    @Override
//    public void diagnostic() {
//        System.out.println("[Диагностика] Проверка цепи и тормозов мотоцикла " + getNomer() + "...");
//    }
//
//    @Override
//    public void remont() {
//        System.out.println("[Ремонт] Настройка карбюратора мотоцикла " + getNomer() + "...");
//        try { Thread.sleep(1500); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
//    }
//
//    @Override
//    public String getRemontDescription() {
//        return "Выполнен ремонт мотоцикла " + getNomer();
//    }
//}
