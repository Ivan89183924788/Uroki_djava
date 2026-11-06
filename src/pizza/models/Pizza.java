//package pizza.models;
//
//import pizza.enums.PizzaSize;
//
//public class Pizza {
//    private final String name;
//    private final PizzaSize size;
//    private String doughType;
//    private String sauce;
//    private String cheese;
//    private String topping;
//    private double price;
//
//    public Pizza(String name, PizzaSize size, String doughType, String sauce,
//                 String cheese, String topping, double price) {
//        this.name = name;
//        this.size = size;
//        this.doughType = doughType;
//        this.sauce = sauce;
//        this.cheese = cheese;
//        this.topping = topping;
//        this.price = price;
//    }
//
//    // Геттеры
//    public String getName() { return name; }
//    public PizzaSize getSize() { return size; }
//    public String getDoughType() { return doughType; }
//    public String getSauce() { return sauce; }
//    public String getCheese() { return cheese; }
//    public String getTopping() { return topping; }
//    public double getPrice() { return price; }
//
//    // Сеттеры для изменения (если нужно)
//    public void setDoughType(String doughType) { this.doughType = doughType; }
//    public void setSauce(String sauce) { this.sauce = sauce; }
//    public void setCheese(String cheese) { this.cheese = cheese; }
//    public void setTopping(String topping) { this.topping = topping; }
//    public void setPrice(double price) {
//        if (price < 0) throw new IllegalArgumentException("Price cannot be negative");
//        this.price = price;
//    }
//
//    @Override
//    public String toString() {
//        return "Pizza{name='" + name + "', size=" + size +
//                ", doughType='" + doughType + "', sauce='" + sauce +
//                "', cheese='" + cheese + "', topping='" + topping +
//                "', price=" + price + "}";
//    }
//}

