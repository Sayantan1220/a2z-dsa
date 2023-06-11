/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
Return the answer in any order.
A mapping of digits to letters (just like on the telephone buttons) is given below.
Note that 1 does not map to any letters.
https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

TC: O(n)
SC: O(n)
 */


package Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsPhoneNumber {

    static Map<Character, String> map;
    static List<String> res;
    public static List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if(digits.length() == 0) return res;
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        solve("", 0, digits, digits.length());
        return res;
    }

    public static void solve(String s, int ind, String digit, int len) {
        if(s.length() == len) {
            res.add(s);
            return;
        }
        char ch = digit.charAt(ind);
        String str = map.get(ch);
        for(int i=0; i<str.length(); i++) {
            solve(s+str.charAt(i), ind+1, digit, len);
        }
    }

    public static void main(String[] args) {
        String s = "239";
        List<String> result = letterCombinations(s);
        System.out.println(result);
    }
}
