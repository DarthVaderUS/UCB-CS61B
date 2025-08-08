package com.note.pack7.Sort;

/**
 * Merge Sort implementation in Java.
 * This class provides a method to sort an array using the merge sort algorithm.
 * Merge sort is a divide-and-conquer algorithm that divides the array into halves,
 * sorts each half, and then merges the sorted halves back together.
 * * Time Complexity: O(n log n)
 * * Space Complexity: O(n)
 * Attention : Merge sort is faster than selection sort and heap sort.
 */
public class MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return; // No need to sort
        }
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, temp, left, mid);
            mergeSort(arr, temp, mid + 1, right);
            merge(arr, temp, left, mid, right);
        }
    }

    /**
     * Merges two sorted halves of the array.
     *
     * @param arr   The original array to be sorted.
     * @param temp  Temporary array to hold the merged result.
     * @param left  The starting index of the left half.
     * @param mid   The ending index of the left half (midpoint).
     * @param right The ending index of the right half.
     */
    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        // Merge the two halves into the original array
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }

        // Copy any remaining elements from the left and right half
        while (i <= mid) {
            arr[k++] = temp[i++];
        }
        while (j <= right) {
            arr[k++] = temp[j++];
        }
    }
}
