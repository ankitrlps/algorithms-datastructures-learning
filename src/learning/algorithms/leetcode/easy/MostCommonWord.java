package learning.algorithms.leetcode.easy;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {

    static String commonWord(String p, String[] banned) {
        String[] s = p.split(" ");
        
        p = p.replaceAll("[^a-zA-Z0-9]", " ").toLowerCase();
        s = p.split("\\s+");
        
        Set<String> ban = new HashSet<>();
        for (String string : banned) {
            ban.add(string);
        }

        Map<String, Integer> map = new HashMap<>();
        for (String ss : s) {
            if (!ban.contains(ss)) {
                map.put(ss, map.getOrDefault(ss, 0) + 1);
            }
        }
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static void main(String[] args) {
        String[] banned = {"hit"};
        System.out.println("Common Word 1: " + commonWord("Bob hit a ball, the hit BALL flew far after it was hit.", banned));
        System.out.println("Common Word 2: " + commonWord("a, a, a, a, b,b,b,c, c", new String[]{"a"}));
    }    
}
