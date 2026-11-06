//package enumdemo;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MainRenderModeDemo {
//    public static void main(String[] args){
//        List<AbstractShape> shapes=new ArrayList<>();
//        shapes.add(new RectangleShape(5,10));
//        shapes.add(new CircleShape(3));
//
//        for(RenderMode mode: RenderMode.values()){
//            System.out.println("\n--- Режим: " + mode + "----");
//            ShapeRenderer renderer=mode.create();
//            for(AbstractShape s:shapes){
//                s.draw(renderer);
//            }
//        }
//    }
//}
