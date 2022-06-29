package learning.algorithms.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        while (i < nums.length) {
            if (map.containsKey(target - nums[i])) {
                break;
            } else {
                map.put(nums[i], i);
            }
            i++;
        }
        return new int[]{map.get(target - nums[i]), i};
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 1, 10, 6, 7};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }
}
