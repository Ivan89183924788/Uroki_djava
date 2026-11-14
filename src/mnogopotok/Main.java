package mnogopotok;

import java.io.IOException;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

//public class Main {
//    public static void main(String[] args) throws IOException {
//        Thread th1=new Thread(()->{
//            System.out.println("Работает дополнительный поток");
//
//        });
//        th1.start();
//        System.out.println("Главный поток");
//        Thread th=Thread.currentThread();
//        System.out.println(th.getName());
//
//    }
//}

//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        Thread th1 = new Thread(() -> {
//            System.out.println("Работает дополнительный поток");
//
//            for (int i = 1; i <= 10; i++) {
//                System.out.println("Поток: " + i);
//            }
//        });
//        th1.start();
//        for(int i=1;i<=10;i++){
//            System.out.println("Main: "+ i);
//        }
//    }
//}
//
//public class Main {
//    public static void main(String[] args) throws IOException, InterruptedException {
//        Thread thread = new Thread(() -> {
//            System.out.println("Начало работы");
//
//           try {
//               Thread.sleep(3000);
//           }catch (InterruptedException e){
//               System.out.println("Поток прервали");
//           }
//            System.out.println("Конец работы");
//        });
//        thread.setName("Work-1");
//        System.out.println(thread.getName());
//        thread.start();
//        System.out.println("Работает: "+thread.isAlive());
//        thread.join();
//        System.out.println("Работает: "+thread.isAlive());
//        System.out.println("main завершен");
//
//    }
//}


//1
//public class Main {
//    public static void main(String[] args) throws IOException, InterruptedException {
//        Counter counter=new Counter();
//        Thread thread=new Thread(()->{
//            for (int i=0;i<100000;i++){
//                counter.increment();
//            }
//        });
//        Thread thread1=new Thread(()->{
//            for (int i=0;i<100000;i++){
//                counter.increment();
//            }
//        });
//        thread.start();
//        thread1.start();
//        thread.join();
//        thread1.join();
//        System.out.println(counter.value);
//
//    }
//}


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Exchanger<String> exchanger=new Exchanger<>();
        Thread thread1=new Thread(()->{
          try{
              String data="Это данные Thread1";
              System.out.println("Thread1 отправляет: "+ data);
              String result=exchanger.exchange(data,3, TimeUnit.SECONDS);
              System.out.println("Thread1 получил: "+result);
          }catch (InterruptedException e){
              Thread.currentThread().interrupt();
          }catch (TimeoutException e){
              e.printStackTrace();
          }
        });

        Thread thread2=new Thread(()->{
            try{
                String data="Это данные Thread2";
                System.out.println("Thread2 отправляет: "+ data);
                String result=exchanger.exchange(data,3,TimeUnit.SECONDS);
                System.out.println("Thread2 получил: "+result);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }catch (TimeoutException e){
                e.printStackTrace();
            }
        });
        thread1.start();
        thread2.start();

    }
}