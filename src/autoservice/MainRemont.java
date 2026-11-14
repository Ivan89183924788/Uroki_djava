////package autoservice;
////
////import autoservice.model_a.Client_a;
////import autoservice.model_a.CompatorRemont;
////import autoservice.model_a.RepairOrder_a;
////import autoservice.pattern.Logger;
////import autoservice.pattern.RepositoryRemont;
////import autoservice.utils.DataRemont;
////import autoservice.utils.SimulyatorRemont;
////
////import java.util.*;
////import java.util.stream.Collectors;
////
////public class MainRemont {
////    private static final Scanner sc=new Scanner(System.in);
////    private static final RepositoryRemont<Client_a> clientRepo=new RepositoryRemont<>();
////    private static final Map<String,Client_a> clientById =new HashMap<>();
////    private static final List<RepairOrder_a> allRepairOrders=new ArrayList<>();
////    private static final TreeSet<RepairOrder_a> sortedRepairOrders=new TreeSet<>(CompatorRemont.BY_TOTAL);
////    private static final Queue<String> queueRemont=new ArrayDeque<>();
////    private static final Deque<String> history=new ArrayDeque<>();
////    private static final HashSet<String> uniqueRepairOrderNumbers=new HashSet<>();
////
////    public static void main(String[] args){
////        List<RepairOrder_a> loaded= DataRemont.loadRepairOrder_a();
////        loaded.forEach(MainRemont::addRepairOrderToCollections);
////
////        Thread repairThread=new Thread(new SimulyatorRemont(queueRemont,
////                allRepairOrders.stream().collect(Collectors.toMap(RepairOrder_a::getOrderNumber,o->o))));
////        repairThread.setDaemon(true);
////        repairThread.start();
////
////        boolean running=true;
////        while (running){
////            printMenu();
////            int choice=readInt("Выберите пункт: ");
////            try{
////                switch (choice){
////                    case 1:
////                        addClient();
////                        break;
////                    case 2:
////                        registerAuto();
////                        break;
////                    case 3:
////                        dobRabotty();
////                        break;
////                    case 4:
////                        izmStatusRemont();
////                        break;
////                    case 5:
////                        raschitPrice();
////                        break;
////                    case 6:
////                        ocheredyDiagnostic();
////                        break;
////                    case 7:
////                        zayavkaRemont();
////                        break;
////                    case 8:
////                        sortZayavki();
////                        break;
////                    case 9:
////                        dorogoyRemont();
////                        break;
////                    case 10:
////                        sredStoimRemont();
////                        break;
////                    case 11:
////                        kolZayavokStatusa();
////                        break;
////                    case 12:
////                        saveData();
////                        break;
////                    case 0:
////                        running=false;
////                        break;
////                    default:
////                        System.out.println("Неверный выбор.");
////                }
////            }catch (Exception e){
////                Logger.getInstance().log("Ошибка операции: " +e.getMessage());
////                System.out.println("Произошла ошибка: "+ e.getMessage());
////            }
////        }
////        repairThread.interrupt();
////        System.out.println("Программа завершена.");
////    }
////
////    private static void addRepairOrderToCollections(RepairOrder_a o){
////        allRepairOrders.add(o);
////        sortedRepairOrders.add(o);
////        uniqueRepairOrderNumbers.add(o.getOrderNumber());
////    }
////
////    private static void printMenu(){
////        System.out.println("\n=== Управление автосервисом ===");
////        System.out.println("1.Добавить клиента");
////        System.out.println("2.Регистрировать автомобиль");
////        System.out.println("3.Создать заявку");
////        System.out.println("4.Поменять статус ремонта");
////        System.out.println("5.Рассчитать стоимость");
////        System.out.println("6.Вывести очередь на диагностику");
////        System.out.println("7.Найти заявку по ремонту");
////        System.out.println("8.Сортировать заявки");
////        System.out.println("9.Найти самый дорогой ремонт");
////        System.out.println("10.Вычеслить среднюю стоимость");
////        System.out.println("11.Вывести количество заявок каждого статуса");
////        System.out.println("12.Сохранять данные");
////        System.out.println("0.Выйти");
////
////    }
////
////
////
////
////}
//
//
//
//package autoservice;
//
//import autoservice.model_a.*;
//import autoservice.enum_a.*;
//import autoservice.interface_a.*;
//import autoservice.pattern.*;
//import autoservice.utils.*;
//
//import java.time.LocalDate;
//import java.util.*;
//import java.util.stream.Collectors;
//
//public class MainRemont {
//    private static final java.util.Scanner sc = new java.util.Scanner(System.in);
//    private static final RepositoryRemont<Client_a> clientRepo = new RepositoryRemont<>();
//    private static final Map<String, Client_a> clientById = new HashMap<>();
//    private static final List<RepairOrder_a> allRepairOrders = new ArrayList<>();
//    private static final TreeSet<RepairOrder_a> sortedRepairOrders = new TreeSet<>(CompatorRemont.BY_TOTAL);
//    private static final Queue<String> queueRemont = new ArrayDeque<>();
//    private static final Deque<String> history = new ArrayDeque<>();
//    private static final HashSet<String> uniqueRepairOrderNumbers = new HashSet<>();
//
//    public static void main(String[] args) {
//        List<RepairOrder_a> loaded = DataRemont.loadRepairOrder_a();
//        loaded.forEach(MainRemont::addRepairOrderToCollections);
//
//        Map<String, RepairOrder_a> ordersByNumber = allRepairOrders.stream()
//                .collect(Collectors.toMap(RepairOrder_a::getOrderNumber, o -> o));
//
//        Thread repairThread = new Thread(new SimulyatorRemont(queueRemont, ordersByNumber));
//        repairThread.setDaemon(true);
//        repairThread.start();
//
//        boolean running = true;
//        while (running) {
//            printMenu();
//            int choice = readInt("Выберите пункт: ");
//            try {
//                switch (choice) {
//                    case 1:
//                        addClient();
//                        break;
//                    case 2:
//                        registerAuto();
//                        break;
//                    case 3:
//                        createRepairOrder();
//                        break;
//                    case 4:
//                        changeStatus();
//                        break;
//                    case 5:
//                        calculatePrice();
//                        break;
//                    case 6:
//                        printDiagnosticQueue();
//                        break;
//                    case 7:
//                        findOrder();
//                        break;
//                    case 8:
//                        sortOrders();
//                        break;
//                    case 9:
//                        mostExpensive();
//                        break;
//                    case 10:
//                        averagePrice();
//                        break;
//                    case 11:
//                        countByStatus();
//                        break;
//                    case 12:
//                        saveData();
//                        break;
//                    case 0:
//                        running = false;
//                        break;
//                    default:
//                        System.out.println("Неверный выбор.");
//                }
//            } catch (Exception e) {
//                Logger.getInstance().log("Ошибка операции: " + e.getMessage());
//                System.out.println("Произошла ошибка: " + e.getMessage());
//            }
//        }
//        repairThread.interrupt();
//        System.out.println("Программа завершена.");
//    }
//
//    private static void addRepairOrderToCollections(RepairOrder_a o) {
//        allRepairOrders.add(o);
//        sortedRepairOrders.add(o);
//        uniqueRepairOrderNumbers.add(o.getOrderNumber());
//    }
//
//    private static void printMenu() {
//        System.out.println("\n=== Управление автосервисом ===");
//        System.out.println("1. Добавить клиента");
//        System.out.println("2. Зарегистрировать автомобиль");
//        System.out.println("3. Создать заявку на ремонт");
//        System.out.println("4. Поменять статус ремонта");
//        System.out.println("5. Рассчитать стоимость заявки");
//        System.out.println("6. Вывести очередь на диагностику");
//        System.out.println("7. Найти заявку по номеру");
//        System.out.println("8. Сортировать заявки по стоимости");
//        System.out.println("9. Найти самый дорогой ремонт");
//        System.out.println("10. Вычислить среднюю стоимость");
//        System.out.println("11. Вывести количество заявок по статусам");
//        System.out.println("12. Сохранить данные");
//        System.out.println("0. Выйти");
//    }
//
//    private static int readInt(String prompt) {
//        System.out.print(prompt);
//        while (!sc.hasNextInt()) {
//            System.out.print("Введите число: ");
//            sc.next();
//        }
//        int value = sc.nextInt();
//        sc.nextLine(); // очистка буфера
//        return value;
//    }
//
//    private static String readLine(String prompt) {
//        System.out.print(prompt);
//        return sc.nextLine();
//    }
//
//    private static void addClient() {
//        String id = readLine("ID клиента: ");
//        String name = readLine("Имя клиента: ");
//        Client_a c = new Client_a(id, name, 0);
//        clientRepo.addWithKey(id, c);
//        clientById.put(id, c);
//        Logger.getInstance().log("Добавлен клиент: " + name);
//        System.out.println("Клиент добавлен.");
//    }
//
//    private static void registerAuto() {
//        String typeStr = readLine("Тип авто (CAR/TRUCK/MOTOCICLE): ");
//        Vihicle_type type = Vihicle_type.valueOf(typeStr.toUpperCase());
//        String years = readLine("Год выпуска: ");
//        String nomer = readLine("Гос. номер: ");
//        String model = readLine("Модель: ");
//        String marka = readLine("Марка: ");
//        double price = Double.parseDouble(readLine("Цена ремонта авто: "));
//
//        Vehicle_a v = VehicleFactory.create(type, years, nomer, model, marka, price);
//        System.out.println("Авто зарегистрировано: " + v);
//        // Если у тебя есть AutoService с очередью диагностики — можно добавить туда.
//        // Иначе просто показываем, что авто создано.
//    }
//
//    private static void createRepairOrder() {
//        String number = readLine("Номер заказа: ");
//        if (uniqueRepairOrderNumbers.contains(number)) {
//            System.out.println("Такой номер уже существует.");
//            return;
//        }
//        String clientId = readLine("ID клиента: ");
//        Client_a client = clientById.get(clientId);
//        if (client == null) {
//            System.out.println("Клиент не найден.");
//            return;
//        }
//
//        String dateStr = readLine("Дата ремонта (ГГГГ-ММ-ДД): ");
//        LocalDate date = LocalDate.parse(dateStr);
//
//        RepairOrder_a order = new BuilderRemont(number, client, date)
//                .setSrochnosty(Srochnosty.OBICHNIY)
//                .setStatusRemont(RepairStatus.NEW)
//                .build();
//
//        String autoNomer = readLine("Гос. номер авто для заказа: ");
//        Vehicle_a auto = findVehicleByNumber(autoNomer);
//        if (auto != null) {
//            order.addVehicle(auto);
//        } else {
//            System.out.println("Авто не найдено, заказ создан без авто.");
//        }
//
//        String addServices = readLine("Добавить услуги? (да/нет): ");
//        if ("да".equalsIgnoreCase(addServices)) {
//            while (true) {
//                String typeStr = readLine("Тип услуги (DIAGNOSTICS/OIL_CHANGE/ENGINE_REPAIR/TIRE_CHANGE) или 'стоп': ");
//                if ("стоп".equalsIgnoreCase(typeStr)) break;
//                ServiceType st = ServiceType.valueOf(typeStr.toUpperCase());
//                order.addService(ServiceFactory.create(st));
//                System.out.println("Услуга добавлена: " + st.getName());
//            }
//        }
//
//        addRepairOrderToCollections(order);
//        System.out.println("Заявка создана: " + number);
//    }
//
//    private static Vehicle_a findVehicleByNumber(String nomer) {
//        for (RepairOrder_a o : allRepairOrders) {
//            for (Vehicle_a v : o.getVehicle_a()) {
//                if (Objects.equals(v.getNomer(), nomer)) return v;
//            }
//        }
//        return null;
//    }
//
//    private static void changeStatus() {
//        String number = readLine("Номер заказа: ");
//        Optional<RepairOrder_a> opt = allRepairOrders.stream()
//                .filter(o -> Objects.equals(o.getOrderNumber(), number))
//                .findFirst();
//        if (opt.isEmpty()) {
//            System.out.println("Заявка не найдена.");
//            return;
//        }
//        RepairOrder_a o = opt.get();
//        String statusStr = readLine("Новый статус (NEW/DIAGNOSTICS/REPAIR/READY/COMPLETED/CANCELLED): ");
//        RepairStatus newStatus = RepairStatus.valueOf(statusStr.toUpperCase());
//        o.changeStatus(newStatus);
//        System.out.println("Статус изменён на: " + newStatus);
//    }
//
//    private static void calculatePrice() {
//        String number = readLine("Номер заказа: ");
//        Optional<RepairOrder_a> opt = allRepairOrders.stream()
//                .filter(o -> Objects.equals(o.getOrderNumber(), number))
//                .findFirst();
//        if (opt.isEmpty()) {
//            System.out.println("Заявка не найдена.");
//            return;
//        }
//        double total = opt.get().calculateTotal();
//        System.out.printf("Общая стоимость заявки: %.2f%n", total);
//    }
//
//    private static void printDiagnosticQueue() {
//        // Здесь можно вывести очередь из AutoService, если она доступна.
//        // Для примера просто покажем, что очередь есть.
//        System.out.println("Очередь на ремонт (номера заказов): " + queueRemont);
//        if (queueRemont.isEmpty()) {
//            System.out.println("[Пусто]");
//        }
//    }
//
//    private static void findOrder() {
//        String number = readLine("Номер заказа: ");
//        Optional<RepairOrder_a> opt = allRepairOrders.stream()
//                .filter(o -> Objects.equals(o.getOrderNumber(), number))
//                .findFirst();
//        if (opt.isEmpty()) {
//            System.out.println("Заявка не найдена.");
//            return;
//        }
//        System.out.println(opt.get());
//    }
//
//    private static void sortOrders() {
//        // sortedRepairOrders уже отсортирован по BY_TOTAL
//        System.out.println("Отсортированные заявки:");
//        sortedRepairOrders.forEach(System.out::println);
//    }
//
//    private static void mostExpensive() {
//        RepairOrder_a mostExpensive = allRepairOrders.stream()
//                .max(Comparator.comparingDouble(RepairOrder_a::calculateTotal))
//                .orElse(null);
//        if (mostExpensive != null) {
//            System.out.printf("Самый дорогой ремонт: %s, сумма: %.2f%n",
//                    mostExpensive.getOrderNumber(), mostExpensive.calculateTotal());
//        } else {
//            System.out.println("Нет заявок.");
//        }
//    }
//
//    private static void averagePrice() {
//        double average = allRepairOrders.stream()
//                .mapToDouble(RepairOrder_a::calculateTotal)
//                .average()
//                .orElse(0.0);
//        System.out.printf("Средняя стоимость ремонта: %.2f%n", average);
//    }
//
//    private static void countByStatus() {
//        Map<RepairStatus, Long> countByStatus = allRepairOrders.stream()
//                .collect(Collectors.groupingBy(
//                        RepairOrder_a::getStatusRemont,
//                        Collectors.counting()));
//        countByStatus.forEach((status, count) ->
//                System.out.println(status + ": " + count));
//    }
//
//    private static void saveData() {
//        DataRemont.saveCompletedRepair_Orders_a(allRepairOrders);
//        System.out.println("Данные сохранены.");
//    }
//}
