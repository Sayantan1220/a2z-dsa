/*
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack,
or -1 if needle is not part of haystack.
https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/

Approach:
If we observe a bit the number of substrings of size needle length is length of haystack minus length of needle+1
so using two pointer we just used a for loop till (length of haystack-length of needle)
and then checked if the character in needle is equal to character of haystack. If its equal we just kept on incrementing j.
If the j is equal to needle length then we found our first substring that is equal to needle
and we return the index of first character of that substring.
If we dont find the substring in the haystack then we simply return -1.

TC: O(n)
SC: O(n)
 */


package string;

public class FindIndexFirstOccurence {
    public static int strStr(String haystack, String needle) {
        int haylength=haystack.length();
        int needlelength=needle.length();
        if(haylength<needlelength)
            return -1;
        for(int i=0;i<=haystack.length()-needle.length();i++){
            int j=0;
            while(j<needle.length() && haystack.charAt(i+j)==needle.charAt(j))
                j++;
            if(j==needle.length()){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int result = strStr("sadbutsad", "but");
        System.out.println(result);
    }
}
