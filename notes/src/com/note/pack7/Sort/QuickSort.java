package com.note.pack7.Sort;

/**
 * QuickSort implementation in Java.
 * This class provides a method to sort an array using the QuickSort algorithm.
 * The QuickSort algorithm is a divide-and-conquer algorithm that sorts an array by selecting a 'pivot' element and partitioning the other elements into two sub-arrays according to whether they are less than or greater than the pivot.
 * The sub-arrays are then sorted recursively.
 * Time Complexity: O(n log n) on average, O(n^2) in the worst case.
 * Space Complexity: O(log n) due to recursive stack space.
 * Attention : QuickSort is the fastest sorting algorithm.
 */
public class QuickSort {
    /**
     * Sorts an array using the QuickSort algorithm.
     *
     * @param arr the array to be sorted
     * @param low the starting index of the array
     * @param high the ending index of the array
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
//                System.out.print("Now array: ");
//                for(int num : arr) {
//                    System.out.print(num + " ");
//                }
//                System.out.print("\n");
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
