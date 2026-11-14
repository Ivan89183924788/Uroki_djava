//package autoservice.pattern;
//
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//
//public class Logger {
//    private static final Logger instance=new Logger();
//    private static final DateTimeFormatter FORMAT=
//            DateTimeFormatter.ofPattern("yyyy-MM-dd");
//
//    private Logger(){};
//
//    public static Logger getInstance(){
//        return instance;
//    }
//
//    public void log(String message){
//        String timestamp= LocalDateTime.now().format(FORMAT);
//        System.out.println("[LOG]["+ timestamp+"] "+message);
//    }
//    public void error(String message){
//        String timestamp=LocalDateTime.now().format(FORMAT);
//        System.out.println("[ERROR]["+timestamp+"] "+ message);
//    }
//}
