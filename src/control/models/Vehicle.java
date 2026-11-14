//package control.models;
//
//
//// Абстрактный класс Vehicle (требование 1 и 2)
//public abstract class Vehicle implements Repairable, Diagnosable {
//    private final String marka;
//    private final String model;
//    private final String nomer;
//    private final int years;
//
//    public Vehicle(String marka, String model, String nomer, int years) {
//        this.marka = marka;
//        this.model = model;
//        this.nomer = nomer;
//        this.years = years;
//    }
//
//    public String getMarka() { return marka; }
//    public String getModel() { return model; }
//    public String getNomer() { return nomer; }
//    public int getYears() { return years; }
//
//    @Override
//    public String toString() {
//        return marka + " " + model + " (" + nomer + ")";
//    }
//}
