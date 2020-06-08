package learning.algorithms.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int size = removeElement(nums, 2);
        List<Integer> integers = new ArrayList<>();
        for (int num : Arrays.stream(nums).limit(size).toArray()) {
            integers.add(num);
        }
        System.out.println(integers);
    }
    public static int removeElement(int[] nums, int val) {
        int size = -1;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != val) {
                size++;
                nums[size] = nums[i];
            }
        }
        return size + 1;
    }
}
