package learning.algorithms;

public class FindPivotIndex {
    public static int pivotIndex(int[] nums) {
        int i = 0, j = nums.length-1;
        int sumI = 0, sumJ = 0, index = -1;
        while (i < nums.length-2 && j > 0) {                
            if (nums[i] == 0) {i++; continue;}
            else if (nums[j] == 0) {j--; continue;}
            if (sumI + nums[i] > sumJ + nums[j]) {
                sumJ += nums[j];
                j--;
            } else if (sumI + nums[i] < sumJ + nums[j]) {
                sumI += nums[i];
                i++;
            } else {
                if (i+ 1 == j - 1) index = i + 1;
                i++;
                j--;
            }            
        }
        if (i == j && (sumI == 0 || sumJ == 0)) return i;
        return index;
    }

    public static void main(String[] args) {
        //System.out.println("index: " + pivotIndex(new int[]{1,7,3,6,5,6}));
        //System.out.println("index: " + pivotIndex(new int[]{1,2,3}));
        //System.out.println("index: " + pivotIndex(new int[]{2,1,-1}));
        //System.out.println("index: " + pivotIndex(new int[]{-1,-1,-1,-1,-1,-1}));
        System.out.println("index: " + pivotIndex(new int[]{-1,-1,-1,-1,-1,0}));
    }
}
