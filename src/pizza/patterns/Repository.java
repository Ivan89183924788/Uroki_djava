package pizza.patterns;

import java.util.*;

public class Repository<T> {
    private final List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public boolean remove(T item) {
        return items.remove(item);
    }

    public T get(int index) {
        if (index < 0 || index >= items.size()) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return items.get(index);
    }

    public List<T> getAll() {
        return new ArrayList<>(items);
    }

    public void printAll() {
        items.forEach(System.out::println);
    }
}
