package Array;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;
        int n = nums.length;
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int moreNeeded = target - num;
            if (mpp.containsKey(moreNeeded)) {
                ans[0] = mpp.get(moreNeeded);
                ans[1] = i;
                return ans;
            }

            mpp.put(nums[i], i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int target = 9;
        int[] result = twoSum(arr, target);
        System.out.println(Arrays.toString(result));
    }
}
