package deque;
import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> comparator;

    public MaxArrayDeque() {
        this.comparator = null;
    }

    // Constructor that takes a Comparator
    public MaxArrayDeque(Comparator<T> c) {
        this.comparator = c;
    }

    // Returns the maximum element using the comparator provided in the constructor
    public T max() {
        if(isEmpty()) {
            return null;
        }
        T maxItem = get(0);
        for(int i = 1; i < size(); i++) {
            T currentItem = get(i);
            if(comparator.compare(maxItem, currentItem) < 0) {
                maxItem = currentItem;
            }
        }
        return maxItem;
    }

    // Returns the maximum element using the provided comparator
    public T max(Comparator<T> c) {
        if(isEmpty()) {
            return null;
        }
        T maxItem = get(0);
        for(int i = 1; i < size(); i++) {
            T currentItem = get(i);
            if(c.compare(maxItem, currentItem) < 0) {
                maxItem = currentItem;
            }
        }
        return maxItem;
    }

}
