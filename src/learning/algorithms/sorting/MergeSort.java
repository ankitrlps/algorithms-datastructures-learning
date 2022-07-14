package learning.algorithms.sorting;

import java.util.Arrays;

public class MergeSort {

    private void merge(int[] arr, int l, int m, int r) {

        int size1 = (m - l) + 1; // lowest to middle (INCLUDING middle)
        int size2 = r - m; // Coz we want to start counting from m + 1

        int[] left = new int[size1];
        int[] right = new int[size2];

        for (int i = 0; i < size1; i++) {
            left[i] = arr[l + i];
        }
        for (int j = 0; j < size2; j++) {
            right[j] = arr[m + 1 + j];
        }
        
        int k = l, i = 0, j = 0;
        
        while (i < size1 && j < size2) {
            if (left[i] < right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        
        while (i < size1) {
            arr[k] = left[i];
            i++;
            k++;
        }
        
        while (j < size2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    private void sort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (r + l) / 2;

            sort(arr, l, m);
            sort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    private void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] arr = {8, 3, 9, 2, 10};
        mergeSort.sort(arr);
        Arrays.stream(arr).forEach(o -> System.out.print(o + " "));
    }
}
