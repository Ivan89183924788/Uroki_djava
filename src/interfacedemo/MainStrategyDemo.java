//package interfacedemo;
//
//public class MainStrategyDemo {
//    public static void main(String[] args){
//        LoggerStrategy console=new ConsoleLogger();
//        LoggerStrategy file1=new FileLogger("LOG_A");
//        LoggerStrategy file2=new FileLogger("LOG_B");
//
//        OrderWithStrategy o1=new OrderWithStrategy("ORD-201",300.4,console);
//        OrderWithStrategy o2=new OrderWithStrategy("ORD-202",5490.4,file1);
//        OrderWithStrategy o3=new OrderWithStrategy("ORD-203",98440.4,file2);
//
//        System.out.println("=== Стратегии логирования ===");
//        o1.process();
//        o2.process();
//        o3.process();
//
//    }
//}
