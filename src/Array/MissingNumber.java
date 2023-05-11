/*
Given an array nums containing n distinct numbers in the range [0, n],
return the only number in the range that is missing from the array.
https://leetcode.com/problems/missing-number/description/

Approach : finds the total sum of 0 to n consecutive numbers by formula -> n*(n+1)/2
finds the sum of the array
the difference will be the answer

TC: O(n)
SC: O(1)
 */

package Array;

public class MissingNumber {
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int totalSum = n*(n+1)/2;
        int temp = 0;
        for (int i = 0; i < n; i++){
            temp+=nums[i];
        }
        return totalSum - temp;
    }

    public static void main(String[] args) {
        int[] arr = {9,6,4,2,3,5,7,0,1};
        int result = missingNumber(arr);
        System.out.println(result);
    }
}
