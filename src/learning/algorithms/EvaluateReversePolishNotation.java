package learning.algorithms;

import java.util.Stack;

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */

public class EvaluateReversePolishNotation {

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                switch (token) {
                    case "+": stack.push(b+a); break;
                    case "*": stack.push(a*b); break;
                    case "/": stack.push(b/a); break;
                    case "-": stack.push(b-a); break;
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2","1","+","3","*"})); // ((2 + 1) * 3) = 9
        System.out.println(evalRPN(new String[]{"4","13","5","/","+"})); // (4 + (13 / 5)) = 6
        System.out.println(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"})); // ((10 * (6 / ((9 + 3) * -11))) + 17) + 5s
    }
}
