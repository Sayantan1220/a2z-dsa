/*
There are several cards arranged in a row, and each card has an associated number of points.
The points are given in the integer array cardPoints.
In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.
Your score is the sum of the points of the cards you have taken.
Given the integer array cardPoints and the integer k, return the maximum score you can obtain.
https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/

TC: O(n)
SC: O(n)
 */

package array;

public class MaximumPointsYouCanObtainCards {

    public static int maxScore(int[] cardPoints, int k) {
        int lastIndex = cardPoints.length - 1; // index of last element in cardPoints array
        int windowStartIndex = 0; // start index of sliding window
        int windowEndIndex = lastIndex - k; // end index of sliding window
        int totalSum = 0; // sum of all elements in cardPoints array
        for (int cardPoint : cardPoints) {
            totalSum += cardPoint;
        }
        int currentWindowSum = 0; // sum of elements in current sliding window
        for (int i = 0; i <= windowEndIndex; i++) {
            currentWindowSum += cardPoints[i];
        }
        windowStartIndex++; // move the start index of sliding window to the right
        windowEndIndex++; // move the end index of sliding window to the right
        int minWindowSum = currentWindowSum; // initialize minimum sliding window sum to current sliding window sum
        while (windowEndIndex <= lastIndex) { // slide the window to the right and update the minimum sliding window sum
            currentWindowSum = currentWindowSum - cardPoints[windowStartIndex - 1] + cardPoints[windowEndIndex]; // remove the leftmost element and add the rightmost element to update the sliding window sum
            minWindowSum = Math.min(minWindowSum, currentWindowSum); // update the minimum sliding window sum
            windowStartIndex++; // move the start index of sliding window to the right
            windowEndIndex++; // move the end index of sliding window to the right
        }
        return totalSum - minWindowSum; // return the maximum possible score
    }

    public static void main(String[] args) {
        int[] arr = {9,7,7,9,7,7,9};
        int result = maxScore(arr, 7);
        System.out.println(result);
    }
}
