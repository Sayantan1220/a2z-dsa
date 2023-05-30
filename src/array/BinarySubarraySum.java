package array;

import java.util.HashMap;
import java.util.Map;

public class BinarySubarraySum {

    public int numSubarraysWithSum(int[] nums, int target) {
        Map<Integer, Integer> presum = new HashMap<>();
        int sum = 0;
        int total = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            if (presum.get(sum - target) != null){
                total += presum.get(sum - target);
            }
            if (sum == target) total++;
            //Also put this sum into the map as well
            presum.put(sum, presum.getOrDefault(sum, 0) + 1);
        }
        return total;
    }
}
