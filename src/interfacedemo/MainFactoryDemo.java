//package interfacedemo;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MainFactoryDemo {
//    public void main(String[] args){
//        ShapeRenderer renderer=new ConsoleRenderer();
//        List<AbstractShape> shapes=new ArrayList<>();
//        shapes.add(ShapeFactory.create("rectangle",5.6,10.5));
//        shapes.add(ShapeFactory.create("circle",34.5));
//        shapes.add(ShapeFactory.create("rectangle",12.4,105.5));
//
//        System.out.println("=== Фабрика фигур+ рендерер ===");
//        for (AbstractShape s:shapes){
//            s.draw(renderer);
//        }
//
//    }
//}
