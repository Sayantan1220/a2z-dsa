/*
Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size groupSize,
and consists of groupSize consecutive cards.
Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize,
return true if she can rearrange the cards, or false otherwise.
https://leetcode.com/problems/hand-of-straights/description/

Approach:
Create a map countMap to count the frequency of each card in the hand.
Sort the hand in ascending order.
Iterate through the hand and for each card:
a. If the frequency of the current card is 0, continue to the next card.
b. For each number in a group of size groupSize starting from the current card:
i. If the frequency of the number is 0, return false as it is not possible to form the required group.
ii. Decrement the frequency of the number in the countMap.
If we have successfully formed all groups, return true.

Complexity:
Time Complexity:
The time complexity of the solution is O(nlogn) where n is the size of the hand.
This is because we sort the hand before iterating through it, which takes O(nlogn) time.
The subsequent iterations take O(n) time as we iterate through each card once.

Space Complexity:
The space complexity of the solution is O(n) as we use a map to store the frequency of each card in the hand.
In the worst case, if all cards in the hand are unique, the map will have n entries.
*/

package map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HandOfStraights {

    public static boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int card : hand) {
            countMap.put(card, countMap.getOrDefault(card, 0) + 1);
        }
        Arrays.sort(hand);
        for (int k : hand) {
            if (countMap.get(k) == 0) {
                continue;
            }
            for (int j = 0; j < groupSize; j++) {
                int currCard = k + j;
                if (countMap.getOrDefault(currCard, 0) == 0) {
                    return false;
                }
                countMap.put(currCard, countMap.get(currCard) - 1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,6,2,3,4,7,8};
        boolean result = isNStraightHand(arr, 3);
        System.out.println(result);
    }
}
