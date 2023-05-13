/*
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent,
with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
You must solve this problem without using the library's sort function.

https://leetcode.com/problems/sort-colors/description/

Approach :
Dutch national flag algorithm:
Take three pointers low & mid at 0 and high at n - 1
If array [mid] =0, then swap array [mid] with array [low] and increment both pointers once.
If array [mid] = 1, then no swapping is required. Increment mid-pointer once.
If array [mid] = 2, then we swap array [mid] with array [high] and decrement the high pointer once.

TC: O(n)
SC: O(1)
 */


package Array;

import java.util.Arrays;

public class SortColors {

    public static void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int n = nums.length;
        int high = n - 1;

        while(mid <= high){
            switch (nums[mid]){
                case 0:
                    int temp1 = nums[low];
                    nums[low] = nums[mid];
                    nums[mid] = temp1;
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    int temp2 = nums[mid];
                    nums[mid] = nums[high];
                    nums[high] = temp2;
                    high--;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,0,1};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
}
