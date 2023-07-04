package array;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public static int eraseOverlapIntervals(int[][] nums) {
        int n = nums.length;
        Arrays.sort(nums, Comparator.comparingDouble(o -> o[1]));
        int last = nums[0][1];
        int count = 1;
        for(int i = 1; i < n; i++){
            if(nums[i][0] >= last){
                count++;
                last = nums[i][1];
            }
        }
        return n - count;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,2},{2,3},{3,4},{1,3}};
        int result = eraseOverlapIntervals(nums);
        System.out.println(result);
    }
}
