//package game.server;
//
//import game.model.*;
//import game.model.Character;
//import game.patterns.GameLogger;
//import game.exceptions.GameException;
//import java.util.*;
//import java.util.concurrent.*;
//import java.nio.file.*;
//import java.io.*;
//
//public class GameSession {
//    private final Map<Integer, Player> players = new HashMap<>();
//    private final TreeSet<Player> leaderboard = new TreeSet<>(); // рейтинг
//    private final Queue<Player> battleQueue = new LinkedList<>();
//    private int nextId = 1;
//
//    public Player registerPlayer(String name) throws GameException {
//        Player p = new Player(nextId++, name);
//        players.put(p.getId(), p);
//        leaderboard.add(p);
//        GameLogger.getInstance().log("Игрок зарегистрирован: " + p.getName());
//        return p;
//    }
//
//    public Player getPlayerById(int id) throws GameException {
//        Player p = players.get(id);
//        if (p == null) throw new GameException("Игрок не найден");
//        return p;
//    }
//
//    public void startBattle(Player p1, Player p2) throws GameException {
//        Character c1 = p1.getCharacter();
//        Character c2 = p2.getCharacter();
//        if (c1 == null || c2 == null) throw new GameException("У игроков нет персонажей");
//
//        int d1 = c1.attack(c2);
//        int d2 = c2.attack(c1);
//
//        GameLogger.getInstance().log(c1.getName() + " нанёс " + d1 + " урона " + c2.getName());
//        GameLogger.getInstance().log(c2.getName() + " нанёс " + d2 + " урона " + c1.getName());
//
//        // начисление золота и опыта
//        p1.addGold(10);
//        p2.addGold(10);
//        c1.gainExp(5);
//        c2.gainExp(5);
//
//        leaderboard.remove(p1); leaderboard.remove(p2);
//        leaderboard.add(p1); leaderboard.add(p2); // пересортировка
//    }
//
//    public void saveToFile(Path path) throws IOException {
//        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
//            for (Player p : players.values()) {
//                bw.write(p.getId() + "," + p.getName() + "," + p.getGold());
//                bw.newLine();
//            }
//        }
//    }
//
//    public void loadFromFile(Path path) throws IOException {
//        if (!Files.exists(path)) return;
//        List<String> lines = Files.readAllLines(path);
//        for (String line : lines) {
//            String[] parts = line.split(",");
//            if (parts.length < 3) continue;
//            int id = Integer.parseInt(parts[0]);
//            String name = parts[1];
//            long gold = Long.parseLong(parts[2]);
//            Player p = new Player(id, name);
//            p.addGold(gold);
//            players.put(id, p);
//            leaderboard.add(p);
//            if (nextId <= id) nextId = id + 1;
//        }
//    }
//
//    public Map<Integer, Player> getPlayers() { return players; }
//    public TreeSet<Player> getLeaderboard() { return leaderboard; }
//    public Queue<Player> getBattleQueue() { return battleQueue; }
//}

