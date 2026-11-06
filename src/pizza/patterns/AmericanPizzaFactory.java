//package pizza.patterns;
//
//import pizza.enums.PizzaSize;
//import pizza.models.Pizza;
//import pizza.patterns.PizzaBuilder;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class AmericanPizzaFactory extends PizzaSetFactory {
//    @Override
//    public List<Pizza> createSet() {
//        List<Pizza> set = new ArrayList<>();
//        set.add(new PizzaBuilder()
//                .setName("Margherita").setSize(PizzaSize.MEDIUM)
//                .setDoughType("thin").setSauce("tomato").setCheese("mozzarella")
//                .setPrice(450).build());
//        set.add(new PizzaBuilder()
//                .setName("Quattro Formaggi").setSize(PizzaSize.LARGE)
//                .setDoughType("thick").setSauce("white").setCheese("blend")
//                .setPrice(650).build());
//        return set;
//    }
//}

