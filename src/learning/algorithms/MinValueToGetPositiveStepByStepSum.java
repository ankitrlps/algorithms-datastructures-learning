package learning.algorithms;

/**
 * https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/
 */

public class MinValueToGetPositiveStepByStepSum {

    // pick 1 as initial start value
    // find the min sum by iterating
    // calculate how much can you add to the min sum to reach 1
    // add + 1 to the value calculated to reach 1 - reason is that where your loweest positive starting value will be
    public static int minStartValue(int[] nums) {
        int min = Integer.MAX_VALUE;
        int start = 1;
        for (int i = 0; i < nums.length; i++) {            
            start += nums[i];
            min = Math.min(min, start);
        }
        int s = 1 - min + 1;
        if (s <= 0)
            return 1;
        else
            return s;
    }
    
    public static void main(String[] args) {
        System.out.println("Min positive starting value: " + minStartValue(new int[]{-3,2,-3,4,2}));
        // new int[]{1,2}
        // new int[]{1,-2,-3}
    }
}
