/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
typically using all the original letters exactly once.
https://leetcode.com/problems/valid-anagram/description/

TC: O(n)
SC: O(1)
 */

package string;

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {

        int[] arr = new int[256];
        if (s.length() != t.length()){
            return false;
        }

        for (int i = 0; i < s.length(); i++){
            arr[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++){
            if (arr[t.charAt(i) - 'a']-- == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        boolean result = isAnagram(s, t);
        System.out.println(result);
    }
}
