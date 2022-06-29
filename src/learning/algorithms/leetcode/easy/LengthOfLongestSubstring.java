package learning.algorithms.leetcode.easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstringUsingQueue(String s) {
        int len = 0;
        Queue<Character> que = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (!que.contains(s.charAt(i))) {
                que.add(s.charAt(i));
            } else {
                while (que.contains(s.charAt(i))) {
                    que.poll();
                }
                que.add(s.charAt(i));
            }
            len = Math.max(len, que.size());
        }
        return len;
    }

    public int lengthOfLongestSubstringUsingSet(String s) {
        return 0;
    }

    public static int lengthOfLongestSubstringUsingMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int len = 0;
        while (j < s.length()) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)) + 1, i);
            }
            map.put(s.charAt(j), j);
            len = Math.max(len, j - i + 1);
            j++;
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringUsingMap("pwwkew"));
    }
}
