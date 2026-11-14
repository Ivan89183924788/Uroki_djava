//package autoservice.model_a;
//import java.util.Comparator;
//
//public class CompatorRemont {
//    public static Comparator<RepairOrder_a> BY_CLIENT_NAME=
//            Comparator.comparing(o->o.getClient_a()==null?"":o.getClient_a().getName());
//    public static final Comparator<RepairOrder_a>  BY_CLIENT_ORDER_NUMBER=
//            Comparator.comparing(o->o.getOrderNumber()==null? "": o.getOrderNumber());
//
//    public static final Comparator<RepairOrder_a> BY_REMONT_DATA=
//            Comparator.comparing(RepairOrder_a::getDataRemont);
//
//    public static final Comparator<RepairOrder_a> BY_TOTAL=
//            Comparator.comparingDouble(RepairOrder_a::calculateTotal);
//}
