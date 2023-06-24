package stack_queue;

public class MinimumAddMakeParenthesesValid {
    public int minAddToMakeValid(String s) {
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

}
