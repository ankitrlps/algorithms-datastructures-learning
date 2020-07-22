package learning.algorithms.leetcode.easy;

/**
 * 67. Add Binary
 * URL - https://leetcode.com/problems/add-binary/
 */
public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("110010","100"));
    }
    public static String addBinary(String a, String b) {
        if (a.length() == 1 && a.equals("0")) {
            return b;
        } else if (b.length() == 1 && b.equals("0")) {
            return a;
        }
        int carrier = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        int maxLength = a.length() >= b.length() ? a.length() : b.length();
        char[] ch = new char[maxLength + 1];

        while (i >= 0 || j >= 0) {
            int a1 = 0, b1 = 0;
            if (i >= 0){
                a1 = Integer.parseInt(String.valueOf(a.charAt(i)));
            }
            if (j >= 0){
                b1 = Integer.parseInt(String.valueOf(b.charAt(j)));
            }
            int sum = a1 + b1 + carrier;
            if (sum < 2) {
                ch[maxLength] = sum == 0 ? '0' : '1';
                carrier = 0;
            } else {
                if (sum == 2) {
                    ch[maxLength] = '0';
                } else {
                    ch[maxLength] = '1';
                }
                carrier = 1;
            }
            i--;
            j--;
            maxLength--;
        }
        if (carrier == 1 && ch[0] == 0) {
            ch[0] = '1';
            return String.valueOf(ch);
        } else {
            return String.valueOf(ch, 1, ch.length - 1);
        }
    }
}
