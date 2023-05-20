/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.

Approach : Use Xor function
XOR of two same numbers is always 0 i.e. a ^ a = 0.
XOR of a number with 0 will result in the number itself i.e. 0 ^ a = a.
So all the pair numbers will result in 0 and the single number with 0 xor will be that number only. That will be the result.

TC: O(n)
SC: O(1)
 */

package array;

public class SingleNumber {

    public static int singleNumber(int[] nums) {
        int n = nums.length;
        int xorr = 0;
        for (int i = 0; i < n; i++){
            xorr = xorr ^ nums[i];
        }
        return xorr;
    }

    public static void main(String[] args) {
        int[] arr = {4,1,2,1,2};
        int result = singleNumber(arr);
        System.out.println(result);
    }
}
