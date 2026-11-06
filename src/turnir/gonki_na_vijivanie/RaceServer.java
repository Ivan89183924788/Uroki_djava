//package turnir.gonki_na_vijivanie;
//
//// package game.server;
//
//import java.io.IOException;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.*;
//
//// --- Модели ---
//
//enum Role {
//    RUNNER("Бегун"), SWIMMER("Пловец"), CLIMBER("Скалолаз");
//    private final String displayName;
//    Role(String displayName) { this.displayName = displayName; }
//    public String getDisplayName() { return displayName; }
//}
//
//enum Style { FAST, STAMINA, BALANCED }
//
//enum Group {
//    ALPHA("Команда Альфа"), BETA("Команда Бета"), GAMMA("Команда Гамма");
//    private final String displayName;
//    Group(String displayName) { this.displayName = displayName; }
//    public String getDisplayName() { return displayName; }
//}
//
//enum ObstacleType { RUN, SWIM, CLIMB }
//
//record StatsByObstacle(
//        double runSpeed, double runStaminaDrainPerMeter,
//        double swimSpeed, double swimStaminaDrainPerMeter,
//        double climbSpeed, double climbStaminaDrainPerMeter
//) {}
//
//record Item(String name, double speedBonus, boolean isBonus) {}
//
//class Athlete {
//    private final Group team;
//    private final Role role;
//    private final Style style;
//    private final String name;
//
//    private double currentStamina;
//    private double injuryPenalty = 0.0;
//    private double randomSpeedBonus = 0.0;
//    private Item activeItem = null;
//
//    public Athlete(Group team, Role role, Style style, String name) {
//        this.team = team;
//        this.role = role;
//        this.style = style;
//        this.name = name;
//        resetStamina();
//    }
//
//    public void resetStamina() {
//        currentStamina = 1.0;
//        injuryPenalty = 0.0;
//        randomSpeedBonus = 0.0;
//        activeItem = null;
//    }
//
//    public double getBaseSpeed(ObstacleType type) {
//        var s = AthleteConfig.get(role, style);
//        return switch (type) {
//            case RUN -> s.runSpeed();
//            case SWIM -> s.swimSpeed();
//            case CLIMB -> s.climbSpeed();
//        };
//    }
//
//    public double calculateFinalStamina(double distance, ObstacleType type) {
//        double drainPerMeter = getStaminaDrainPerMeter(type);
//        double finalStamina = 1.0 - (drainPerMeter * distance);
//        return Math.max(0.0, finalStamina);
//    }
//
//    private double getStaminaDrainPerMeter(ObstacleType type) {
//        var s = AthleteConfig.get(role, style);
//        return switch (type) {
//            case RUN -> s.runStaminaDrainPerMeter();
//            case SWIM -> s.swimStaminaDrainPerMeter();
//            case CLIMB -> s.climbStaminaDrainPerMeter();
//        };
//    }
//
//    public double calculateAverageSpeed(double distance, ObstacleType type) {
//        double initialSpeed = getBaseSpeed(type);
//        double finalStamina = calculateFinalStamina(distance, type);
//        double finalSpeed = finalStamina * initialSpeed;
//        double avgSpeed = (initialSpeed + finalSpeed) / 2.0;
//
//        avgSpeed += randomSpeedBonus;
//
//        if (activeItem != null) {
//            avgSpeed += activeItem.speedBonus();
//        }
//
//        avgSpeed -= injuryPenalty;
//
//        return Math.max(0.1, avgSpeed);
//    }
//
//    public double passStage(double distance, ObstacleType type) {
//        resetStamina();
//        // Случайные события: от -0.3 до +0.3
//        randomSpeedBonus = (Math.random() - 0.5) * 2.0 * 0.3;
//
//        double time = distance / calculateAverageSpeed(distance, type);
//        return time;
//    }
//
//    public Group getTeam() { return team; }
//    public Role getRole() { return role; }
//    public Style getStyle() { return style; }
//    public String getName() { return name; }
//
//    public void setItem(Item item) { activeItem = item; }
//    public Item getItem() { return activeItem; }
//
//    // Для вывода в консоль
//    public double getRandomSpeedBonus() { return randomSpeedBonus; }
//}
//
//class Team {
//    private final Group group;
//    private final List<Athlete> members = new ArrayList<>();
//
//    Team(Group group) { this.group = group; }
//    public void addMember(Athlete a) { members.add(a); }
//    public List<Athlete> getMembers() { return members; }
//    public Group getGroup() { return group; }
//}
//
//class AthleteConfig {
//    private static final Map<Map.Entry<Role, Style>, StatsByObstacle> STATS = Map.ofEntries(
//            Map.entry(Map.entry(Role.RUNNER, Style.FAST),
//                    new StatsByObstacle(10.0, 0.004, 5.0, 0.006, 6.5, 0.007)),
//            Map.entry(Map.entry(Role.RUNNER, Style.STAMINA),
//                    new StatsByObstacle(8.5, 0.003, 4.5, 0.005, 6.0, 0.006)),
//            Map.entry(Map.entry(Role.RUNNER, Style.BALANCED),
//                    new StatsByObstacle(9.0, 0.0035, 6.0, 0.0055, 7.0, 0.0065)),
//
//            Map.entry(Map.entry(Role.SWIMMER, Style.FAST),
//                    new StatsByObstacle(6.0, 0.005, 10.0, 0.004, 5.5, 0.008)),
//            Map.entry(Map.entry(Role.SWIMMER, Style.STAMINA),
//                    new StatsByObstacle(5.0, 0.0045, 9.5, 0.0035, 5.0, 0.007)),
//            Map.entry(Map.entry(Role.SWIMMER, Style.BALANCED),
//                    new StatsByObstacle(7.0, 0.0045, 8.5, 0.0045, 6.5, 0.0075)),
//
//            Map.entry(Map.entry(Role.CLIMBER, Style.FAST),
//                    new StatsByObstacle(6.5, 0.005, 5.5, 0.006, 10.0, 0.005)),
//            Map.entry(Map.entry(Role.CLIMBER, Style.STAMINA),
//                    new StatsByObstacle(6.0, 0.004, 5.0, 0.005, 11.0, 0.004)),
//            Map.entry(Map.entry(Role.CLIMBER, Style.BALANCED),
//                    new StatsByObstacle(7.5, 0.0045, 6.5, 0.0055, 9.0, 0.0055))
//    );
//
//    public static StatsByObstacle get(Role role, Style style) {
//        return STATS.get(Map.entry(role, style));
//    }
//}
//
//// --- Сервер ---
//
//public class RaceServer {
//    private final Scanner scanner = new Scanner(System.in);
//    private volatile boolean running = true;
//    private Path dataFile = Paths.get("race_results.txt");
//
//    private List<Team> teams;
//    private Map<ObstacleType, Double> distances = new EnumMap<>(ObstacleType.class);
//    private List<Role> stageOrder = new ArrayList<>();
//    private Map<Group, Double> totalTeamTime = new HashMap<>();
//    private boolean isRaceStarted = false;
//
//    public RaceServer() {
//        teams = createTeams();
//        for (Group g : Group.values()) {
//            totalTeamTime.put(g, 0.0);
//        }
//        loadData();
//    }
//
//    private void loadData() {
//        try {
//            if (dataFile.toFile().exists()) {
//                System.out.println("Результаты предыдущей гонки найдены (файл race_results.txt).");
//            } else {
//                System.out.println("Файл результатов не найден — начнём новую гонку.");
//            }
//        } catch (Exception e) {
//            System.out.println("Не удалось проверить файл результатов: " + e.getMessage());
//        }
//    }
//
//    private void saveData() {
//        try {
//            java.nio.file.Files.writeString(dataFile, formatResults());
//            System.out.println("Результаты гонки сохранены в race_results.txt.");
//        } catch (IOException e) {
//            System.err.println("Ошибка сохранения результатов: " + e.getMessage());
//        }
//    }
//
//    private String formatResults() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("=== ИТОГОВЫЕ РЕЗУЛЬТАТЫ ГОНКИ ===\n");
//        for (Map.Entry<Group, Double> e : totalTeamTime.entrySet()) {
//            sb.append(e.getKey().getDisplayName()).append(": ").append(String.format("%.2f", e.getValue())).append(" с\n");
//        }
//        Group winner = getWinner();
//        if (winner != null) {
//            sb.append("🏆 ПОБЕДИТЕЛЬ: ").append(winner.getDisplayName()).append("\n");
//        }
//        return sb.toString();
//    }
//
//    private Group getWinner() {
//        Group winner = null;
//        double minTime = Double.MAX_VALUE;
//        for (Map.Entry<Group, Double> e : totalTeamTime.entrySet()) {
//            if (e.getValue() < minTime) {
//                minTime = e.getValue();
//                winner = e.getKey();
//            }
//        }
//        return winner;
//    }
//
//    private List<Item> generateStageItems(int count) {
//        List<Item> items = new ArrayList<>();
//        String[] bonusNames = {"Лёгкие кроссовки", "Энергетик", "Попутный ветер", "Надёжные перчатки", "Сухой костюм"};
//        String[] damageNames = {"Подвёрнутая нога", "Тяжёлый рюкзак", "Сильное течение", "Острые камни", "Усталость"};
//
//        for (int i = 0; i < 5 && items.size() < count; i++) {
//            items.add(new Item(bonusNames[i], 1.2 + Math.random(), true));
//        }
//        for (int i = 0; i < 4 && items.size() < count; i++) {
//            items.add(new Item(damageNames[i], -(0.8 + Math.random()), false));
//        }
//        Collections.shuffle(items);
//        return items;
//    }
//
//    private int readInt() {
//        while (true) {
//            try {
//                return Integer.parseInt(scanner.nextLine().trim());
//            } catch (NumberFormatException e) {
//                System.out.print("Введите корректное число: ");
//            }
//        }
//    }
//
//    private double readDouble() {
//        while (true) {
//            try {
//                return Double.parseDouble(scanner.nextLine().trim());
//            } catch (NumberFormatException e) {
//                System.out.print("Введите корректное число (дистанция): ");
//            }
//        }
//    }
//
//    private String readLine() {
//        return scanner.nextLine();
//    }
//
//    private void showMenu() {
//        System.out.println("\n=== Сервер гонки (RaceServer) ===");
//        System.out.println("1. Задать дистанции для препятствий");
//        System.out.println("2. Задать порядок этапов (роли)");
//        System.out.println("3. Запустить гонку (симуляция этапов)");
//        System.out.println("4. Показать текущие результаты");
//        System.out.println("5. Сохранить результаты в файл");
//        System.out.println("6. Запустить фоновый мониторинг трассы");
//        System.out.println("0. Выход");
//        System.out.print("> ");
//    }
//
//    private void setDistances() {
//        System.out.println("Введите дистанцию для каждого этапа (в метрах):");
//        System.out.print("Бег по пересечёнке: ");
//        distances.put(ObstacleType.RUN, readDouble());
//        System.out.print("Плавание по реке: ");
//        distances.put(ObstacleType.SWIM, readDouble());
//        System.out.print("Лазание по горам: ");
//        distances.put(ObstacleType.CLIMB, readDouble());
//        System.out.println("Дистанции установлены.");
//    }
//
//    private void setStageOrder() {
//        stageOrder.clear();
//        System.out.println("Выберите порядок этапов по ролям:");
//        System.out.println("1 - Пловцы, 2 - Бегуны, 3 - Скалолазы");
//        for (int i = 0; i < 3; i++) {
//            System.out.print("Этап " + (i + 1) + " (1=Пловцы, 2=Бегуны, 3=Скалолазы): ");
//            int choice = readInt();
//            Role r = switch (choice) {
//                case 1 -> Role.SWIMMER;
//                case 2 -> Role.RUNNER;
//                case 3 -> Role.CLIMBER;
//                default -> throw new IllegalArgumentException("Неверный выбор");
//            };
//            stageOrder.add(r);
//        }
//        System.out.println("Порядок этапов установлен.");
//    }
//
//    private void runRace() {
//        if (distances.isEmpty() || stageOrder.isEmpty()) {
//            System.out.println("Сначала задайте дистанции (1) и порядок этапов (2).");
//            return;
//        }
//
//        isRaceStarted = true;
//        totalTeamTime.replaceAll((k, v) -> 0.0); // сброс
//
//        List<Item> remainingItems = new ArrayList<>();
//
//        for (Role role : stageOrder) {
//            ObstacleType obstacleType = switch (role) {
//                case RUNNER -> ObstacleType.RUN;
//                case SWIMMER -> ObstacleType.SWIM;
//                case CLIMBER -> ObstacleType.CLIMB;
//            };
//
//            double distance = distances.get(obstacleType);
//
//            System.out.println("\n--- Этап: " + role.getDisplayName() + " (" + obstacleType + "), дистанция " + distance + " м ---");
//
//            if (remainingItems.isEmpty()) {
//                remainingItems = generateStageItems(9);
//            }
//
//            System.out.println("Доступные бонусы/урон (9 шт):");
//            for (int i = 0; i < remainingItems.size(); i++) {
//                Item it = remainingItems.get(i);
//                String type = it.isBonus() ? "Бонус" : "Урон";
//                System.out.printf("%d. %s (%s, изменение скорости: %.2f)%n",
//                        i, it.name(), type, it.speedBonus());
//            }
//
//            System.out.println("Выберите 3 номера (0-8) для распределения по 3 игрокам:");
//            List<Integer> chosenIndices = new ArrayList<>();
//            while (chosenIndices.size() < 3) {
//                int idx = readInt();
//                if (idx < 0 || idx >= remainingItems.size()) {
//                    System.out.println("Недопустимый номер. Выберите от 0 до " + (remainingItems.size() - 1));
//                    continue;
//                }
//                if (chosenIndices.contains(idx)) {
//                    System.out.println("Этот номер уже выбран. Выберите другой.");
//                    continue;
//                }
//                chosenIndices.add(idx);
//            }
//
//            // Собираем выбранных участников (по роли)
//            List<Athlete> participants = new ArrayList<>();
//            for (Team t : teams) {
//                for (Athlete a : t.getMembers()) {
//                    if (a.getRole() == role) {
//                        participants.add(a);
//                    }
//                }
//            }
//
//            // Раздаём предметы
//            for (int i = 0; i < 3; i++) {
//                participants.get(i).setItem(remainingItems.get(chosenIndices.get(i)));
//            }
//
//            // Проходим этап
//
//            // Проходим этап
//            System.out.println("\n--- Старт этапа для участников ---");
//            for (Athlete a : participants) {
//                double time = a.passStage(distance, obstacleType);
//                totalTeamTime.merge(a.getTeam(), time, Double::sum);
//
//                System.out.printf(
//                        "%s (%s, %s) — дистанция %.1f м, время: %.2f с, случайное событие: %.2f м/с, предмет: %s (%.2f)%n",
//                        a.getName(),
//                        a.getTeam().getDisplayName(),
//                        a.getRole().getDisplayName(),
//                        distance,
//                        time,
//                        a.getRandomSpeedBonus(),
//                        a.getItem() != null ? a.getItem().name() : "нет",
//                        a.getItem() != null ? a.getItem().speedBonus() : 0.0
//                );
//            }
//
//            // Очищаем предметы после этапа (чтобы не тянулись дальше)
//            for (Athlete a : participants) {
//                a.setItem(null);
//            }
//
//            // Удаляем использованные предметы из пула
//            List<Item> usedItems = new ArrayList<>();
//            for (int idx : chosenIndices) {
//                usedItems.add(remainingItems.get(idx));
//            }
//            remainingItems.removeAll(usedItems);
//
//            System.out.printf("\nТекущее суммарное время команд: %n");
//            for (Group g : Group.values()) {
//                System.out.printf("%s: %.2f с%n", g.getDisplayName(), totalTeamTime.getOrDefault(g, 0.0));
//            }
//        }
//
//        isRaceStarted = false;
//        System.out.println("\n=== Гонка завершена ===");
//        Group winner = getWinner();
//        if (winner != null) {
//            System.out.println("🏆 ПОБЕДИТЕЛЬ: " + winner.getDisplayName());
//        } else {
//            System.out.println("Не удалось определить победителя.");
//        }
//    }
//
//    private void showResults() {
//        if (totalTeamTime.isEmpty()) {
//            System.out.println("Нет результатов для показа.");
//            return;
//        }
//        System.out.println("\n=== Текущие результаты команд ===");
//        for (Group g : Group.values()) {
//            double time = totalTeamTime.getOrDefault(g, 0.0);
//            System.out.printf("%s: %.2f с%n", g.getDisplayName(), time);
//        }
//        Group winner = getWinner();
//        if (winner != null) {
//            System.out.println("Лидер: " + winner.getDisplayName());
//        }
//    }
//
//    private void startMonitorThread() {
//        Thread monitor = new Thread(() -> {
//            while (running) {
//                try {
//                    // Имитация фонового мониторинга трассы
//                    System.out.println("[Мониторинг] Трасса в норме, проверка каждые 5 секунд...");
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    System.out.println("[Мониторинг] Поток остановлен.");
//                    break;
//                }
//            }
//        });
//        monitor.setDaemon(true);
//        monitor.start();
//        System.out.println("Фоновый мониторинг трассы запущен.");
//    }
//
//    private List<Team> createTeams() {
//        List<Team> teams = new ArrayList<>();
//
//        // Команда Альфа: быстрый бегун, сбалансированный пловец, выносливый скалолаз
//        Team alpha = new Team(Group.ALPHA);
//        alpha.addMember(new Athlete(Group.ALPHA, Role.RUNNER, Style.FAST, "Алекс"));
//        alpha.addMember(new Athlete(Group.ALPHA, Role.SWIMMER, Style.BALANCED, "Вика"));
//        alpha.addMember(new Athlete(Group.ALPHA, Role.CLIMBER, Style.STAMINA, "Дима"));
//        teams.add(alpha);
//
//        // Команда Бета: выносливый бегун, быстрый пловец, сбалансированный скалолаз
//        Team beta = new Team(Group.BETA);
//        beta.addMember(new Athlete(Group.BETA, Role.RUNNER, Style.STAMINA, "Борис"));
//        beta.addMember(new Athlete(Group.BETA, Role.SWIMMER, Style.FAST, "Катя"));
//        beta.addMember(new Athlete(Group.BETA, Role.CLIMBER, Style.BALANCED, "Олег"));
//        teams.add(beta);
//
//        // Команда Гамма: сбалансированный бегун, выносливый пловец, быстрый скалолаз
//        Team gamma = new Team(Group.GAMMA);
//        gamma.addMember(new Athlete(Group.GAMMA, Role.RUNNER, Style.BALANCED, "Женя"));
//        gamma.addMember(new Athlete(Group.GAMMA, Role.SWIMMER, Style.STAMINA, "Лена"));
//        gamma.addMember(new Athlete(Group.GAMMA, Role.CLIMBER, Style.FAST, "Миша"));
//        teams.add(gamma);
//
//        return teams;
//    }
//
//    public void runLoop() {
//        while (running) {
//            showMenu();
//            int choice = readInt();
//
//            switch (choice) {
//                case 1 -> setDistances();
//                case 2 -> setStageOrder();
//                case 3 -> runRace();
//                case 4 -> showResults();
//                case 5 -> saveData();
//                case 6 -> startMonitorThread();
//                case 0 -> {
//                    running = false;
//                    System.out.println("Выход из сервера гонки.");
//                }
//                default -> System.out.println("Неверная опция, попробуйте снова.");
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        RaceServer server = new RaceServer();
//        server.runLoop();
//    }
//}
