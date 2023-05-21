/*
Given an array of integers nums sorted in non-decreasing order,
find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

Approach:
1. Initialize the answer array result with [-1, -1] to represent the starting and ending indices of the target value.
2. Initialize start as 0, end as the last index of the nums array.
3. Calculate mid as the floor division of low + (high - low)/2 (Because of int overflow)
4. Run a binary search loop until start becomes greater than end.
5. Check if the target value is equal to the element at the mid index of nums.
    If true, update ans[0] (starting index) with mid and move the end pointer to mid - 1 to continue searching for the leftmost occurrence of the target.
    If false, check if the target value is less than the element at the mid index of nums.
    If true, update end to mid - 1 to narrow down the search range to the left half.
    If false, update start to mid + 1 to narrow down the search range to the right half.
6. Reset start to 0 and end to the last index of the nums array.
7. Calculate mid as the floor division of low + (high - low)/2 (Because of int overflow)
8. Run another binary search loop until start becomes greater than end.
9. Check if the target value is equal to the element at the mid index of nums.
    If true, update ans[1] (ending index) with mid and move the start pointer to mid + 1 to continue searching for the rightmost occurrence of the target.
    If false, check if the target value is less than the element at the mid index of nums.
    If true, update end to mid - 1 to narrow down the search range to the left half.
    If false, update start to mid + 1 to narrow down the search range to the right half.
10. Return the ans vector containing the starting and ending indices of the target value.

TC: O(log n)
SC: O(1)
 */


package binary_search;

import java.util.Arrays;

public class FindFirstLastPositionTarget {

    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int low = 0;
        int high = nums.length - 1;
        int mid;

        // First Occurrence
        while (low <= high) {
            mid = low + (high - low)/2;
            if (target == nums[mid]) {
                result[0] = mid;
                high = mid - 1;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            }
        }

        // Last Occurrence
        low = 0;
        high = nums.length - 1;
        while (low <= high) {
            mid = low + (high - low)/2;
            if (target == nums[mid]) {
                result[1] = mid;
                low = mid + 1;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        int[] result = searchRange(arr, 8);
        System.out.println(Arrays.toString(result));
    }
}
