package com.note.pack7.Sort;

/**
 * QuickSortL3S implementation in Java.
 * This class provides a method to sort an array using the QuickSort algorithm with a specific partitioning strategy.
 * Pivot selection strategy : leftmost
 * Partition algorithm : 3 scans
 * Time Complexity: O(n log n) on average, O(n^2) in the worst case.
 * Space Complexity: O(log n) due to recursive stack space.
 */
public class QuickSortL3S {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int left = low + 1;
        int right = high;

        while (left <= right) {
            while (left <= right && arr[left] <= pivot) {
                left++;
            }
            while (left <= right && arr[right] >= pivot) {
                right--;
            }
            if (left < right) {
                swap(arr, left, right);
            }
        }
        swap(arr, low, right);
        return right;
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
