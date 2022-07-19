package learning.algorithms;

public class Gcd {

    private static int gcd(int a, int b) {
        int val = Math.min(a, b);
        while (val > 0) {
            if (a % val == 0 && b % val == 0) {
                break;
            }
            val--;
        }
        return val;
    }

    private static int gcd(int[] arr) {
        int res = arr[0];
        for (int i = 0; i < arr.length; i++) {
            res = gcd(arr[i], res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(gcd(arr));
    }
    
}
