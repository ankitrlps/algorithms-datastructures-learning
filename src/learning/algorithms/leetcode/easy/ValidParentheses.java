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
}
