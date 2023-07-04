/*
Given an array of intervals where intervals[i] = [starti, endi],
return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

https://leetcode.com/problems/non-overlapping-intervals/description/

Approach
So first array is not null so there will be always one solution.
Now sort the 2nd column of this array to apply greedy approach.
to sort 2nd column lets use Comparator.
Arrays.sort(nums, Comparator.comparingDouble(o -> o[1]));
o[1] denotes 2nd column to be sorted.
now check for valid intervals. if nextStart >= prevLast then it is valid.
So, we are incrementing count and assign prevLast to newLast.

TC: O(n)
SC: O(1)
 */


package array;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public static int eraseOverlapIntervals(int[][] nums) {
        int n = nums.length;
        Arrays.sort(nums, Comparator.comparingDouble(o -> o[1]));
        int last = nums[0][1];
        int count = 1;
        for(int i = 1; i < n; i++){
            if(nums[i][0] >= last){
                count++;
                last = nums[i][1];
            }
        }
        return n - count;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,2},{2,3},{3,4},{1,3}};
        int result = eraseOverlapIntervals(nums);
        System.out.println(result);
    }
}
