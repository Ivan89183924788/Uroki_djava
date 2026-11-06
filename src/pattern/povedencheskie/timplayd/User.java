//package pattern.povedencheskie.mediator;
//
//public class User {
//    private String name;
//    private ChatMediator chatMediator;
//
//    public String getName() {
//        return name;
//    }
//
//    public User(String name, ChatMediator chatMediator){
//        this.name=name;
//        this.chatMediator=chatMediator;
//    }
//    public void send(String mesaage){
//        chatMediator.sendMessage(mesaage,this);
//    }
//    public void receive(String message,String sender){
//        System.out.println(name+" получил от: "+sender+": "+message);
//    }
//}
