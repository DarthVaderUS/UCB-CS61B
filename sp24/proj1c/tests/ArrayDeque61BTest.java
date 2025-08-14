import org.junit.jupiter.api.*;
import deque.ArrayDeque61B;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayDeque61BTest {

    @Test
    public void testAddFirstAndAddLast() {
        ArrayDeque61B<Integer> deque = new ArrayDeque61B<>();
        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(0);
        assertEquals(3, deque.size());
        assertEquals(List.of(0, 1, 2), deque.toList());
    }

    @Test
    public void testRemoveFirstAndRemoveLast() {
        ArrayDeque61B<String> deque = new ArrayDeque61B<>();
        deque.addLast("a");
        deque.addLast("b");
        deque.addLast("c");
        assertEquals("a", deque.removeFirst());
        assertEquals("c", deque.removeLast());
        assertEquals("b", deque.removeFirst());
        assertNull(deque.removeFirst());
        assertTrue(deque.isEmpty());
    }

    @Test
    public void testIsEmptyAndSize() {
        ArrayDeque61B<Double> deque = new ArrayDeque61B<>();
        assertTrue(deque.isEmpty());
        deque.addFirst(1.1);
        assertFalse(deque.isEmpty());
        assertEquals(1, deque.size());
        deque.removeLast();
        assertTrue(deque.isEmpty());
    }

    @Test
    public void testGetAndGetRecursive() {
        ArrayDeque61B<String> deque = new ArrayDeque61B<>();
        deque.addLast("x");
        deque.addLast("y");
        deque.addLast("z");
        assertEquals("x", deque.get(0));
        assertEquals("y", deque.get(1));
        assertEquals("z", deque.get(2));
        assertEquals("y", deque.getRecursive(1));
        assertThrows(IndexOutOfBoundsException.class, () -> deque.get(3));
        assertThrows(IndexOutOfBoundsException.class, () -> deque.getRecursive(-1));
    }

    @Test
    public void testIterator() {
        ArrayDeque61B<Integer> deque = new ArrayDeque61B<>();
        for (int i = 0; i < 5; i++) {
            deque.addLast(i);
        }
        int idx = 0;
        for (int val : deque) {
            assertEquals(idx++, val);
        }
    }

    @Test
    public void testEquals() {
        ArrayDeque61B<String> d1 = new ArrayDeque61B<>();
        ArrayDeque61B<String> d2 = new ArrayDeque61B<>();
        d1.addLast("a");
        d1.addLast("b");
        d2.addLast("a");
        d2.addLast("b");
        assertEquals(d1, d2);
        d2.removeLast();
        assertNotEquals(d1, d2);
    }

    @Test
    public void testToString() {
        ArrayDeque61B<String> deque = new ArrayDeque61B<>();
        deque.addLast("front");
        deque.addLast("middle");
        deque.addLast("back");
        assertEquals("[front, middle, back]", deque.toString());
    }

    @Test
    public void testResizeGrowAndShrink() {
        ArrayDeque61B<Integer> deque = new ArrayDeque61B<>();
        int initialCapacity = 16;
        int growSize = initialCapacity * 3;
        // Test grow
        for (int i = 0; i < growSize; i++) {
            deque.addLast(i);
        }
        assertEquals(growSize, deque.size());
        for (int i = 0; i < growSize; i++) {
            assertEquals(i, deque.get(i));
        }
        // Test shrink
        for (int i = 0; i < growSize - initialCapacity + 1; i++) {
            deque.removeFirst();
        }
        assertTrue(deque.size() <= initialCapacity);
    }

    @Test
    public void testWrapAround() {
        ArrayDeque61B<Integer> deque = new ArrayDeque61B<>();
        for (int i = 0; i < 20; i++) {
            deque.addLast(i);
        }
        for (int i = 0; i < 10; i++) {
            deque.removeFirst();
        }
        for (int i = 20; i < 30; i++) {
            deque.addLast(i);
        }
        for (int i = 0; i < 10; i++) {
            assertEquals(i + 10, deque.get(i));
        }
        for (int i = 10; i < 20; i++) {
            assertEquals(i + 10, deque.get(i));
        }
    }
}