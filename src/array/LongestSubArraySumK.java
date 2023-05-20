/*
Given an array containing N integers and an integer K.
Your task is to find the length of the longest Sub-Array with the sum of the elements equal to the given value K.
https://practice.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=longest-sub-array-with-sum-k

Approach:
1. First, we will declare a map to store the prefix sums and the indices.
2. Then we will run a loop(say i) from index 0 to n-1(n = size of the array).
3. For each index i, we will do the following:
    a. We will add the current element i.e. a[i] to the prefix sum.
    b. If the sum is equal to k, we should consider the length of the current subarray i.e. i+1. We will compare this length with the existing length and consider the maximum one.
    c. We will calculate the prefix sum i.e. x-k, of the remaining subarray.
    d. If that sum of the remaining part i.e. x-k exists in the map, we will calculate the length i.e. i-preSumMap[x-k],
    and consider the maximum one comparing it with the existing length we have achieved until now.
    e. If the sum, we got after step 3.1, does not exist in the map we will add that with the current index into the map.
        We are checking the map before insertion because we want the index to be as minimum as possible and
        so we will consider the earliest index where the sum x-k has occurred. [Detailed discussion in the edge case section]

TC: O(n) or (n*logn)
SC: O(n)
 */

package array;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArraySumK {

    public static int lenOfLongSubarr (int a[], int k) {
        //Complete the function
        int n = a.length; // size of the array.

        Map<Integer, Integer> preSumMap = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            //calculate the prefix sum till index i:
            sum += a[i];

            // if the sum = k, update the maxLen:
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }

            // calculate the sum of remaining part i.e. x-k:
            int rem = sum - k;

            //Calculate the length and update maxLen:
            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            //Finally, update the map checking the conditions:
            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 1, 9};
        int k = 15;
        int result = lenOfLongSubarr(arr, k);
        System.out.println(result);
    }
}
