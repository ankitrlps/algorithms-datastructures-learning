package learning.algorithms.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("([)]")); // "()[]{}"
    }
    public static boolean isValid(String s) {
        if(s.isEmpty()) return true;
        Map<Character, Character> parentheses = new HashMap<>();
        parentheses.put('(', ')');
        parentheses.put('{', '}');
        parentheses.put('[', ']');
        Stack<Character> openBrackets = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (parentheses.containsKey(ch)) {
                openBrackets.add(ch);
            } else if(!openBrackets.isEmpty() && ch == parentheses.get(openBrackets.peek())) {
                openBrackets.pop();
            } else {
                return false;
            }
        }
        return openBrackets.isEmpty();
    }


    public boolean isValid1(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        if (s.length() == 1) {
            return false;
        }
        int i = 0;
        boolean res = true;
        Stack<Character> stack = new Stack<>();
        while (i < s.length()) {
            if (map.containsKey(s.charAt(i))) {
                stack.add(s.charAt(i));
            } else if (stack.isEmpty() || map.get(stack.pop()) != s.charAt(i)) {
                res = false;
                break;
            }
            i++;
        }
        if (!stack.isEmpty()) {
            res = false;
        }
        return res;
    }
}
