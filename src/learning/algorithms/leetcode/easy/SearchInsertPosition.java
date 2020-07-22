package learning.algorithms.leetcode.easy;

/**
 * 35. Search Insert Position
 * https://leetcode.com/problems/search-insert-position/
 */

public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        long start = System.currentTimeMillis();
        System.out.println("index: " + indexOfPresentOrPossibleElement(nums, 2));
        System.out.print("Time taken: " + (System.currentTimeMillis() - start) + " ms");
    }

    private static int indexOfPresentOrPossibleElement(int[] nums, int target){
        int i = 0;
        while (i < nums.length){
            if(nums[i] >= target){
                return i;
            }
            i++;
        }
        return i;
    }
}
