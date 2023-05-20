/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

Approach:
For each iteration will maintain a min value by evaluating min between current number and minValue
Will determine the max profit by evaluating max between max and difference of current value and min value

TC: O(n)
SC: O(1)
 */


package array;

public class BestTimeBuySellStock {

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minValue = Integer.MAX_VALUE;
        int n = prices.length;
        for (int i = 0; i < n; i++){
            minValue = Math.min(minValue, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minValue);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        int result = maxProfit(arr);
        System.out.println(result);
    }
}
