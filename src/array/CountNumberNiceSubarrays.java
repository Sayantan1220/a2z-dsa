/*
Given an array of integers nums and an integer k.
A continuous subarray is called nice if there are k odd numbers on it.
Return the number of nice sub-arrays.
https://leetcode.com/problems/count-number-of-nice-subarrays/description/

TC: O(n)
SC: O(1)
 */

package array;

public class CountNumberNiceSubarrays {

    public static int numberOfSubArrays(int[] nums, int k) {
        int i=0;
        int j=0;
        int oddCount=0;
        int ans=0;
        int count=0;

        while(j<nums.length){

            if(nums[j]%2!=0){
                oddCount++;
                ans=0;
            }
            while(oddCount==k){
                ans++;
                if(nums[i]%2!=0){
                    oddCount--;
                }
                i++;
            }
            count+=ans;
            j++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,1,2,2,1,2,2,2};
        int result = numberOfSubArrays(arr, 3);
        System.out.println(result);
    }
}
