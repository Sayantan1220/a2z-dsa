/*
Given an array of integers nums which is sorted in ascending order, and an integer x,
write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
You must write an algorithm with O(log n) runtime complexity.

https://leetcode.com/problems/binary-search/description/

TC: O(log n)
SC: O(1)
 */


package binary_search;

public class Binary_Search {

    public static int search(int[] nums, int x) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == x)
                return mid;

            if (nums[mid] < x)
                low = mid + 1;

            else
                high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {-1,0,3,5,9,12};
        int result = search(arr, 9);
        System.out.println(result);
    }
}
