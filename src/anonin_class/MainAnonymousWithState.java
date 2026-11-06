//package anonin_class;
//
//public class MainAnonymousWithState {
//    public static void main(String[] args){
//        final int retryCount=3;
//
//        Task task=new Task(){
//            private int attempts=0;
//
//            @Override
//            public void execute(){
//                attempts++;
//                System.out.println("Попытка №" +attempts+" из "+ retryCount);
//                if(attempts>=retryCount){
//                    System.out.println("Лимит попыток исчерпан.");
//                } else {
//                    System.out.println("Продолжаем работу...");
//                }
//            }
//        };
//        task.execute();
//        task.execute();
//        task.execute();
//        task.execute();
//        task.execute();
//    }
//}
