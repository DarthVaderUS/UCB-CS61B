package com.note.pack7.Sort;

/**
 * Insertion Sort implementation in Java.
 * This algorithm sorts an array by repeatedly taking an element from the unsorted part
 * and inserting it into the correct position in the sorted part,
 * with the time complexity of O(n^2) and space complexity of O(1).
 * Attention : Insertion sort is fast for small data sets and almost sorted arrays.
 * It is also a stable sort, meaning that it maintains the relative order of equal elements.
 */
public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Move elements of arr[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
