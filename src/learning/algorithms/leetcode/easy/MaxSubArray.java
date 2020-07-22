package learning.algorithms.leetcode.easy;

/**
 * 53. Maximum Subarray
 * URL - https://leetcode.com/problems/maximum-subarray/
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.print(maxArray(nums));
    }

    private static int maxArray(int[] nums){
        int res = nums[0], temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            temp += nums[i];
            if(res < nums[i]) {
                res = nums[i];
            }
            if (temp < nums[i]) temp = nums[i];

            if(temp > res){
                res = temp;
            }
        }
        return res;
    }
}
