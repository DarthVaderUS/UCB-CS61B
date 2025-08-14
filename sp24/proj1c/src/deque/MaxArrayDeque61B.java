package deque;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class MaxArrayDeque61B<T extends Comparable<T>> extends ArrayDeque61B<T> {
    public MaxArrayDeque61B(Comparator<T> c) {
        super();
    }
    public T max() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        T maxItem = get(0);
        for (int i = 1; i < size(); i++) {
            T currentItem = get(i);
            if (((Comparable<T>) currentItem).compareTo(maxItem) > 0) {
                maxItem = currentItem;
            }
        }
        return maxItem;
    }
    public T max(Comparator<T> c) {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        T maxItem = get(0);
        for (int i = 1; i < size(); i++) {
            T currentItem = get(i);
            if (c.compare(currentItem, maxItem) > 0) {
                maxItem = currentItem;
            }
        }
        return maxItem;
    }
}
