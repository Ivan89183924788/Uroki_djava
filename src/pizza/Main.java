//package pizza;
//
//import pizza.enums.*;
//import pizza.interfaces.*;
//import pizza.models.*;
//import pizza.patterns.*;
//import pizza.utils.*;
//
//import java.util.*;
//import java.util.function.Predicate;
//import java.util.stream.Collectors;
//
//public class Main {
//    private static final Scanner sc = new Scanner(System.in);
//    private static final Repository<Customer> customerRepo = new Repository<>();
//    private static final Map<String, Customer> customersById = new HashMap<>();
//    private static final List<Order> allOrders = new ArrayList<>();
//    private static final TreeSet<Order> sortedOrders = new TreeSet<>(OrderComparators.BY_TOTAL);
//    private static final Queue<String> cookingQueue = new ArrayDeque<>();
//    private static final Deque<String> history = new ArrayDeque<>(); // последние действия
//    private static final HashSet<String> uniqueOrderNumbers = new HashSet<>();
//
//    public static void main(String[] args) {
//        // Загрузка ранее сохранённых заказов
//        List<Order> loaded = DataPersistence.loadOrders();
//        loaded.forEach(Main::addOrderToCollections);
//
//        // Запуск симулятора приготовления
//        Thread cookThread = new Thread(new CookingSimulator(cookingQueue,
//                allOrders.stream().collect(Collectors.toMap(Order::getOrderNumber, o -> o))));
//        cookThread.setDaemon(true);
//        cookThread.start();
//
//        boolean running = true;
//        while (running) {
//            printMenu();
//            int choice = readInt("Выберите пункт: ");
//            try {
//                switch (choice) {
//                    case 1:
//                        addCustomer();
//                        break;
//                    case 2:
//                        createPizzaViaBuilder();
//                        break;
//                    case 3:
//                        createOrder();
//                        break;
//                    case 4:
//                        addPizzaToOrder();
//                        break;
//                    case 5:
//                        removePizzaFromOrder();
//                        break;
//                    case 6:
//                        payOrder();
//                        break;
//                    case 7:
//                        changeOrderStatus();
//                        break;
//                    case 8:
//                        showAllOrders();
//                        break;
//                    case 9:
//                        findOrder();
//                        break;
//                    case 10:
//                        sortOrders();
//                        break;
//                    case 11:
//                        showCookingQueue();
//                        break;
//                    case 12:
//                        showStatistics();
//                        break;
//                    case 13:
//                        saveData();
//                        break;
//                    case 0:
//                        running = false;
//                        break;
//                    default:
//                        System.out.println("Неверный выбор.");
//                }
//            } catch (Exception e) {
//                Logger.getInstance().log("Ошибка в операции: " + e.getMessage());
//                System.out.println("Произошла ошибка: " + e.getMessage());
//            }
//        }
//
//        cookThread.interrupt();
//        System.out.println("Программа завершена.");
//    }
//
//    private static void addOrderToCollections(Order o) {
//        allOrders.add(o);
//        sortedOrders.add(o);
//        uniqueOrderNumbers.add(o.getOrderNumber());
//    }
//
//    private static void printMenu() {
//        System.out.println("\n=== Управление пиццерией ===");
//        System.out.println("1. Добавить клиента");
//        System.out.println("2. Создать пиццу (Builder)");
//        System.out.println("3. Создать заказ");
//        System.out.println("4. Добавить пиццу в заказ");
//        System.out.println("5. Удалить пиццу из заказа");
//        System.out.println("6. Оплатить заказ");
//        System.out.println("7. Изменить статус заказа");
//        System.out.println("8. Показать все заказы");
//        System.out.println("9. Найти заказ");
//        System.out.println("10. Отсортировать заказы");
//        System.out.println("11. Показать очередь приготовления");
//        System.out.println("12. Показать статистику");
//        System.out.println("13. Сохранить данные");
//        System.out.println("0. Выход");
//    }
//
//    private static int readInt(String prompt) {
//        System.out.print(prompt);
//        while (!sc.hasNextInt()) {
//            System.out.print("Введите число: ");
//            sc.next();
//        }
//        return sc.nextInt();
//
//
//
//    }
//
//    private static String readLine(String prompt) {
//        System.out.print(prompt);
//        return sc.nextLine();
//    }
//
//    private static void addCustomer() {
//        String id = readLine("ID клиента: ");
//        String name = readLine("Имя клиента: ");
//        if (customersById.containsKey(id)) {
//            throw new IllegalArgumentException("Клиент с таким ID уже существует.");
//        }
//        Customer c = new Customer(id, name);
//        customerRepo.add(c);
//        customersById.put(id, c);
//        Logger.getInstance().log("Добавлен клиент: " + c);
//        history.push("Добавлен клиент " + id);
//    }
//
//    private static void createPizzaViaBuilder() {
//        String name = readLine("Название пиццы (обязательно): ");
//        PizzaSize size = PizzaSize.valueOf(readLine("Размер (SMALL/MEDIUM/LARGE): ").trim().toUpperCase());
//        String dough = readLine("Тип теста: ");
//        String sauce = readLine("Соус: ");
//        String cheese = readLine("Сыр: ");
//        String topping = readLine("Начинка: ");
//        double price = Double.parseDouble(readLine("Цена: "));
//
//        Pizza p = new PizzaBuilder()
//                .setName(name)
//                .setSize(size)
//                .setDoughType(dough)
//                .setSauce(sauce)
//                .setCheese(cheese)
//                .setTopping(topping)
//                .setPrice(price)
//                .build();
//
//        System.out.println("Пицца создана: " + p);
//        Logger.getInstance().log("Создана пицца: " + name);
//        history.push("Создана пицца " + name);
//    }
//
//    private static void createOrder() {
//        String cId = readLine("ID клиента: ");
//        Customer c = customersById.get(cId);
//        if (c == null) throw new IllegalArgumentException("Клиент не найден.");
//
//        String number;
//        do {
//            number = "ORD-" + System.currentTimeMillis();
//        } while (!uniqueOrderNumbers.add(number));
//
//        Order o = new Order(number, c);
//        allOrders.add(o);
//        sortedOrders.add(o);
//
//        Logger.getInstance().log("Создан заказ: " + number);
//        history.push("Создан заказ " + number);
//        System.out.println("Заказ создан: " + o);
//    }
//
//    private static void addPizzaToOrder() {
//        String number = readLine("Номер заказа: ");
//        Order o = allOrders.stream()
//                .filter(ord -> ord.getOrderNumber().equals(number))
//                .findFirst()
//                .orElseThrow(() -> new IllegalArgumentException("Заказ не найден."));
//
//        if (o.getStatus() != OrderStatus.NEW) {
//            throw new IllegalStateException("Нельзя добавлять пиццы в заказ не в статусе NEW.");
//        }
//
//        String name = readLine("Название пиццы: ");
//        PizzaSize size = PizzaSize.valueOf(readLine("Размер: ").trim().toUpperCase());
//        double price = Double.parseDouble(readLine("Цена пиццы: "));
//        Pizza p = new Pizza(name, size, null, null, null, null, price);
//
//        o.addPizza(p);
//        sortedOrders.remove(o); // пересортируем
//        sortedOrders.add(o);
//
//        Logger.getInstance().log("В заказ " + number + " добавлена пицца: " + name);
//        history.push("Добавлена пицца " + name + " в заказ " + number);
//    }
//
//    private static void removePizzaFromOrder() {
//        String number = readLine("Номер заказа: ");
//        Order o = findOrderByNumber(number);
//        String name = readLine("Название пиццы для удаления: ");
//
//        boolean removed = o.removePizza(name);
//        if (!removed) {
//            throw new IllegalArgumentException("Пицца не найдена в заказе.");
//        }
//
//        sortedOrders.remove(o);
//        sortedOrders.add(o);
//
//        Logger.getInstance().log("Из заказа " + number + " удалена пицца: " + name);
//        history.push("Удалена пицца " + name + " из заказа " + number);
//    }
//
//    private static Order findOrderByNumber(String number) {
//        return allOrders.stream()
//                .filter(o -> o.getOrderNumber().equals(number))
//                .findFirst()
//                .orElseThrow(() -> new IllegalArgumentException("Заказ не найден."));
//    }
//
//    private static void payOrder() {
//        String number = readLine("Номер заказа: ");
//        Order o = findOrderByNumber(number);
//
//        if (o.getPizzas().isEmpty()) {
//            throw new IllegalStateException("Нельзя оплатить пустой заказ.");
//        }
//        if (o.getStatus() != OrderStatus.NEW && o.getStatus() != OrderStatus.COOKING) {
//            throw new IllegalStateException("Оплата возможна только для статусов NEW или COOKING.");
//        }
//
//        System.out.println("Выберите способ оплаты: 1 - Card, 2 - Cash, 3 - SBP");
//        int typeChoice = readInt("Ваш выбор: ");
//        String details = readLine("Реквизиты/данные (номер карты/номер телефона и т.п.): ");
//
//        String paymentType = switch (typeChoice) {
//            case 1 -> "card";
//            case 2 -> "cash";
//            case 3 -> "sbp";
//            default -> throw new IllegalArgumentException("Неверный тип оплаты.");
//        };
//
//        Payment payment = PaymentFactory.createPayment(paymentType, details);
//        o.setPayment(payment);
//
//        double total = o.calculateTotal();
//        boolean success = payment.pay(total);
//
//        if (!success) {
//            throw new IllegalStateException("Ошибка оплаты.");
//        }
//
//        // Пример использования instanceof для логирования конкретного типа
//        if (payment instanceof CardPayment) {
//            Logger.getInstance().log("Оплата картой для заказа " + number);
//        } else if (payment instanceof CashPayment) {
//            Logger.getInstance().log("Оплата наличными для заказа " + number);
//        } else if (payment instanceof SbpPayment) {
//            Logger.getInstance().log("Оплата через СБП для заказа " + number);
//        }
//
//        history.push("Оплачен заказ " + number + " на сумму " + total);
//        System.out.println("Заказ оплачен. Итоговая сумма: " + total);
//    }
//
//    private static void changeOrderStatus() {
//        String number = readLine("Номер заказа: ");
//        Order o = findOrderByNumber(number);
//
//        System.out.println("Доступные статусы: NEW, COOKING, READY, DELIVERING, COMPLETED, CANCELLED");
//        String statusStr = readLine("Новый статус: ").trim().toUpperCase();
//        OrderStatus newStatus = OrderStatus.valueOf(statusStr);
//
//        OrderStatus current = o.getStatus();
//
//        // Простая валидация переходов (можно расширить)
//        if (newStatus == OrderStatus.COMPLETED && current != OrderStatus.READY) {
//            throw new IllegalStateException("Заказ можно завершить только из статуса READY.");
//        }
//        if (newStatus == OrderStatus.CANCELLED && (current == OrderStatus.COMPLETED || current == OrderStatus.DELIVERING)) {
//            throw new IllegalStateException("Невозможно отменить завершённый или доставляемый заказ.");
//        }
//
//        o.changeStatus(newStatus);
//        sortedOrders.remove(o);
//        sortedOrders.add(o);
//
//        Logger.getInstance().log("Статус заказа " + number + " изменён с " + current + " на " + newStatus);
//        history.push("Статус заказа " + number + " изменён на " + newStatus);
//
//        // Если заказ перешёл в NEW -> добавляем в очередь приготовления
//        if (current == OrderStatus.NEW && newStatus == OrderStatus.COOKING) {
//            cookingQueue.offer(number);
//            Logger.getInstance().log("Заказ " + number + " добавлен в очередь приготовления.");
//        }
//    }
//
//    private static void showAllOrders() {
//        if (allOrders.isEmpty()) {
//            System.out.println("Нет заказов.");
//            return;
//        }
//
//        allOrders.forEach(System.out::println); // ссылка на метод ::
//    }
//
//    private static void findOrder() {
//        String number = readLine("Номер заказа для поиска: ");
//        try {
//            Order o = findOrderByNumber(number);
//            System.out.println("Найден заказ: " + o);
//            // Вывод деталей пицц
//            o.getPizzas().forEach(p -> System.out.println("  - " + p));
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    private static void sortOrders() {
//        System.out.println("Сортировка заказов:");
//        System.out.println("1 - по стоимости (по умолчанию в TreeSet)");
//        System.out.println("2 - по номеру заказа");
//        System.out.println("3 - по имени клиента");
//        int choice = readInt("Выберите вариант: ");
//
//        List<Order> toSort = new ArrayList<>(allOrders);
//
//        Comparator<Order> comparator = switch (choice) {
//            case 2 -> OrderComparators.BY_NUMBER;
//            case 3 -> OrderComparators.BY_CUSTOMER_NAME;
//            default -> OrderComparators.BY_TOTAL;
//        };
//
//        toSort.sort(comparator);
//
//        System.out.println("Отсортированные заказы:");
//        toSort.forEach(System.out::println);
//    }
//
//    private static void showCookingQueue() {
//        if (cookingQueue.isEmpty()) {
//            System.out.println("Очередь приготовления пуста.");
//            return;
//        }
//        System.out.println("Очередь приготовления (номера заказов):");
//        cookingQueue.forEach(System.out::println);
//    }
//
//    private static void showStatistics() {
//        if (allOrders.isEmpty()) {
//            System.out.println("Нет заказов для статистики.");
//            return;
//        }
//
//        Order mostExpensive = Statistics.getMostExpensive(allOrders);
//        Order cheapest = Statistics.getCheapest(allOrders);
//        double average = Statistics.getAverageCost(allOrders);
//        Map<OrderStatus, Long> byStatus = Statistics.getCountByStatus(allOrders);
//        Customer activeCustomer = Statistics.getMostActiveCustomer(allOrders, customersById);
//        String mostOrderedPizza = Statistics.getMostOrderedPizzaName(allOrders);
//
//        System.out.println("=== Статистика ===");
//        System.out.println("Самый дорогой заказ: " + (mostExpensive != null ? mostExpensive : "нет"));
//        System.out.println("Самый дешёвый заказ: " + (cheapest != null ? cheapest : "нет"));
//        System.out.println("Средняя стоимость заказа: " + average);
//
//        System.out.println("Количество заказов по статусам:");
//        byStatus.forEach((status, count) ->
//                System.out.println("  " + status + ": " + count));
//
//        System.out.println("Самый активный клиент: " +
//                (activeCustomer != null ? activeCustomer : "не определён"));
//        System.out.println("Наиболее часто заказываемая пицца: " +
//                (mostOrderedPizza != null ? mostOrderedPizza : "не определена"));
//
//        // Количество заказов дороже заданной суммы
//        double threshold = Double.parseDouble(readLine("Введите сумму для фильтрации (руб.): "));
//        long above = Statistics.countOrdersAboveAmount(allOrders, threshold);
//        System.out.println("Количество заказов дороже " + threshold + " руб.: " + above);
//    }
//
//    private static void saveData() {
//        DataPersistence.saveCompletedOrders(allOrders);
//        Logger.getInstance().log("Данные сохранены.");
//        System.out.println("Завершённые заказы сохранены в файл completed_orders.txt");
//    }
//}
//

