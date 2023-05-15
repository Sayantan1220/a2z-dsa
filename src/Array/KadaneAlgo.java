/*
Given an integer array nums, find the subarray with the largest sum, and return its sum.
https://leetcode.com/problems/maximum-subarray/description/

Approach:
We will use Kadane's algorithm to find the longest subarray sum
For each iteration will add the current element with max here.
If it's gets greater than max so far will replace it.
Every time max here gets less than 0 will reassign at 0.

TC: O(n)
SC: O(1)
 */


package Array;

public class KadaneAlgo {

    public static int maxSubArray(int[] nums) {
        int maxHere = 0;
        int maxSoFar = Integer.MIN_VALUE;

        for (int num : nums) {
            maxHere = maxHere + num;
            maxSoFar = Math.max(maxSoFar, maxHere);
            if (maxHere < 0) {
                maxHere = 0;
            }
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        int result = maxSubArray(arr);
        System.out.println(result);
    }
}
