package learning.algorithms;

public class MaximumSubArraySum {
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int res = nums[0];
        int tempSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            tempSum += num;
            if (num > tempSum) {
                tempSum = num;
            }
            res = Math.max(res, tempSum);
            // tempSum = Math.max(num, tempSum + num);
            // res = Math.max(res, tempSum);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("max sum: " + maxSubArray(nums));
    }
}
