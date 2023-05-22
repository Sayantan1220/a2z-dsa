/*
A peak element is an element that is strictly greater than its neighbors.
Given a 0-indexed integer array nums, find a peak element, and return its index.
If the array contains multiple peaks, return the index to any of the peaks.
You may imagine that nums[-1] = nums[n] = -∞. In other words,
an element is always considered to be strictly greater than a neighbor that is outside the array.
You must write an algorithm that runs in O(log n) time.
https://leetcode.com/problems/find-peak-element/description/

Approach:
1. The code initializes two pointers, start and end, which represent the start and end indices of the search range.
2. A while loop runs until the start pointer is less than the end pointer.
3. Inside the loop, the code calculates the middle index mid as the average of start and end.
4. Special cases are handled for mid being the first or last index. If mid is the first index, the code checks if the element at index 0 is a peak by comparing it with the element at index 1. If it is greater, it returns 0; otherwise, it returns 1. Similarly, if mid is the last index, the code checks if the element at index end - 1 is a peak by comparing it with the element at index end - 2. If it is greater, it returns end - 1; otherwise, it returns end - 2.
5. If none of the special cases are met, the code checks if the element at index mid is a peak by comparing it with its neighboring elements at indices mid + 1 and mid - 1. If it is greater than both neighbors, it is a peak, and the function returns mid.
6. If the element at index mid is less than its left neighbor (mid - 1), the code sets end to mid - 1, as the peak must be on the left side.
7. Otherwise, if the element at index mid is less than its right neighbor (mid + 1), the code sets start to mid + 1, as the peak must be on the right side.
8. The loop continues with the updated values of start and end until a peak element is found.
9. If the loop completes without finding a peak element, the function returns start as the index of the last checked element, which is considered as a potential peak.

TC: O(log n)
SC: O(1)
 */


package binary_search;

public class FindPeakElement {

    public static int findPeakElement(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (mid == 0) {
                return nums[0] >= nums[1] ? 0 : 1;
            }
            if (mid == end) {
                return nums[end - 1] >= nums[end - 2] ? end - 1 : end - 2;
            }

            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                return mid;
            }
            if (nums[mid] < nums[mid - 1]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1,3,5,6,4};
        int result = findPeakElement(arr);
        System.out.println(result);
    }
}
