package learning.algorithms;

public class KthElement {

    private static int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        return findK(nums, 0, nums.length-1, k);
    }
    
    private static int findK(int[] nums, int left, int right, int k) {
        int partition = quickSelect(nums, left, right);
        if (partition == k) {
            return nums[partition];
        }
        if (partition < k) {
           return findK(nums, partition + 1, nums.length-1, k);
        } else {
            return findK(nums, 0, partition - 1, k);
        }
    }
    
    private static int quickSelect(int[] nums, int left, int right) {
        int pivot = nums[right];
        int pointer = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] < pivot) {
                // int temp = nums[i];
                // nums[i] = nums[pointer];
                // nums[pointer] = temp;
                pointer++;                
            } 
        }
        int temp = nums[pointer];
        nums[pointer] = nums[right]; //nums[right] is pivot
        nums[right] = temp;
        return pointer;
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 9));
    }    
}
