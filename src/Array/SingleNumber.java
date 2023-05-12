package Array;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

    public static int singleNumber(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < n; i++){
            int value = counts.getOrDefault(nums[i], 0);
            counts.put(nums[i], value+1);
        }

        for (Map.Entry<Integer, Integer> value : counts.entrySet()){
            if (value.getValue() == 1){
                return value.getKey();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4,1,2,1,2};
        int result = singleNumber(arr);
        System.out.println(result);
    }
}
