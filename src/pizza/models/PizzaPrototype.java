//package pizza.models;
//
//public class PizzaPrototype implements Cloneable {
//    private final Pizza pizza;
//
//    public PizzaPrototype(Pizza pizza) {
//        this.pizza = pizza;
//    }
//
//    public Pizza clonePizza() {
//        try {
//            Pizza cloned = new Pizza(
//                    pizza.getName(),
//                    pizza.getSize(),
//                    pizza.getDoughType(),
//                    pizza.getSauce(),
//                    pizza.getCheese(),
//                    pizza.getTopping(),
//                    pizza.getPrice()
//            );
//            return cloned;
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to clone pizza", e);
//        }
//    }
//}
