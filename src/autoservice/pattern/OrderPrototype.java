//package autoservice.pattern;
//
//import autoservice.enum_a.RepairStatus;
//import autoservice.model_a.Client_a;
//import autoservice.model_a.RepairOrder_a;
//import autoservice.model_a.Vehicle_a;
//
//import java.time.LocalDate;
//import java.util.HashMap;
//import java.util.Map;
//
//public class OrderPrototype {
//    private static final Map<String, RepairOrder_a> shablony=new HashMap<>();
//
//    public static void register(String name,RepairOrder_a shablon){
//        if(name==null || name.isBlank()){
//            throw new IllegalArgumentException("Имя эталона обязательно");
//        }
//        if(shablon==null){
//            throw new IllegalArgumentException("Эталон не может быть null");
//        }
//        shablony.put(name,shablon);
//    }
//
//    public static RepairOrder_a cloneFor(String name, Client_a newClient,
//                                         Vehicle_a newVehicle,String newOrderNumber){
//        RepairOrder_a shablon=shablony.get(name);
//        if(shablon==null){
//            throw new IllegalArgumentException("Нет типовой заявки: "+ name);
//        }
//        return new RepairOrder_a(
//                newOrderNumber,
//                newClient,
//                LocalDate.now(),
//                RepairStatus.NEW,
//                shablon.getSrochnosty(),
//                shablon.getComment(),
//                shablon.getRaboty(),
//                shablon.getDopraboty(),
//                newVehicle!=null? java.util.List.of(newVehicle):null
//        );
//    }
//
//    public static boolean sushestvuet(String name){
//        return shablony.containsKey(name);
//    }
//
//    public static java.util.Set<String> names(){
//        return shablony.keySet();
//    }
//}
