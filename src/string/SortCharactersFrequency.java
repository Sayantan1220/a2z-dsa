/*
Given a string s, sort it in decreasing order based on the frequency of the characters.
The frequency of a character is the number of times it appears in the string.
Return the sorted string. If there are multiple answers, return any of them.
https://leetcode.com/problems/sort-characters-by-frequency/description/

TC: O(n)
SC: O(n)
 */

package string;

import java.util.HashMap;
import java.util.PriorityQueue;

public class SortCharactersFrequency {
    public static String frequencySort(String s) {
        // Three steps:
        // 1> create hashmap store char and its frequencies
        // 2> create a priority queue maxHeap store char with decreasing order of there frequencies.
        // 3> append the charecter in a stringBuilder result.

        HashMap<Character,Integer> map = new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> map.get(b)-map.get(a));
        maxHeap.addAll(map.keySet());

        StringBuilder result = new StringBuilder();
        while(!maxHeap.isEmpty()){
            char current = maxHeap.remove();
            result.append(String.valueOf(current).repeat(Math.max(0, map.get(current))));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "cccaaa";
        String result = frequencySort(s);
        System.out.println(result);
    }
}
