package array;

import java.util.HashMap;
import java.util.Map;

public class SubarraysKDifferentIntegers {

    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostK(A, K) - atMostK(A, K - 1);
    }

    int atMostK(int[] nums, int k) {
        int i = 0, res = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int j = 0; j < nums.length; ++j) {
            if (count.getOrDefault(nums[j], 0) == 0) k--;
            count.put(nums[j], count.getOrDefault(nums[j], 0) + 1);
            while (k < 0) {
                count.put(nums[i], count.get(nums[i]) - 1);
                if (count.get(nums[i]) == 0) k++;
                i++;
            }
            res += j - i + 1;
        }
        return res;
    }
}
