//package autoservice.model_a;
//
//import java.util.*;
//
//public class AutoService {
//    private final HashMap<Integer,Client_a> clients_a=new HashMap<>();
//    private final ArrayList<RepairOrder_a> orderAs_a=new ArrayList<>();
//    private final HashSet<String> vehicleNomer=new HashSet<>();
//    private final ArrayDeque<Vehicle_a> diagnosticOcheredy=new ArrayDeque<>();
//    private final TreeSet<RepairOrder_a> sortRemont=new TreeSet<>();
//
//    public Map<Integer, Client_a> getClients_a() {
//        return  Collections.unmodifiableMap(clients_a);
//    }
//
//    public List<RepairOrder_a> getOrderAs_a() {
//        return  Collections.unmodifiableList(orderAs_a);
//    }
//
//    public Set<String> getVehicleNomer() {
//        return  Collections.unmodifiableSet(vehicleNomer);
//    }
//
//    public Queue<Vehicle_a> getDiagnosticOcheredy() {
//        return new ArrayDeque<>(diagnosticOcheredy);
//    }
//
//    public SortedSet<RepairOrder_a> getSortRemont() {
//        return  Collections.unmodifiableSortedSet(sortRemont);
//    }
//}
