package learning.algorithms;

/**
 * Count total set bits (1's) in all numbers from 1 to n
 *
 * Input: n = 3
 * Output:  4
 *
 * Input: n = 6
 * Output: 9
 *
 * Input: n = 7
 * Output: 12
 *
 * Input: n = 8
 * Output: 13
 */
public class BitSetCount {

    private static int countBitSet(int n) {
        int count = 0;
        if (n == 1 || n == 2) {
            return n;
        }
        int runner = 3;
        while (runner <= n) {
            int dividend = runner;
            while (dividend > 1) {
                if (dividend % 2 == 1) {
                    count++;
                }
                dividend = dividend / 2;
            }
            count++;
            runner++;
        }
        return count + 2; // adding count of 1 and 2
    }

    public static void main(String[] args) {
        System.out.println(countBitSet(6));
    }
}
