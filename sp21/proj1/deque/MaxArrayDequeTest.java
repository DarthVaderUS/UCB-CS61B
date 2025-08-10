package deque;

import java.util.Comparator;

public class MaxArrayDequeTest {
    // Comparator for comparing integers
    static class IntegerComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            return Integer.compare(a, b);
        }
    }

    // Comparator for comparing absolute values of integers
    static class AbsIntegerComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            return Integer.compare(Math.abs(a), Math.abs(b));
        }
    }

    // Comparator for comparing strings by length
    static class StringLengthComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            return Integer.compare(a.length(), b.length());
        }
    }

    public static void main(String[] args) {
        int testsPassed = 0;
        int totalTests = 0;

        // Test 1: Empty deque
        totalTests++;
        MaxArrayDeque<Integer> emptyDeque = new MaxArrayDeque<>(new IntegerComparator());
        if (emptyDeque.max() == null) {
            System.out.println("Test 1 Passed: Empty deque returns null for max()");
            testsPassed++;
        } else {
            System.out.println("Test 1 Failed: Empty deque should return null for max()");
        }

        totalTests++;
        if (emptyDeque.max(new AbsIntegerComparator()) == null) {
            System.out.println("Test 2 Passed: Empty deque returns null for max(Comparator)");
            testsPassed++;
        } else {
            System.out.println("Test 2 Failed: Empty deque should return null for max(Comparator)");
        }

        // Test 2: Single element
        totalTests++;
        MaxArrayDeque<Integer> singleDeque = new MaxArrayDeque<>(new IntegerComparator());
        singleDeque.addLast(42);
        if (singleDeque.max() != null && singleDeque.max() == 42) {
            System.out.println("Test 3 Passed: Single element deque returns correct max");
            testsPassed++;
        } else {
            System.out.println("Test 3 Failed: Single element deque should return 42");
        }

        // Test 3: Multiple elements with IntegerComparator
        totalTests++;
        MaxArrayDeque<Integer> intDeque = new MaxArrayDeque<>(new IntegerComparator());
        intDeque.addLast(3);
        intDeque.addLast(1);
        intDeque.addLast(4);
        intDeque.addLast(1);
        if (intDeque.max() != null && intDeque.max() == 4) {
            System.out.println("Test 4 Passed: Multiple elements return correct max (4)");
            testsPassed++;
        } else {
            System.out.println("Test 4 Failed: Expected max to be 4");
        }

        // Test 4: Multiple elements with AbsIntegerComparator
        totalTests++;
        intDeque.addLast(-5); // Add -5 to test absolute value comparator
        if (intDeque.max(new AbsIntegerComparator()) != null &&
                (intDeque.max(new AbsIntegerComparator()) == -5 || intDeque.max(new AbsIntegerComparator()) == 4)) {
            System.out.println("Test 5 Passed: AbsIntegerComparator returns correct max (4 or -5)");
            testsPassed++;
        } else {
            System.out.println("Test 5 Failed: Expected max to be 4 or -5 with AbsIntegerComparator");
        }

        // Test 5: String deque with StringLengthComparator
        totalTests++;
        MaxArrayDeque<String> stringDeque = new MaxArrayDeque<>(new StringLengthComparator());
        stringDeque.addLast("cat");
        stringDeque.addLast("dog");
        stringDeque.addLast("elephant");
        stringDeque.addLast("a");
        if (stringDeque.max() != null && stringDeque.max().equals("elephant")) {
            System.out.println("Test 6 Passed: String deque returns correct max ('elephant')");
            testsPassed++;
        } else {
            System.out.println("Test 6 Failed: Expected max to be 'elephant'");
        }

        // Test 6: Multiple maximum elements
        totalTests++;
        MaxArrayDeque<Integer> multiMaxDeque = new MaxArrayDeque<>(new IntegerComparator());
        multiMaxDeque.addLast(5);
        multiMaxDeque.addLast(5);
        multiMaxDeque.addLast(3);
        if (multiMaxDeque.max() != null && multiMaxDeque.max() == 5) {
            System.out.println("Test 7 Passed: Multiple maximum elements return correct max (5)");
            testsPassed++;
        } else {
            System.out.println("Test 7 Failed: Expected max to be 5");
        }

        // Summary
        System.out.println("\nTest Summary: " + testsPassed + "/" + totalTests + " tests passed");
        if (testsPassed == totalTests) {
            System.out.println("All tests passed!");
        } else {
            System.out.println("Some tests failed.");
        }
    }
}