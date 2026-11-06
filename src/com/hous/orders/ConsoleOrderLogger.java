//package com.hous.orders;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ConsoleOrderLogger implements OrderLogger {
//    private final List<String> logs=new ArrayList<>();
//    private int counter=0;
//
//    @Override
//    public void log(String message){
//        counter++;
//        logs.add(message);
//        System.out.println("[CONSOLE LOG] запись #"+ counter+": "+message);
//    }
//    public int getCounter(){
//        return counter;
//    }
//    public List<String> getLogs(){
//        return logs;
//    }
//    public void printSummary(){
//        System.out.println("--- Сводка логов ---");
//        System.out.println("Всего записей: "+ counter);
//        int start=Math.max(0,logs.size()-3);
//        System.out.println("Последнии 3 записи: ");
//        for(int i=start;i<logs.size();i++){
//            System.out.println(logs.get(i));
//        }
//        System.out.println("------------------");
//    }
//}
