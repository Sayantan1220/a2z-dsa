/*
You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.
You should rearrange the elements of nums such that the modified array follows the given conditions:
Every consecutive pair of integers have opposite signs.
For all integers with the same sign, the order in which they were present in nums is preserved.
The rearranged array begins with a positive integer.
Return the modified array after rearranging the elements to satisfy the aforementioned conditions.
https://leetcode.com/problems/rearrange-array-elements-by-sign/description/

Approach:
As the first element have to be positive will initialize positive index at 0 & negative index at 1
While traversing if it's positive will put in positive index in new array and increment it by 2
Vice versa in case of negative element

TC: O(n)
SC: O(n)
 */

package Array;

import java.util.Arrays;

public class RearrangeArray {

    public static int[] rearrangeArray(int[] nums) {
        int[] list = new int[nums.length];
        int positiveIndex = 0;
        int negativeIndex = 1;

        for (int num : nums) {
            if (num > 0) {
                list[positiveIndex] = num;
                positiveIndex += 2;
            } else if (num < 0) {
                list[negativeIndex] = num;
                negativeIndex += 2;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {3,1,-2,-5,2,-4};
        int[] result = rearrangeArray(arr);
        System.out.println(Arrays.toString(result));
    }

}
