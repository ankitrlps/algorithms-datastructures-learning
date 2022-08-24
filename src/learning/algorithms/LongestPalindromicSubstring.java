package learning.algorithms;

public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        if (s.length() == 0 || s == null) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        int startIndex = 0, endIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromMiddle(s, i, i);
            int len2 = expandFromMiddle(s, i, i+1);
            int len = Math.max(len1, len2);
            if (len > endIndex - startIndex) {
                startIndex = i - (len-1)/2;
                endIndex = i + len/2;
            }
        }
        return s.substring(startIndex, endIndex + 1);
    }
    
    private static int expandFromMiddle(String s, int left, int right) {
        int L = left;
        int R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        String s = "babad"; // "cbbd"
        System.out.println(longestPalindrome(s));
    }
}
