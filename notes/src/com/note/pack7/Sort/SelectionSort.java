package com.note.pack7.Sort;

/**
 * Selection Sort implementation in Java.
 * This algorithm sorts an array by repeatedly finding the minimum element
 * from the unsorted part and moving it to the beginning,
 * with the time complexity of O(n^2) and space complexity of O(1).
 */
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
