package learning.algorithms;
/**
 * https://leetcode.com/problems/maximum-number-of-groups-entering-a-competition/submissions/
 */

public class MaximumNumOfGroups {

    int maximumGroups2(int[] grades) {
        int n=grades.length;
        int i=0,sum=0;
        while(sum<n){
            i++;
            sum=(i*(i+1))/2;
            if(sum==n) return i;
        }
        return i-1; // i must have gone one step further, so return i-1
    }

     public int maximumGroups(int[] grades) {
        int n = grades.length;
        int i = 0;
        while (((i * (i + 1)) / 2) <= n) {
            i++;
        }
         return i-1;
    }

    public int maximumGroups1(int[] grades) {
        // 1. (k * (k+1)) / 2 <= n
        // 2. k^2 + k <= 2n
        // 3. k^2 + k -2n <= 0
        // 4. Quadratic eq: (-b + Sqrt(b^2-4ac))/2a
        // input a b c values from point 3 to 4
        // 5. (-1 + Sqrt(1+8n))/2
        return (int) (Math.sqrt(1+8*grades.length) - 1)/2;
    }

    public static void main(String[] args) {
        
    }
}
