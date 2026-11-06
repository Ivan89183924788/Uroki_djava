//package game.server;
//
//import game.exceptions.GameException;
//import game.model.*;
//import game.model.Character;
//import game.patterns.*;
//import game.collections.Inventory;
//import java.io.IOException;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.*;
//import java.util.concurrent.*;
//import java.util.function.Predicate;
//import java.util.stream.Collectors;
//
//public class GameServer {
//    private final GameSession session;
//    private final Path dataFile = Paths.get("players_data.txt");
//    private volatile boolean running = true;
//    private final Scanner scanner = new Scanner(System.in);
//
//    public GameServer() {
//        session = new GameSession();
//        loadData();
//    }
//
//    private void loadData() {
//        try {
//            session.loadFromFile(dataFile);
//            System.out.println("Данные игроков загружены из файла.");
//        } catch (IOException e) {
//            System.out.println("Не удалось загрузить данные (файл может отсутствовать).");
//        }
//    }
//
//    private void saveData() {
//        try {
//            session.saveToFile(dataFile);
//            System.out.println("Данные сохранены в файл.");
//        } catch (IOException e) {
//            System.out.println("Ошибка сохранения данных: " + e.getMessage());
//        }
//    }
//
//    // Отдельный поток: имитация обработки очереди боёв
//    private void startBattleQueueProcessor() {
//        Thread battleThread = new Thread(() -> {
//            while (running) {
//                try {
//                    Queue<Player> queue = session.getBattleQueue();
//                    if (!queue.isEmpty()) {
//                        Player p1 = queue.poll();
//                        Player p2 = queue.poll(); // может быть null, если остался 1 игрок
//
//                        if (p1 != null && p2 != null) {
//                            try {
//                                session.startBattle(p1, p2);
//                                System.out.println("[Фоновый поток] Проведён бой: " + p1.getName() + " vs " + p2.getName());
//                            } catch (GameException e) {
//                                System.err.println("[Фоновый поток] Ошибка боя: " + e.getMessage());
//                            }
//                        } else if (p1 != null) {
//                            // Если остался один — возвращаем в очередь, чтобы не потерять
//                            queue.offer(p1);
//                        }
//                    } else {
//                        // Очередь пуста — спим, чтобы не гонять CPU
//                        Thread.sleep(1000);
//                    }
//                } catch (InterruptedException e) {
//                    Thread.currentThread().interrupt();
//                    break;
//                }
//            }
//        }, "BattleQueueProcessor");
//        battleThread.setDaemon(true);
//        battleThread.start();
//        System.out.println("Фоновый поток обработки очереди боёв запущен.");
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
//    private long readLong() {
//        while (true) {
//            try {
//                return Long.parseLong(scanner.nextLine().trim());
//            } catch (NumberFormatException e) {
//                System.out.print("Введите корректное число (золото): ");
//            }
//        }
//    }
//
//    private String readLine() {
//        return scanner.nextLine();
//    }
//
//    private void showMenu() {
//        System.out.println("\n=== Игровой сервер ===");
//        System.out.println("1. Зарегистрировать игрока");
//        System.out.println("2. Создать персонажа (через Factory)");
//        System.out.println("3. Создать персонажа (через Builder)");
//        System.out.println("4. Добавить предмет в инвентарь");
//        System.out.println("5. Удалить предметы по условию (лямбда)");
//        System.out.println("6. Поставить игрока в очередь на бой");
//        System.out.println("7. Провести бой вручную (если очередь пуста)");
//        System.out.println("8. Выполнить задание");
//        System.out.println("9. Показать рейтинг (TreeSet)");
//        System.out.println("10. Показать всех игроков (с лямбдой и ::)");
//        System.out.println("11. Показать статистику (золото, кол-во предметов)");
//        System.out.println("12. Сохранить данные в файл");
//        System.out.println("0. Выход");
//        System.out.print("> ");
//    }
//
//    private void registerPlayer() {
//        System.out.print("Имя игрока: ");
//        String name = readLine().trim();
//        if (name.isEmpty()) {
//            System.out.println("Имя не может быть пустым.");
//            return;
//        }
//        try {
//            Player p = session.registerPlayer(name);
//            System.out.println("Игрок зарегистрирован: " + p);
//        } catch (GameException e) {
//            System.err.println("Ошибка регистрации: " + e.getMessage());
//        }
//    }
//
//    private void createCharacterWithFactory() {
//        System.out.print("ID игрока: ");
//        int id = readInt();
//        try {
//            Player p = session.getPlayerById(id);
//            System.out.println("Выберите тип персонажа: 1-Warrior, 2-Mage, 3-Archer");
//            int choice = readInt();
//            CharacterType type = switch (choice) {
//                case 1 -> CharacterType.WARRIOR;
//                case 2 -> CharacterType.MAGE;
//                case 3 -> CharacterType.ARCHER;
//                default -> throw new IllegalArgumentException("Неверный выбор");
//            };
//            Character c = CharacterFactory.create(type, p.getName() + "'s character");
//            p.setCharacter(c);
//            System.out.println("Персонаж создан через Factory: " + c.getName() + ", тип: " + type);
//        } catch (GameException | IllegalArgumentException e) {
//            System.err.println("Ошибка создания персонажа: " + e.getMessage());
//        }
//    }
//
//    private void createCharacterWithBuilder() {
//        System.out.print("ID игрока: ");
//        int id = readInt();
//        try {
//            Player p = session.getPlayerById(id);
//            System.out.print("Имя персонажа: ");
//            String name = readLine();
//            System.out.println("Тип: 1-WARRIOR, 2-MAGE, 3-ARCHER");
//            int typeChoice = readInt();
//            CharacterType type = switch (typeChoice) {
//                case 1 -> CharacterType.WARRIOR;
//                case 2 -> CharacterType.MAGE;
//                case 3 -> CharacterType.ARCHER;
//                default -> throw new IllegalArgumentException("Неверный тип");
//            };
//
//            CharacterBuilder builder = new CharacterBuilder()
//                    .setName(name)
//                    .setType(type);
//
//            System.out.print("Оружие (название, или Enter для пропуска): ");
//            String weaponName = readLine();
//            if (!weaponName.isEmpty()) {
//                System.out.print("Урон оружия: ");
//                int dmg = readInt();
//                builder.setWeapon(new Weapon(weaponName, dmg));
//            }
//
//            System.out.print("Броня (описание, или Enter): ");
//            String armor = readLine();
//            if (!armor.isEmpty()) builder.setArmor(armor);
//
//            System.out.print("Питомец (имя, или Enter): ");
//            String pet = readLine();
//            if (!pet.isEmpty()) builder.setPet(pet);
//
//            System.out.print("Способность (описание, или Enter): ");
//            String ability = readLine();
//            if (!ability.isEmpty()) builder.setAbility(ability);
//
//            Character c = builder.build();
//            p.setCharacter(c);
//            System.out.println("Персонаж создан через Builder: " + c.getName());
//        } catch (GameException | IllegalArgumentException e) {
//            System.err.println("Ошибка: " + e.getMessage());
//        }
//    }
//
//    private void addItemToInventory() {
//        System.out.print("ID игрока: ");
//        int id = readInt();
//        try {
//            Player p = session.getPlayerById(id);
//            System.out.print("Название предмета: ");
//            String itemName = readLine();
//            // В реальном проекте тут был бы отдельный класс Item, пока храним как Object
//            p.getInventory().add(itemName);
//            System.out.println("Предмет добавлен в инвентарь игрока " + p.getName());
//        } catch (GameException e) {
//            System.err.println("Ошибка: " + e.getMessage());
//        }
//    }
//
//    private void removeItemsByCondition() {
//        System.out.print("ID игрока: ");
//        int id = readInt();
//        try {
//            Player p = session.getPlayerById(id);
//            System.out.println("Удалить предметы, содержащие слово (регистронезависимо): ");
//            String keyword = readLine().toLowerCase();
//
//            // Лямбда + Predicate
//            Predicate<Object> predicate = item -> {
//                if (!(item instanceof String s)) return false;
//                return s.toLowerCase().contains(keyword);
//            };
//
//            p.getInventory().removeIf(predicate);
//            System.out.println("Предметы, содержащие \"" + keyword + "\", удалены.");
//        } catch (GameException e) {
//            System.err.println("Ошибка: " + e.getMessage());
//        }
//    }
//
//    private void enqueueForBattle() {
//        System.out.print("ID игрока для очереди: ");
//        int id = readInt();
//        try {
//            Player p = session.getPlayerById(id);
//            session.getBattleQueue().offer(p);
//            System.out.println(p.getName() + " поставлен в очередь на бой.");
//        } catch (GameException e) {
//            System.err.println("Ошибка: " + e.getMessage());
//        }
//    }
//
//    private void manualBattle() {
//        System.out.print("ID первого игрока: ");
//        int id1 = readInt();
//        System.out.print("ID второго игрока: ");
//        int id2 = readInt();
//        try {
//            Player p1 = session.getPlayerById(id1);
//            Player p2 = session.getPlayerById(id2);
//            session.startBattle(p1, p2);
//            System.out.println("Ручной бой завершён.");
//        } catch (GameException e) {
//            System.err.println("Ошибка боя: " + e.getMessage());
//        }
//    }
//
//    private void completeQuest() {
//        System.out.print("ID игрока: ");
//        int id = readInt();
//        try {
//            Player p = session.getPlayerById(id);
//            System.out.print("Название задания: ");
//            String questTitle = readLine();
//            Quest q = new Quest(questTitle);
//            p.completeQuest(q);
//            System.out.println("Задание выполнено: " + questTitle);
//        } catch (GameException e) {
//            System.err.println("Ошибка: " + e.getMessage());
//        }
//    }
//
//    private void showLeaderboard() {
//        TreeSet<Player> leaderboard = session.getLeaderboard();
//        // Сортировка по золоту уже в TreeSet (через Comparable)
//        System.out.println("=== Рейтинг игроков (по золоту) ===");
//        // Ссылка на метод ::toString
//        leaderboard.forEach(System.out::println);
//    }
//
//    private void showAllPlayersWithLambda() {
//        Map<Integer, Player> players = session.getPlayers();
//        System.out.println("=== Все игроки ===");
//        // Лямбда для форматированного вывода
//        players.values().forEach(p ->
//                System.out.printf("ID: %d | Имя: %s | Золото: %d%n",
//                        p.getId(), p.getName(), p.getGold())
//        );
//    }
//
//    private void showStats() {
//        Map<Integer, Player> players = session.getPlayers();
//        long totalGold = players.values().stream()
//                .mapToLong(Player::getGold)
//                .sum();
//        long totalItems = players.values().stream()
//                .map(Player::getInventory)
//                .mapToInt(Inventory::size)
//                .sum();
//
//        System.out.println("=== Статистика сервера ===");
//        System.out.println("Всего игроков: " + players.size());
//        System.out.println("Общее золото: " + totalGold);
//        System.out.println("Общее количество предметов: " + totalItems);
//    }
//
//    private void run() {
//        startBattleQueueProcessor();
//
//        while (running) {
//            showMenu();
//            int choice;
//            try {
//                choice = readInt();
//            } catch (Exception e) {
//                System.out.println("Некорректный ввод.");
//                continue;
//            }
//
//            switch (choice) {
//                case 1 -> registerPlayer();
//                case 2 -> createCharacterWithFactory();
//                case 3 -> createCharacterWithBuilder();
//                case 4 -> addItemToInventory();
//                case 5 -> removeItemsByCondition();
//                case 6 -> enqueueForBattle();
//                case 7 -> manualBattle();
//                case 8 -> completeQuest();
//                case 9 -> showLeaderboard();
//                case 10 -> showAllPlayersWithLambda();
//                case 11 -> showStats();
//                case 12 -> saveData();
//                case 0 -> {
//                    running = false;
//                    saveData();
//                    System.out.println("Сервер остановлен.");
//                }
//                default -> System.out.println("Неверная команда.");
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        GameServer server = new GameServer();
//        server.run();
//    }
//}
