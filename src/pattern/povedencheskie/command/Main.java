//package pattern.povedencheskie.command;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Main {
//    public static void main(String[] args) {
//        Light light = new Light();
//        Command onCommand = new LightOnCommand(light);
//        Command ofCommand = new LightOfCommand(light);
//
//        Button button = new Button(onCommand);
//        Button button1 = new Button(ofCommand);
//
//        button.click();  // Включить свет
//        button1.click(); // Выключить свет
//
//        // Список команд — можно выполнить пачкой
//        List<Command> commands = new ArrayList<>();
//        commands.add(onCommand);
//        commands.add(onCommand);
//        commands.add(ofCommand);
//
//        System.out.println("--- Выполняем пачку команд ---");
//        for (Command c : commands) {
//            c.execute();
//        }
//    }
//}
