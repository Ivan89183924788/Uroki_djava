//package interfacedemo;
//
//import java.util.Locale;
//
//public class ShapeFactory {
//    public static AbstractShape create(String type,double... args){
//        switch (type.toLowerCase()){
//            case "rectangle":
//                if(args.length<2) throw new IllegalArgumentException("Rectangle needs width and height");
//                return new RectangleShape(args[0],args[1] );
//            case "circle":
//                if(args.length<1) throw new IllegalArgumentException("Circle need radius");
//                return new CircleShape(args[0]);
//            default:
//                throw new IllegalArgumentException("Неизвестный тип фигуры: "+type);
//        }
//    }
//}
