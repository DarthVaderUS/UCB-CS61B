package com.note.pack2;

public class Maximizer {
    public static OurComparable max(OurComparable[] arr) {
        if (arr == null || arr.length == 0) {
            return null; // Handle empty or null array
        }

        OurComparable maxElement = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(maxElement) > 0) {
                maxElement = arr[i]; // Update maxElement if current is greater
            }
        }
        return maxElement; // Return the maximum element found
    }
}
