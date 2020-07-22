package learning.algorithms.leetcode.easy;

import java.util.Arrays;
/**
 * 66. Plus One
 * URL - https://leetcode.com/problems/plus-one/
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {4,3,2,9}; //{4,3,2,1}
        System.out.println(Arrays.toString(plusOne(digits)));
    }
    public static int[] plusOne(int[] digits) {
        int temp = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = 0;
            if (i == digits.length - 1) sum = digits[i] + 1;
            if (sum > 9) {
                digits[i] = (sum) % 10;
                temp = sum / 10;
            } else if (sum != 0){
                digits[i] = sum;
            } else if (temp != 0){
                sum = digits[i] + temp;
                temp = 0;
                if (sum > 9) {
                    digits[i] = sum % 10;
                    temp = sum / 10;
                } else {
                    digits[i] = sum;
                }
            }
        }
        if (temp != 0){
            int[] newArr = new int[digits.length + 1];
            newArr[0] = temp;
            return newArr;
        }
        return digits;
    }
}
