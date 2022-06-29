package learning.algorithms.leetcode.easy;
/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 */
public class FirstUniqueCharacterString {

    private static int solution(String s) {
        // Map<Character, Integer> map = new HashMap<>();
        // for (int i = 0; i < s.length(); i++) {
        // map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        // }

        // for (int i = 0; i < s.length(); i++) {
        // if (map.get(s.charAt(i)) == 1) {
        // return i;
        // }
        // }

        int res = Integer.MAX_VALUE;
        for (char c = 'a'; c <= 'z'; c++) {
            int index = s.indexOf(c);
            if (index != -1 && index == s.lastIndexOf(c)) {
                res = Math.min(res, index);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        String s = "lee";
        System.out.println(solution(s));
    }
}
