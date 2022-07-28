package learning.algorithms;

import java.util.PriorityQueue;

public class KthElement {

    public static int findKthLargest(int[] nums, int k) {
        if (nums.length < k) {
            return 0;
        }
        k = nums.length - k;
        return findK(nums, 0, nums.length - 1, k);
    }

    private static int findK(int[] nums, int left, int right, int k) {
        int partition = quickSelect(nums, left, right);
        if (partition == k) {
            return nums[partition];
        } else if (partition < k) {
            return findK(nums, partition + 1, right, k);
        } else {
            return findK(nums, left, partition - 1, k);
        }
    }

    private static int quickSelect(int[] nums, int left, int right) {
        int pivot = nums[right];
        int pointer = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] < pivot) {
                int temp = nums[pointer];
                nums[pointer] = nums[i];
                nums[i] = temp;
                pointer++;
            }
        }
        int temp = nums[pointer];
        nums[pointer] = nums[right]; // nums[right] is pivot
        nums[right] = temp;
        return pointer;
    }

    private static int usingPriorityQueue(int[] nums, int k) {
        PriorityQueue<Integer> pQue = new PriorityQueue<>((n1, n2) -> n1 - n2);
        int res = 0;
        pQue.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            pQue.add(nums[i]);
            if (pQue.size() > k) {
                pQue.poll();
            }
        }
        return pQue.poll();
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 9));
    }
}
