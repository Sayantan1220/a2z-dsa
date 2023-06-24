/*
A parentheses string is valid if and only if:
It is the empty string,
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.
For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
Return the minimum number of moves required to make s valid.
https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/

Approach:
Stack consists of '(' and ')' symbols only.
In case of '(' you have to push it into the Stack.
In case of ')' there are two conditions we have to handle.
Firstly when the stack is empty.
Secondly when the stack is not empty .
When Stack is empty!!
Increase the count value because we dont have enough '(' that equal to ')'
When stack is not empty!!
If stack is not empty definetly there will be a '(' at that time you can just pop it.
When Stack consists of only '(' !!
In this case we just have to add size of the Stack to the count variable.
count is the minimum additions to make parentheses valid.

TC: O(n)
SC: O(1)
 */

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
