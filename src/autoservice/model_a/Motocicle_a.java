//package autoservice.model_a;
//
//import autoservice.interface_a.Repairable;
////
//public class Motocicle_a extends Vehicle_a implements Repairable {
//    private final double character_trassa;
//    private final int col_coles;
//    private boolean colyaska;
//    @Override
//    public String toString() {
//        return "Motocicle{"+  "years='" + getYears() + '\'' +
//                ", nomer='" + getNomer() + '\'' +
//                ", model='" + getModel() + '\'' +
//                ", marka='" + getMarka() + '\''  +
//                "character_trassa=" + character_trassa +
//                ", col_coles=" + col_coles +
//                ", colyaska=" + colyaska +
//                '}';
//    }
//
//    public double getCharacter_trassa() {
//        return character_trassa;
//    }
//
//    public int getCol_coles() {
//        return col_coles;
//    }
//
//    public boolean isColyaska() {
//        return colyaska;
//    }
//
//    public Motocicle_a(String years, String nomer, String model, String marka,double priceRemont, double character_trassa, int col_coles) {
//        super(Vihicle_type.MOTOCICLE, years,nomer, model, marka,priceRemont);
//        this.character_trassa = character_trassa;
//        this.col_coles = col_coles;
//    }
//    @Override
//    public void remont(){
//        System.out.println("Выполшнить ремонт мотоцикла "+getMarka());
//    }
//    @Override
//    public String getRemontDescription(){
//        return "Ремонт мотоцикла марка "+getMarka()+" гос.номер "+ getNomer();
//    }
//
//}
