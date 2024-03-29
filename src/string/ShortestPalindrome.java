/*
You are given a string s. You can convert s to a palindrome by adding characters in front of it.
Return the shortest palindrome you can find by performing this transformation.

https://leetcode.com/problems/shortest-palindrome/description/

Approach :
First of All, My origin thought on this problem is to find the longest palindrome from the starting character of the string.
 Then we can just adding the reverse of the remaining characters to the front of the origin string to get
 the required shortest palindrome. However, the time complexity for finding the longest palindrome
 from front can cost O(n^2) and will cause a TLE when coding in Java.

Then I found this solution post C++ 8 ms KMP-based O(n) time & O(n) memory solution
The code and the idea were great but the explanation was somehow lacking some insight of how people construct this solution.
After read the code as well as the provided explanation, I became quiet confused with the following questions:
Why should we have a combined string and why this string should be combined like this. Can we combined the string with the reverse string first and the origin string second?
What's the use of the array/vector and what value does it store? Is the numeric value represent length or something else?
What is "recursively" updating the index means?
In order to answer these questions, we have to look back to my origin idea which is finding the longest palindrome from the front. In fact the KMP solution use a similar idea which is finding the longest prefix which has an identical counter part string that ends at the tail of the combined string(longest suffix) For example, let's say we have a string "abac#caba", then the qualified string will be "aba".
How can we find this string? The KMP method provide us with a way to accomplish that.The detail implementation is using an array of the length of the combined string to store the index of the character which need to be compared with the next character if current character matches the prefix's last character. If they are the same, the index that need to be stored for the next character will be the previous stored index+1. Otherwise, we will jump further back to the index of the index to perform the same procedure until the index become zero. Then in the end, the value-1 in the last array element will represent the longest common prefix's last index value and we find the longest common prefix. Since these two strings are reversed and identical string, it must be a palindrome which fulfills my origin goal of finding the longest palindrome from the starting character.
One example for the above process for the string s "abac#caba". we will have the stored indexes be "0,0,1,0,0,1,2,3" .Let's say we are at index 7 of the string s and the character is 'b' and in the array we have 1 for the previous index 6. This means the character at index 1 will need to be compared with character b to decide whether the common prefix from the front can continue to grow or not. Since both characters at index 1 and at index 7 are 'b', the common prefix grows into length 2 which is"ab".
Back to the first question, since the KMP method will help us find the longest prefix that exist in the body of the new string and we want to find the longest palindrome prefix of the origin string. We have to have the origin string at front and reverse string follows. For the second question, the array store index of the prefix that need to be match for the next character. For the last question, the recursive update happens when the matching failure so we jump to the further back to match early index in the prefix.

TC: O(n)
SC: O(n)
 */


package string;

public class ShortestPalindrome {

    public static String shortestPalindrome(String s) {
        if(s.length()<=1) return s;
        String new_s = s+"#"+new StringBuilder(s).reverse().toString();
        int[] position = new int[new_s.length()];

        for(int i=1;i<position.length;i++) {
            int pre_pos = position[i-1];
            while(pre_pos>0 && new_s.charAt(pre_pos)!=new_s.charAt(i))
                pre_pos = position[pre_pos-1];
            position[i] = pre_pos+((new_s.charAt(pre_pos)==new_s.charAt(i))?1:0);
        }

        return new StringBuilder(s.substring(position[position.length-1])).reverse()+s;
    }

    public static void main(String[] args) {
        String s = "abcd";
        String result = shortestPalindrome(s);
        System.out.println(result);
    }
}
