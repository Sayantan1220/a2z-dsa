/*
Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
A shift on s consists of moving the leftmost character of s to the rightmost position.
https://leetcode.com/problems/rotate-string/description/

TC: O(n)
SC: O(1)
 */

package string;

public class RotateString {

    public static boolean rotateString(String s, String goal) {
        if(s ==null || goal == null){
            return false;
        }
        if(s.length() != goal.length()) return false;
        if(s.length() == 0){
            return true;
        }
        int i =0, j =0;
        while(i < s.length() && j < goal.length()){
            if(s.charAt(i) == goal.charAt(j)){
                i++; j++;
            }
            else{
                if(j == 0){
                    i++;
                }
                else{
                    j = 0;
                }
            }
        }
        return (s.substring(0,goal.length() - j).equals(goal.substring(j)));
    }

    public static void main(String[] args) {
        String s = "abcde";
        boolean result = rotateString(s, "cdeab");
        System.out.println(result);
    }
}
