/*
Given a binary array nums, return the maximum number of consecutive 1's in the array.
https://leetcode.com/problems/max-consecutive-ones/description/

TC: O(n)
SC: O(1)
 */

package array;

public class MaxConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int result = 0, count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++){
            if (nums[i] == 1){
                count++;
                if (count > result){
                    result = count;
                }
            }else{
                count = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,0,1,1,1};
        int result = findMaxConsecutiveOnes(arr);
        System.out.println(result);
    }
}
