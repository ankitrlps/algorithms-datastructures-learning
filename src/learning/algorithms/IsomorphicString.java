package learning.algorithms;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {

    public boolean isIsomorphic1(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < sChar.length; i++) {
            if (map.containsKey(sChar[i]) && tChar[i] != map.get(sChar[i])) return false;
            else if (!map.containsKey(sChar[i]) && map.containsValue(tChar[i])) return false;
            map.put(sChar[i], tChar[i]);
        }
        return true;
    }
    
    public static boolean isIsomorphic(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        int[] indexCharS = new int[256];
        int[] indexCharT = new int[256];
        for (int i = 0; i < sChar.length; i++) {
            if (indexCharS[sChar[i]] != indexCharT[tChar[i]]) return false;
            indexCharS[sChar[i]] = i + 1;
            indexCharT[tChar[i]] = i + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("badc", "baba"));
        System.out.println(isIsomorphic("paper", "title"));
    }
}
