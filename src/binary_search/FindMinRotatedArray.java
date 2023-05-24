package binary_search;

public class FindMinRotatedArray {
    public static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high){
            int mid = low + (high - low)/2;
            if (nums[mid] > nums[high]){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};
        int result = findMin(arr);
        System.out.println(result);
    }
}
