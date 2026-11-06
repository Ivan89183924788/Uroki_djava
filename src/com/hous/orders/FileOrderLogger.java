//package com.hous.orders;
//
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//public class FileOrderLogger implements OrderLogger{
//    private final PrintWriter writer;
//
//    public FileOrderLogger(String filename) throws IOException{
//        this.writer=new PrintWriter(new FileWriter(filename,true));
//    }
//    @Override
//    public void log(String message){
//        writer.println(message);
//        writer.flush();
//    }
//
//    public void close(){
//        if(writer!=null){
//            writer.close();
//        }
//    }
//}
