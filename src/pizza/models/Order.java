//package pizza.models;
//
//import pizza.enums.OrderStatus;
//import pizza.interfaces.Delivery;
//import pizza.interfaces.Payment;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//public class Order implements Comparable<Order> {
//    private final String orderNumber;
//    private final Customer customer;
//    // ✅ Это должен быть изменяемый список — у тебя правильно: new ArrayList<>()
//    private final List<Pizza> pizzas;
//
//    private Payment payment;
//    private Delivery delivery;
//    private OrderStatus status;
//    // ❌ totalCost как final не нужен: стоимость всегда считается на лету
//
//    public Order(String orderNumber, Customer customer) {
//        this.orderNumber = orderNumber;
//        this.customer = customer;
//        this.pizzas = new ArrayList<>();
//        this.status = OrderStatus.NEW;
//        // totalCost удалён
//    }
//
//    public void addPizza(Pizza pizza) {
//        if (this.status != OrderStatus.NEW) {
//            throw new IllegalStateException("Нельзя добавлять пиццы, когда заказ не в статусе NEW");
//        }
//        pizzas.add(pizza);
//    }
//
//    // ✅ Используй этот метод вместо прямого removeIf в Main
//    public boolean removePizza(String pizzaName) {
//        return pizzas.removeIf(p -> Objects.equals(p.getName(), pizzaName));
//    }
//
//    public void setPayment(Payment payment) {
//        this.payment = payment;
//    }
//
//    public void setDelivery(Delivery delivery) {
//        this.delivery = delivery;
//    }
//
//    public void changeStatus(OrderStatus newStatus) {
//        this.status = newStatus;
//    }
//
//    public double calculateTotal() {
//        double sum = 0.0;
//        for (Pizza p : pizzas) {
//            sum += p.getPrice();
//        }
//        return sum;
//    }
//
//    public String getOrderNumber() {
//        return orderNumber;
//    }
//
//    public Customer getCustomer() {
//        return customer;
//    }
//
//    // ⚠️ Осторожно: отдаём внутреннюю коллекцию. Для учебного проекта ок.
//    public List<Pizza> getPizzas() {
//        return pizzas;
//    }
//
//    public Payment getPayment() {
//        return payment;
//    }
//
//    public Delivery getDelivery() {
//        return delivery;
//    }
//
//    public OrderStatus getStatus() {
//        return status;
//    }
//
//    @Override
//    public int compareTo(Order other) {
//        return Double.compare(this.calculateTotal(), other.calculateTotal());
//    }
//
//    @Override
//    public String toString() {
//        return "Order{number='" + orderNumber + "', customer='" + customer.getName() +
//                "', status=" + status + ", total=" + calculateTotal() + "}";
//    }
//}
