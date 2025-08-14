import jh61b.utils.Reflection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArrayDeque61BTest {

     @Test
     @DisplayName("ArrayDeque61B has no fields besides backing array and primitives")
     void noNonTrivialFields() {
         List<Field> badFields = Reflection.getFields(ArrayDeque61B.class)
                 .filter(f -> !(f.getType().isPrimitive() || f.getType().equals(Object[].class) || f.isSynthetic()))
                 .toList();

         assertWithMessage("Found fields that are not array or primitives").that(badFields).isEmpty();
     }
    @Test
    void testIsEmptyAndSize() {
        ArrayDeque61B<Integer> deque = new ArrayDeque61B<>();
        assertTrue(deque.isEmpty());
        assertEquals(0, deque.size());

        deque.addFirst(1);
        assertFalse(deque.isEmpty());
        assertEquals(1, deque.size());

        deque.removeLast();
        assertTrue(deque.isEmpty());
        assertEquals(0, deque.size());
    }

    @Test
    void testAddFirstAndRemoveFirst() {
        ArrayDeque61B<Integer> deque = new ArrayDeque61B<>();
        deque.addFirst(10);
        deque.addFirst(20);
        deque.addFirst(30);

        assertEquals(30, deque.removeFirst());
        assertEquals(20, deque.removeFirst());
        assertEquals(10, deque.removeFirst());
        assertTrue(deque.isEmpty());
    }

    @Test
    void testAddLastAndRemoveLast() {
        ArrayDeque61B<Integer> deque = new ArrayDeque61B<>();
        deque.addLast(10);
        deque.addLast(20);
        deque.addLast(30);

        assertEquals(30, deque.removeLast());
        assertEquals(20, deque.removeLast());
        assertEquals(10, deque.removeLast());
        assertTrue(deque.isEmpty());
    }

    @Test
    void testMixedAddRemove() {
        ArrayDeque61B<Integer> deque = new ArrayDeque61B<>();
        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(3);
        deque.addLast(4);

        assertEquals(3, deque.removeFirst());
        assertEquals(4, deque.removeLast());
        assertEquals(1, deque.removeFirst());
        assertEquals(2, deque.removeLast());
        assertTrue(deque.isEmpty());
    }

    @Test
    void testGet() {
        ArrayDeque61B<String> deque = new ArrayDeque61B<>();
        deque.addLast("a");
        deque.addLast("b");
        deque.addLast("c");
        deque.addLast("d");

        assertEquals("a", deque.get(0));
        assertEquals("b", deque.get(1));
        assertEquals("c", deque.get(2));
        assertEquals("d", deque.get(3));
        //assertNull(deque.get(-1));
        //assertNull(deque.get(4));
    }

    @Test
    void testLargeScaleAddRemove() {
        ArrayDeque61B<Integer> deque = new ArrayDeque61B<>();
        int N = 10000;
        for (int i = 0; i < N; i++) {
            deque.addLast(i);
        }
        assertEquals(N, deque.size());
        for (int i = 0; i < N; i++) {
            assertEquals(i, deque.get(i));
        }
        for (int i = 0; i < N; i++) {
            assertEquals(i, deque.removeFirst());
        }
        assertTrue(deque.isEmpty());
    }

    @Test
    void testResizeShrink() {
        ArrayDeque61B<Integer> deque = new ArrayDeque61B<>();
        for (int i = 0; i < 128; i++) {
            deque.addLast(i);
        }
        for (int i = 0; i < 120; i++) {
            deque.removeFirst();
        }
        assertEquals(8, deque.size());
        for (int i = 0; i < 8; i++) {
            assertEquals(120 + i, deque.get(i));
        }
    }

    @Test
    void testRemoveFromEmpty() {
        ArrayDeque61B<Integer> deque = new ArrayDeque61B<>();
        assertNull(deque.removeFirst());
        assertNull(deque.removeLast());
    }

    @Test
    void testAddRemoveAlternating() {
        ArrayDeque61B<Integer> deque = new ArrayDeque61B<>();
        for (int i = 0; i < 1000; i++) {
            if (i % 2 == 0) {
                deque.addFirst(i);
            } else {
                deque.addLast(i);
            }
        }
        for (int i = 0; i < 500; i++) {
            deque.removeFirst();
            deque.removeLast();
        }
        assertEquals(0, deque.size());
        assertTrue(deque.isEmpty());
    }


}
