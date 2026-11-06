

////1
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.List;
//
//public class MainAdvancedShape {
//    public static void main(String[] args) {
//        List<AdvancedShape> shapes = new ArrayList<>();
//        shapes.add(new Triangle(3.0, 4.0));
//        shapes.add(new Rectangle(2.0, 5.0));
//        shapes.add(new Circle(2.0));
//        shapes.add(new Triangle(-1.0, 4.0)); // невалидная фигура
//
//        // Фильтрация валидных фигур
//        List<AdvancedShape> validShapes = new ArrayList<>();
//        for (AdvancedShape s : shapes) {
//            if (s.isValid()) {
//                validShapes.add(s);
//            } else {
//                System.out.println("[SKIP] Пропущена невалидная фигура: " + s.getDescription());
//            }
//        }
//
//        // Сортировка по площади
//        Collections.sort(validShapes, Comparator.comparingDouble(AdvancedShape::getArea));
//
//        // Вывод
//        for (AdvancedShape s : validShapes) {
//            System.out.println("Фигура: " + s.getDescription() + ", площадь: " + s.getArea());
//        }
//    }
//}


