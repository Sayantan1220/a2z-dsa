/*
You are given an integer array nums.
You are initially positioned at the array's first index,
and each element in the array represents your maximum jump length at that position.
Return true if you can reach the last index, or false otherwise.
https://leetcode.com/problems/jump-game/description/

Approach
Initialize the variable last as the index of the last element in the array (nums.length - 1).
Initialize the variable maxReach as 0, representing the maximum index we can currently reach from the starting position.
Iterate through the array nums from left to right using the loop variable i.
Update maxReach using the expression Math.max(maxReach, i + nums[i]).
This calculates the maximum index we can reach by taking a jump from the current position i.
If maxReach ever reaches or exceeds the last index, return true as we can reach the end.
If the loop finishes without returning true, it means we cannot reach the last index. In this case, return false.
Complexity

TC:O(N)
SC:O(1)
 */

package array;

public class JumpGame {
    public static boolean canJump(int[] nums) {
        int last = nums.length - 1;
        int maxReach = 0; // Maximum index we can reach

        for (int i = 0; i <= maxReach; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= last) {
                return true; // We can reach the last index
            }
        }
        return false; // Cannot reach the last index
    }

    public static void main(String[] args) {
        int[] bills = {2,3,1,1,4};
        boolean result = canJump(bills);
        System.out.println(result);
    }
}
