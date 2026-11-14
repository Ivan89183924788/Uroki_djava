//package autoservice.pattern;
//
//import java.util.*;
//import java.util.function.Predicate;
//import java.util.stream.Collectors;
//
//public class RepositoryRemont<T> {
//    private final List<T> predmety=new ArrayList<>();
//    private final Map<String,T> byId=new HashMap<>();
//
//
//
//    public void addWithKey(String key,T predmet){
//        predmety.add(predmet);
//        byId.put(key, predmet);
//    }
//    public Optional<T> findById(String key){
//        return Optional.ofNullable(byId.get(key));
//    }
//
//    public boolean remove(T predmet){
//        return predmety.remove(predmet);
//    }
//
//    public boolean removeIfMatch(Predicate<T> predicate){
//        return predmety.removeIf(predicate);
//    }
//
//    public List<T> getAll(){
//        return new ArrayList<>(predmety);
//    }
//
//    public List<T> findAll(Predicate<T> predicate){
//        return predmety.stream()
//                .filter(predicate)
//                .collect(Collectors.toList());
//    }
//
//    public Optional<T> findFirst(Predicate<T> predicate){
//        return predmety.stream().filter(predicate).findFirst();
//    }
//
//    public void printAll(){
//        if(predmety.isEmpty()){
//            System.out.println("[Пусто]");
//            return;
//        }
//        int i=1;
//        for (T pred:predmety){
//            System.out.println(i+". "+pred);
//            i++;
//        }
//    }
//}
