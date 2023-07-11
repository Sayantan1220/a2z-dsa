/*
You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
Each element nums[i] represents the maximum length of a forward jump from index i. In other words,
if you are at nums[i], you can jump to any nums[i + j] where:
0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
https://leetcode.com/problems/jump-game-ii/description/

Approach:
The main idea is based on greedy.
Let's say the range of the current jump is [curBegin, curEnd],
curFarthest is the farthest point that all points in [curBegin, curEnd] can reach.
Once the current point reaches curEnd, then trigger another jump,
and set the new curEnd with curFarthest, then keep the above steps

TC:O(N)
SC:O(1)
 */

package array;

public class JumpGameII {
    public static int jump(int[] nums) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        int[] bills = {2,3,1,1,4};
        int result = jump(bills);
        System.out.println(result);
    }
}
