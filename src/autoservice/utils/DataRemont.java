//package autoservice.utils;
//
//import autoservice.enum_a.RepairStatus;
//import autoservice.enum_a.Srochnosty;
//import autoservice.model_a.Client_a;
//import autoservice.model_a.RepairOrder_a;
//import autoservice.pattern.Logger;
//
//import java.io.*;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//public class DataRemont {
//    private static final String FILE_PATH="completed_repair_orders_a.txt";
//
//    public static void saveCompletedRepair_Orders_a(List<RepairOrder_a> allRepairOrder_a){
//        try(PrintWriter writer=new PrintWriter(new FileWriter(FILE_PATH,false))){
//            for(RepairOrder_a o:allRepairOrder_a){
//                if(o.getStatusRemont()== RepairStatus.COMPLETED){
//                    writer.println(serializeRepairOrder_a(o));
//                }
//            }
//        } catch (IOException e) {
//            Logger.getInstance().log("Ошибка сохранения заказов: " +e.getMessage());
//        }
//    }
//    public static List<RepairOrder_a> loadRepairOrder_a(){
//        List<RepairOrder_a> loaded=new ArrayList<>();
//        if(!Files.exists(Paths.get(FILE_PATH))){
//            return loaded;
//        }
//        try(BufferedReader reader=new BufferedReader(new FileReader(FILE_PATH))){
//            String line;
//            while ((line=reader.readLine())!=null){
//                RepairOrder_a o=deserializeRepairOrder_a(line);
//                if (o!=null) loaded.add(o);
//            }
//        } catch (IOException e){
//            Logger.getInstance().log("Ошибка при чтении заказов: "+e.getMessage());
//        }
//        return loaded;
//    }
//
//    private static String serializeRepairOrder_a(RepairOrder_a o){
//        return o.getOrderNumber()+"|"+
//                o.getClient_a().getName()+"|"+
//                o.getClient_a().getOrdersCount()+"|"+
//                o.calculateTotal()+"|"+
//                o.getDataRemont()+"|"+
//                o.getStatusRemont();
//    }
//
//    private static RepairOrder_a deserializeRepairOrder_a(String line){
//        String[] parts=line.split("\\|",-1);
//        String number=parts[0];
//        String clientName=parts[1];
//        int orderCount=Integer.parseInt(parts[2]);
//        double total=Double.parseDouble(parts[3]);
//        LocalDate date=LocalDate.parse(parts[4]);
//        RepairStatus status=RepairStatus.valueOf(parts[5]);
//
//        Client_a c=new Client_a("loaded_"+number,clientName,orderCount);
//        RepairOrder_a o=new RepairOrder_a(number,c,date,status, Srochnosty.OBICHNIY,"",
//                null,null,null);
//        o.setPayment(null);
//        return o;
//    }
//
//
//}
