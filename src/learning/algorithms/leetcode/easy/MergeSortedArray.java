package learning.algorithms.leetcode.easy;

import java.util.Arrays;

/**
 * 88. Merge Sorted Array
 * URL - https://leetcode.com/problems/merge-sorted-array/
 */
public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
            int i = m - 1, j = n - 1, k = m + n - 1;
            while (i > -1 && j > -1) {
                if(nums1[i] < nums2[j]) {
                    nums1[k] = nums2[j];
                    j--;
                } else {
                    nums1[k] = nums1[i];
                    i--;
                }
                k--;
            }
            while (i > -1) {
                nums1[k] = nums1[i];
                i--;
                k--;
            }
            while (j > -1) {
                nums1[k] = nums2[j];
                j--;
                k--;
            }
        }
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
        Arrays.stream(nums1).forEach(k -> System.out.print(k + " "));
    }
}
