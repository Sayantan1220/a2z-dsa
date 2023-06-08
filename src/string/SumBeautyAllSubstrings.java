/*
The beauty of a string is the difference in frequencies between the most frequent and least frequent characters.
For example, the beauty of "abaacc" is 3 - 1 = 2.
Given a string s, return the sum of beauty of all of its substrings.
https://leetcode.com/problems/sum-of-beauty-of-all-substrings/description/

TC: O(n^2)
SC: O(1)
 */


package string;

public class SumBeautyAllSubstrings {

    public static int beautySum(String s) {
        //using an array as frequency :-
        int sum = 0 ;
        for(int i = 0 ; i < s.length() ; i++){
            int[] frequency = new int[26] ;//for 26 alphabets
            for(int j = i ; j<s.length() ;j++){
                frequency[s.charAt(j)-'a']++ ;
                //now beauty from substring i to j :-
                int beaut = beauty(frequency);
                sum = sum + beaut ;
            }
        }
        return sum ;
    }

    public static int beauty(int[] frequency){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE ;
        for (int j : frequency) {
            if (j != 0) {//this is very very very important
                min = Math.min(j, min);
            }
            max = Math.max(j, max);
        }
        return max-min ;
    }

    public static void main(String[] args) {
        String s = "aabcbaa";
        int result = beautySum(s);
        System.out.println(result);
    }
}
