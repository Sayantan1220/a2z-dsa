/*
A valid parentheses string is either empty "", "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.
For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
A valid parentheses string s is primitive if it is nonempty, and there does not exist a way to split it into s = A + B, with A and B nonempty valid parentheses strings.
Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings.
Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.

https://leetcode.com/problems/remove-outermost-parentheses/description/

TC: O(n)
SC: O(n)
 */


package String;

public class RemoveOutermostParentheses {
    public static String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int open=0, close=0, start=0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                open++;
            } else if(s.charAt(i) == ')') {
                close++;
            }
            if(open==close) {
                sb.append(s.substring(start+1, i));
                start=i+1;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "(()())(())";
        String result = removeOuterParentheses(s);
        System.out.println(result);
    }
}
