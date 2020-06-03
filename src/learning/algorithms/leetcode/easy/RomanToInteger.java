package learning.algorithms.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    private static Map<String, Integer> values = new HashMap<>();
    public static void main(String[] args) {
        values.put("I", 1);
        values.put("V", 5);
        values.put("X", 10);
        values.put("L", 50);
        values.put("C", 100);
        values.put("D", 500);
        values.put("M", 1000);
        System.out.print(romanToInteger("mcmxciV"));
    }

    public static int romanToInteger(String s){
        char[] sArr = s.toUpperCase().toCharArray();
        int result = 0;
        for (int i = sArr.length - 1; i >= 0; i--){
            int value = values.get(String.valueOf(sArr[i]));
            if(value < result && !(result == 2))
                value *= -1;
            result = result + value;
        }
        return result;
    }
}
