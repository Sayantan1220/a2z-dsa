/*
Given an integer array nums and an integer k, return the number of good subarrays of nums.
A good array is an array where the number of different integers in that array is exactly k.
For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
A subarray is a contiguous part of an array.
https://leetcode.com/problems/subarrays-with-k-different-integers/description/

Approach:
First you may have feeling of using sliding window.
Then this idea get stuck in the middle.
This problem will be a very typical sliding window,
if it asks the number of subarrays with at most K distinct elements.
Just need one more step to reach the folloing equation:
exactly(K) = atMost(K) - atMost(K-1)

TC: O(n)
SC: O(1)
 */

package array;

import java.util.HashMap;
import java.util.Map;

public class SubarraysKDifferentIntegers {

    public static int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    static int atMostK(int[] nums, int k) {
        int i = 0, res = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int j = 0; j < nums.length; ++j) {
            if (count.getOrDefault(nums[j], 0) == 0) k--;
            count.put(nums[j], count.getOrDefault(nums[j], 0) + 1);
            while (k < 0) {
                count.put(nums[i], count.get(nums[i]) - 1);
                if (count.get(nums[i]) == 0) k++;
                i++;
            }
            res += j - i + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1,2,3};
        int result = subarraysWithKDistinct(arr, 2);
        System.out.println(result);
    }
}
