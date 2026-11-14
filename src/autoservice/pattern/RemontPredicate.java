//package autoservice.pattern;
//
//import autoservice.enum_a.RepairStatus;
//import autoservice.enum_a.Srochnosty;
//import autoservice.model_a.RepairOrder_a;
//
//import java.util.function.Predicate;
//
//public class RemontPredicate {
//    public static final Predicate<RepairOrder_a> BY_STATUS_NEW=
//            o->o.getStatusRemont()== RepairStatus.NEW;
//    public static final Predicate<RepairOrder_a> BY_SROCHNO=
//            o->o.getSrochnosty()== Srochnosty.SROCHNO;
//    public static final Predicate<RepairOrder_a>    by_podoroje_5000=
//            o->o.calculateTotal()>5000;
//    public static final Predicate<RepairOrder_a> clientName(String name){
//        return o->o.getClient_a().getName().equalsIgnoreCase(name);
//    }
//    public static final Predicate<RepairOrder_a> CANCELLED=
//            o->o.getStatusRemont()==RepairStatus.CANCELLED;
//}
