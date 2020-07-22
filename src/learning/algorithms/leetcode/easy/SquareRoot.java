package learning.algorithms.leetcode.easy;

/**
 * 69. Sqrt(x)
 * URL - https://leetcode.com/problems/sqrtx/
 */
public class SquareRoot {
    public static void main(String[] args) {
        System.out.println(sqrt(8));
    }
    public static int sqrt(int x){
        if (x < 2)
            return x;
        int low = 2, high = x/2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long powr = (long) mid * mid;
            if (x == powr) {
                return mid;
            } else if (x < powr){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }
}
