package stack_queue;

import java.util.Stack;

public class MinimumAddMakeParenthesesValid {
    public static int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for(char c : s.toCharArray()) {
            if(stack.isEmpty()) {
                if(c == '(') stack.push(c);
                else count++;
            }
            else {
                if(c=='(') stack.push(c);
                else {
                    stack.pop();
                }
            }
        }
        if(!stack.isEmpty() && stack.peek() == '(') {
            count += stack.size();
        }
        return count;
    }

    public static void main(String[] args) {
        int result = minAddToMakeValid("((()");
        System.out.println(result);
    }

}
