//package control.models;
//
//public class Car extends Vehicle {
//    public Car(String marka, String model, String nomer, int years) {
//        super(marka, model, nomer, years);
//    }
//
//    @Override
//    public void diagnostic() {
//        System.out.println("[Диагностика] Проверка систем автомобиля " + getNomer() + "...");
//    }
//
//    @Override
//    public void remont() {
//        System.out.println("[Ремонт] Замена масла и фильтров в авто " + getNomer() + "...");
//        try { Thread.sleep(1000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
//    }
//
//    @Override
//    public String getRemontDescription() {
//        return "Выполнен ТО легкового автомобиля " + getNomer();
//    }
//}

