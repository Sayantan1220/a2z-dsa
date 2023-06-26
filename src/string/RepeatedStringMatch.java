/*
Given two strings a and b, return the minimum number of times you should repeat string a so that string b is a substring of it.
If it is impossible for b to be a substring of a after repeating it, return -1.
Notice: string "abc" repeated 0 times is "", repeated 1 time is "abc" and repeated 2 times is "abcabc".
https://leetcode.com/problems/repeated-string-match/description/

TC: O(n)
SC: O(n)
 */

package string;

public class RepeatedStringMatch {

    public static int repeatedStringMatch(String a, String b) {
        StringBuilder copy = new StringBuilder();
        int count=0;
        while(copy.length()<b.length()){
            copy.append(a);
            count++;
        }
        if(copy.toString().contains(b))
            return count;
        if((copy + a).contains(b))
            return ++count;
        return -1;
    }

    public static void main(String[] args) {
        int result = repeatedStringMatch("abcd", "cdabcdab");
        System.out.println(result);
    }
}
