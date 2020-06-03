package learning.algorithms.leetcode.easy;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicatesSortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3, 4, 7};
        int size = removeDuplicates(nums);
        List<Integer> result = new ArrayList<>();
        int[] res = Arrays.stream(nums).limit(size).toArray();
        for (int value : res){
            result.add(value);
        }
        System.out.print(result);
    }
    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > nums[result]){
                nums[result + 1] = nums[i];
                result++;
            }
        }
        return result + 1;
    }
}
