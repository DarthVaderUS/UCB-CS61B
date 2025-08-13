package com.note.pack7.Sort;

public class CountingSort {
    /**
     * Sorts an array using the Counting Sort algorithm.
     * This algorithm is not using comparison to sort the array.
     * Counting Sort is suitable for sorting integers within a known range.
     * It counts the occurrences of each unique value in the array and uses this information to place
     * the elements in their correct positions in the sorted array.
     * Time Complexity: O(n + k), where n is the number of elements in the
     * array and k is the range of the input values.
     * Space Complexity: O(k), where k is the range of the input values.
     * @param arr the array to be sorted
     * @param max the maximum value in the array
     */
    public static void countingSort(int[] arr, int max) {
        int[] count = new int[max + 1];
        for (int num : arr) {
            count[num]++;
        }

        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
    }
}
