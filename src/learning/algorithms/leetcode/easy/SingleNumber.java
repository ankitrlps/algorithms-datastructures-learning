package learning.algorithms.leetcode.easy;

import java.util.Arrays;

/**
 * 136. Single Number
 * URL - https://leetcode.com/problems/single-number/
 */

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 3, 1, 5}; // {4, 4, 3, 2, 1, 3}
        System.out.println(singleNumber(nums));
    }
    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i+=2) {
            if (nums[i] != nums[i-1]) {
                return nums[i-1];
            }
        }
        return nums[nums.length-1];
    }
}
