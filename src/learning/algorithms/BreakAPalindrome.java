package learning.algorithms;

public class BreakAPalindrome {

    public String breakPalindrome1(String palindrome) {
        if (palindrome.length() == 1) {
            return "";
        }
        String temp = new String(palindrome);
        for (int i = 0; i < palindrome.length(); i++) {
            if (palindrome.charAt(i) != 'a') {
                palindrome = palindrome.replaceFirst(String.valueOf(palindrome.charAt(i)), String.valueOf('a'));
                break;
            }
        }
        return isPalindrome(palindrome) ? temp.substring(0, palindrome.length() - 1) + "b" : palindrome;
    }
    
    private static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public static String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1) {
            return "";
        }
        int mid = palindrome.length() / 2;
        char[] ch = palindrome.toCharArray();
        for (int i = 0; i < mid; i++) {
            if (ch[i] != 'a') {
                ch[i] = 'a';
                return new String(ch);
            }
        }
        ch[palindrome.length() - 1] = 'b';
        return new String(ch);
    }

    public static void main(String[] args) {
        System.out.println("Break Palindrome: " + breakPalindrome("abccba"));
        System.out.println("Break Palindrome: " + breakPalindrome("aba"));
        System.out.println("Break Palindrome: " + breakPalindrome("aa"));
    }
}
