package learning.algorithms.trees;
/**
 * construct BT with sorted array - https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class ConstructBT {
    
    private static Node constructBT(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        Node node = new Node(nums[mid]);
        node.left = constructBT(nums, left, mid - 1);
        node.right = constructBT(nums, mid + 1, right);
        return node;
    }
    
    private static Node sortedArrayToBST(int[] nums) {        
        return constructBT(nums, 0, nums.length - 1);
    }
    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        sortedArrayToBST(nums);
    }
}
