package learning.algorithms;

import java.util.Arrays;
import java.util.Comparator;

public class TEst {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int num = 32;
        while (num > 0) {
            sb.append(num%2);
            num = num/2;
        }
        //System.out.println(Integer.parseInt(String.valueOf(sb.charAt(3)));

        int[][] arr = new int[2][2];
        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[0]));
        Arrays.sort(arr, Comparator.comparingInt(a -> a[1]));
        System.out.println(Character.toString((char) 97));
    }
}
