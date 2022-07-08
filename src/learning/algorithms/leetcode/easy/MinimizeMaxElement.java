package learning.algorithms.leetcode.easy;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
* Returns the final max element in an array after spliting the current array's max element into k times.
*/

public class MinimizeMaxElement {

    private static Comparator<Integer> reverseComparator() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 == o2) return 0;
                return o1 < o2 ? 1 : -1;
            }
        };
        return comparator;
    }

    public static int maxElement(int[] arr, int k) {
        if (arr.length == 1) {
            return arr[0];
        }
        int max = 0;
        int helper = 1;
        PriorityQueue<Integer> integers = new PriorityQueue<>(reverseComparator());

        for (int element : arr) {
            integers.add(element);
        }
        max = integers.peek();
        while (helper <= k) {
            int i = integers.poll();
            int j = integers.peek();

            if (i - j != 0) {
                max = i - j;
                integers.add(i - j);
            } else {
                int l = i/2;
                int diff = i - l;
                integers.add(l);
                integers.add(diff);                
            }
            helper++;
        }
        return Math.max(max, integers.peek() != null ? integers.peek() : 0);
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> integers = new PriorityQueue<>(reverseComparator());
        integers.add(4);
        integers.add(2);
        integers.add(8);
        System.out.println(integers.poll());
        System.out.println(integers.poll());
        System.out.println(integers.poll());
        System.out.println(integers.poll());

        System.out.println("result 1-0: " + maxElement(new int[] {2, 4, 8, 2}, 4));
        System.out.println("result 1-1: " + maxElement(new int[] {2, 4, 8, 2}, 5));
        System.out.println("result 2-0: " + maxElement(new int[] {17,7}, 2));
        System.out.println("result 2-1: " + maxElement(new int[] {17,7}, 3));
        System.out.println("result 2-2: " + maxElement(new int[] {17,7}, 4));
    }
    }