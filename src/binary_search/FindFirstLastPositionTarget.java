package binary_search;

import java.util.Arrays;

public class FindFirstLastPositionTarget {

    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int low = 0;
        int high = nums.length - 1;
        int mid;

        // First Occurrence
        while (low <= high) {
            mid = low + (high - low)/2;
            if (target == nums[mid]) {
                result[0] = mid;
                high = mid - 1;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            }
        }
        // Last Occurrence
        low = 0;
        high = nums.length - 1;
        while (low <= high) {
            mid = low + (high - low)/2;
            if (target == nums[mid]) {
                result[1] = mid;
                low = mid + 1;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        int[] result = searchRange(arr, 8);
        System.out.println(Arrays.toString(result));
    }
}
