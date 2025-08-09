package com.note.pack7.Sort;

public class Test {
    public static void main(String[] args) {
        int[] arr = {34, 7, 23, 32, 5, 62, 10, 90, 45, 8};
        System.out.println("Original array:");
        printArray(arr);

        QuickSort.quickSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:");
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
