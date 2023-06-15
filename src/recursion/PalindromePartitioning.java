/*
Given a string s, partition s such that every substring of the partition is a palindrome.
Return all possible palindrome partitioning of s.
https://leetcode.com/problems/palindrome-partitioning/description/

TC: O(n^2)
SC: O(n)
 */

package recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static List<List<String>> partition(String s) {
        //Approach: Using Backtracking, T.C: O(n^2)
        if(s==null || s.length()==0) return new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        helper(s, ans, new ArrayList<>());
        return ans;
    }

    public static void helper(String s, List<List<String>> ans, List<String> level){
        //base case
        if(s==null || s.length()==0){
            ans.add(new ArrayList<>(level));
            return;
        }
        //iterate, here i=1 because we are going to use substring method
        for(int i=1;i<=s.length();i++){
            String temp = s.substring(0, i);
            //if not palindrome then continue
            if(!isPalindrome(temp)) continue;
            //add to level list
            level.add(temp);
            //call recursion
            helper(s.substring(i), ans, level);
            //remove from the level list
            level.remove(level.size()-1);
        }
    }

    //using binary search algo
    public static boolean isPalindrome(String temp){
        int left = 0;
        int right = temp.length()-1;
        while(left<=right){
            if(temp.charAt(left)!=temp.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> result = partition(s);
        System.out.println(result);
    }
}
