/*
Given a string s consisting only of characters a, b and c.
Return the number of substrings containing at least one occurrence of all these characters a, b and c.
https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/

Approach:
i)first we have to find substring that contains only 'a','b','c'.
ii)after finding the substring you can think there is no need to increase the 'j' because ,all the substring that you will get has already been contains 'a','b','c'.thats why ans+=n-j; is calculated.
ex:- you can see in the first example we found our first substring at i=0 to j=2; so count of substring(that contains 'a','b','c') starting with i=0,is - n-j=6-2=4;
(for Better understanding, you can dry run this);
iii)then simply increase the ith index to get another sub string that contains only 'a','b','c'.(bassically sliding part);

TC: O(n)
SC: O(n)
 */


package string;

import java.util.HashMap;
import java.util.Map;

public class NumberSubstringsContainingAllThreeCharacters {

    public static int numberOfSubstrings(String s) {
        int n=s.length();
        int i=0;
        int j=0;
        int ans=0;
        Map<Character,Integer> map=new HashMap<>();
        while(j<n){
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            // System.out.println(map);
            if (map.containsKey('a') && map.containsKey('b') && map.containsKey('c')) {
                while (map.containsKey('a') && map.containsKey('b') && map.containsKey('c')) {
                    ans += n - j;
                    char ch = s.charAt(i);
                    map.put(ch, map.getOrDefault(ch, 0) - 1);
                    if (map.get(ch) == 0) {
                        map.remove(ch);
                    }
                    i++;
                }
            }
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabc";
        int result = numberOfSubstrings(s);
        System.out.println(result);
    }
}
