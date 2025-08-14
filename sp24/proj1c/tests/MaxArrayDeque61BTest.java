import org.junit.jupiter.api.*;

import java.util.Comparator;
import java.util.NoSuchElementException;

import deque.MaxArrayDeque61B;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MaxArrayDeque61BTest {
    private static class StringLengthComparator implements Comparator<String> {
        public int compare(String a, String b) {
            return a.length() - b.length();
        }
    }

    @Test
    public void basicTest() {
        MaxArrayDeque61B<String> mad = new MaxArrayDeque61B<>(new StringLengthComparator());
        mad.addFirst("");
        mad.addFirst("2");
        mad.addFirst("fury road");
        assertThat(mad.max()).isEqualTo("fury road");
    }
    private static class ReverseIntComparator implements Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            return b.compareTo(a);
        }
    }

    @Test
    public void testMaxOnEmptyDequeThrows() {
        MaxArrayDeque61B<Integer> mad = new MaxArrayDeque61B<>(Integer::compareTo);
        assertThrows(NoSuchElementException.class, mad::max);
    }

    @Test
    public void testMaxWithComparatorOnEmptyDequeReturnsNull() {
        MaxArrayDeque61B<Integer> mad = new MaxArrayDeque61B<>(Integer::compareTo);
        assertNull(mad.max(Integer::compareTo));
    }

    @Test
    public void testMaxSingleElement() {
        MaxArrayDeque61B<Integer> mad = new MaxArrayDeque61B<>(Integer::compareTo);
        mad.addLast(42);
        assertThat(mad.max()).isEqualTo(42);
        assertThat(mad.max(Integer::compareTo)).isEqualTo(42);
    }

    @Test
    public void testMaxMultipleElementsNaturalOrder() {
        MaxArrayDeque61B<Integer> mad = new MaxArrayDeque61B<>(Integer::compareTo);
        mad.addLast(1);
        mad.addLast(99);
        mad.addLast(50);
        assertThat(mad.max()).isEqualTo(99);
    }

    @Test
    public void testMaxMultipleElementsCustomComparator() {
        MaxArrayDeque61B<Integer> mad = new MaxArrayDeque61B<>(Integer::compareTo);
        mad.addLast(1);
        mad.addLast(99);
        mad.addLast(50);
        assertThat(mad.max(new ReverseIntComparator())).isEqualTo(1);
    }

    @Test
    public void testMaxWithStringsAndLengthComparator() {
        MaxArrayDeque61B<String> mad = new MaxArrayDeque61B<>(new StringLengthComparator());
        mad.addLast("a");
        mad.addLast("abc");
        mad.addLast("ab");
        assertThat(mad.max()).isEqualTo("abc");
        assertThat(mad.max(new StringLengthComparator())).isEqualTo("abc");
    }

    @Test
    public void testMaxWithDuplicateMaxValues() {
        MaxArrayDeque61B<Integer> mad = new MaxArrayDeque61B<>(Integer::compareTo);
        mad.addLast(5);
        mad.addLast(5);
        mad.addLast(3);
        assertThat(mad.max()).isEqualTo(5);
    }

    @Test
    public void testMaxAfterRemovals() {
        MaxArrayDeque61B<Integer> mad = new MaxArrayDeque61B<>(Integer::compareTo);
        mad.addLast(1);
        mad.addLast(2);
        mad.addLast(3);
        mad.removeLast();
        assertThat(mad.max()).isEqualTo(2);
    }

    @Test
    public void testMaxWithNullComparator() {
        MaxArrayDeque61B<Integer> mad = new MaxArrayDeque61B<>(Integer::compareTo);
        mad.addLast(1);
        assertThrows(NullPointerException.class, () -> mad.max(null));
    }
}
