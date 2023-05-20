/*
Given an input string s, reverse the order of the words.
A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
Return a string of the words in reverse order concatenated by a single space.
Note that s may contain leading or trailing spaces or multiple spaces between two words.
The returned string should only have a single space separating the words. Do not include any extra spaces.
https://leetcode.com/problems/reverse-words-in-a-string/description/

Approach:
First, check if the input string "s" is null or empty. If true, return an empty string.
Split the string "s" into individual words using the space character as the delimiter. This creates an array of words.
Initialize a StringBuilder "sb" to store the reversed words.
Iterate through the array of words in reverse order, starting from the last word.
Check if the current word is not an empty string. If true, append it to the StringBuilder followed by a space.
After the loop, check if the StringBuilder "sb" is empty. If true, return an empty string.
If the StringBuilder is not empty, use the substring method to remove the trailing space at the end and return the reversed string.

TC: O(n)
SC: O(n)
 */

package string;

public class ReverseWordsString {

    public static String reverseWords(String s) {
        if (s == null || s.length() == 0)
        {
            return "";
        }
        // split to words by space
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; --i)
        {
            if (!arr[i].equals(""))
            {
                sb.append(arr[i]).append(" ");
            }
        }
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        String result = reverseWords(s);
        System.out.println(result);
    }
}
