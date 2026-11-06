//package pizza.patterns;
//
//import pizza.enums.PizzaSize;
//import pizza.models.Pizza;
//
//public class PizzaBuilder {
//    private String name;
//    private PizzaSize size;
//    private String doughType;
//    private String sauce;
//    private String cheese;
//    private String topping;
//    private double price;
//
//    public PizzaBuilder setName(String name) {
//        this.name = name;
//        return this;
//    }
//
//    public PizzaBuilder setSize(PizzaSize size) {
//        this.size = size;
//        return this;
//    }
//
//    public PizzaBuilder setDoughType(String doughType) {
//        this.doughType = doughType;
//        return this;
//    }
//
//    public PizzaBuilder setSauce(String sauce) {
//        this.sauce = sauce;
//        return this;
//    }
//
//    public PizzaBuilder setCheese(String cheese) {
//        this.cheese = cheese;
//        return this;
//    }
//
//    public PizzaBuilder setTopping(String topping) {
//        this.topping = topping;
//        return this;
//    }
//
//    public PizzaBuilder setPrice(double price) {
//        if (price < 0) throw new IllegalArgumentException("Price cannot be negative");
//        this.price = price;
//        return this;
//    }
//
//    public Pizza build() {
//        if (name == null || size == null) {
//            throw new IllegalStateException("Name and size are required");
//        }
//        return new Pizza(name, size, doughType, sauce, cheese, topping, price);
//    }
//}
