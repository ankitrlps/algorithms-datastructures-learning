package learning.algorithms.searching;

import java.util.Arrays;

/**
 * Binary Search Algorithm
 * Before binary searching, the stack needs to be sorted. Hence we sort by merge sort and perform BS.
 */
public class BinarySearch {

    private static void mergeSort(int[] arr, int sI, int mid, int eI) {
        int size1 = (mid - sI) + 1;
        int size2 = eI - mid;

        int[] arr1 = new int[size1];
        int[] arr2 = new int[size2];

        for (int i = 0; i < size1; i++) {
            arr1[i] = arr[sI + i];
        }

        for (int i = 0; i < size2; i++) {
            arr2[i] = arr[mid + 1 + i];
        }

        int k = sI;
        int i = 0;
        int j = 0;

        while (i < size1 && j < size2) {
            if (arr1[i] < arr2[j]) {
                arr[k] = arr1[i];
                i++;
            } else {
                arr[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < size1) {
            arr[k] = arr1[i];
            i++;
            k++;
        }

        while (j < size2) {
            arr[k] = arr2[j];
            j++;
            k++;
        }
    }

    private static void sort(int[] arr, int sI, int eI) {
        if (sI < eI) {
            int mid = (sI + eI) / 2;

            sort(arr, sI, mid);
            sort(arr, mid + 1, eI);

            mergeSort(arr, sI, mid, eI);
        }
    }

    private static int search(int[] arr, int sI, int eI, int search) {
        int index = -1;
        if (sI <= eI) {
            int mid = (sI + eI) / 2;

            if (arr[mid] == search) {
                index = mid;
                return index;
            }
            if (arr[mid] < search) {
                return search(arr, mid + 1, eI, search);
            } else {
                return search(arr, sI, mid - 1, search);
            }
        }
        return index;
    }

    private static int binarySearch(int[] arr, int search) {
        sort(arr, 0, arr.length - 1);
        return search(arr, 0, arr.length - 1, search);
    }

    public static void main(String[] args) {
        int[] arr = {3, 56, 90, 1, 7, 5, 2};
        int index = binarySearch(arr, 3);
        Arrays.stream(arr).forEach(o -> System.out.print(o + " "));
        System.out.println();
        System.out.println(index != -1 ? "At index: " + index : "Not Found");
    }
}
