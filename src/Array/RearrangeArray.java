package Array;

import java.util.ArrayList;
import java.util.Arrays;

public class RearrangeArray {

    public static int[] rearrangeArray(int[] nums) {
        int[] list = new int[nums.length];
        int positiveIndex = 0;
        int negativeIndex = 1;

        for (int i = 0; i < nums.length; i++){
            if (nums[i] > 0){
                list[positiveIndex] = nums[i];
                positiveIndex+=2;
            }
            else if (nums[i] < 0){
                list[negativeIndex] = nums[i];
                negativeIndex+=2;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {3,1,-2,-5,2,-4};
        int[] result = rearrangeArray(arr);
        System.out.println(Arrays.toString(result));
    }

}
