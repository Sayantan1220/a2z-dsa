/*
Given a binary array nums and an integer k,
return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
https://leetcode.com/problems/max-consecutive-ones-iii/description/

TC: O(n)
SC: O(1)
 */

package array;

public class MaxConsecutiveOnesIII {

    public static int longestOnes(int[] nums, int k) {
        int i=0;
        int j=0;
        int zeroCount=0;
        int max=Integer.MIN_VALUE;
        while(j<nums.length){
            if(nums[j]==0){
                zeroCount++;
            }
            while(zeroCount>k && i<=j){
                if(nums[i]==0){
                    zeroCount--;
                }
                i++;
            }
            max=Math.max(max,j-i+1);
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int result = longestOnes(arr, 3);
        System.out.println(result);
    }
}
