/*
Given two strings s and t of lengths m and n respectively, return the minimum window
substring of s such that every character in t (including duplicates) is included in the window.
If there is no such substring, return the empty string "".
The testcases will be generated such that the answer is unique.
https://leetcode.com/problems/minimum-window-substring/description/

Approach
i is used to take character and j is used to release characters.

Let's add all occurances of character in t.
for(int i = 0; i < t.length(); i++){
    char ch = t.charAt(i);
    hm2.put(ch, hm2.getOrDefault(ch, 0) + 1);
}
Now lets take two pointer i and j and count variable mcnt.
So I will increase my count if my HashMap of t(count of particular variable) is greater than HashMap of s(count of that particular variable).
char ch = s.charAt(i);
if(hm1.getOrDefault(ch, 0) <= hm2.getOrDefault(ch, 0)){
    mcnt++;
}
After this part now it is time to calculate the mniimum one.
So, I will make a String potential answer(pans) and the substring will be from j + 1 to i + 1.
if pans.length is smaller than answer.length then it means It has the minimum length so I will store it in ans. And I will increase j to find smaller.
6)Now it is time to release character so we will check if frequency is 1 then directly remove from HashMap else decrease the frequency by one.
if(hm1.get(ch) == 1) hm1.remove(ch);
else hm1.put(ch, hm1.get(ch) - 1);
Now check if HashMap for s is lesser than hashmap for t then decrease count. It means we can still get a lesser length of string.

TC: O(n)
SC: O(n)
 */

package string;

import java.util.HashMap;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        String ans = "";
        HashMap<Character, Integer> hm2 = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            hm2.put(ch, hm2.getOrDefault(ch, 0) + 1);
        }
        int mcnt = 0;
        int dnct = t.length();
        HashMap<Character, Integer> hm1 = new HashMap<>();
        int i = -1;
        int j = -1;
        while(true){
            boolean f1 = false;
            boolean f2 = false;
            //accuire
            while(i < s.length() - 1 && mcnt < dnct){
                i++;
                char ch = s.charAt(i);
                hm1.put(ch, hm1.getOrDefault(ch, 0) + 1);
                if(hm1.getOrDefault(ch, 0) <= hm2.getOrDefault(ch, 0)){
                    mcnt++;
                }
                f1 = true;
            }
            //collect answer and release
            while(j < i && mcnt == dnct){
                String pans = s.substring(j + 1, i + 1);
                if(ans.length() == 0 || pans.length() < ans.length()) ans = pans;
                j++;
                char ch = s.charAt(j);
                if(hm1.get(ch) == 1) hm1.remove(ch);
                else hm1.put(ch, hm1.get(ch) - 1);
                if(hm1.getOrDefault(ch, 0) < hm2.getOrDefault(ch, 0))
                    mcnt--;
                f2 = true;
            }
            if(!f1 && !f2)
                break;
        }
        return ans;
    }

    public static void main(String[] args) {
        String result = minWindow("ADOBECODEBANC", "ABC");
        System.out.println(result);
    }
}
