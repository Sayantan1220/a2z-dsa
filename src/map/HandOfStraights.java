package map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HandOfStraights {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int card : hand) {
            countMap.put(card, countMap.getOrDefault(card, 0) + 1);
        }
        Arrays.sort(hand);
        for (int i = 0; i < hand.length; i++) {
            if (countMap.get(hand[i]) == 0) {
                continue;
            }

            for (int j = 0; j < groupSize; j++) {
                int currCard = hand[i] + j;

                if (countMap.getOrDefault(currCard, 0) == 0) {
                    return false;
                }

                countMap.put(currCard, countMap.get(currCard) - 1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "239";
        List<String> result = letterCombinations(s);
        System.out.println(result);
    }
}
