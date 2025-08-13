package com.note.pack7.Sort;

public class RadixSorting {
    /**
     * Sorts an array using the Radix Sort algorithm.
     * Radix Sort is a non-comparative integer sorting algorithm that sorts numbers by processing individual digits.
     * It works by sorting the numbers based on each digit, starting from the least significant digit to the most significant digit.
     * This implementation uses Counting Sort as a subroutine to sort the digits.
     * Time Complexity: O(d * (n + k)), where d is the number of digits in the largest number, n is the number of elements in the array, and k is the range of the input values (0-9 for decimal digits).
     * Space Complexity: O(n + k), where n is the number of elements in the array and k is the range of the input values.
     *
     * @param arr the array to be sorted
     */
    public static void radixSort(int[] arr) {
        int max = getMax(arr);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(arr, exp);
        }
    }

    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    private static void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }
}
