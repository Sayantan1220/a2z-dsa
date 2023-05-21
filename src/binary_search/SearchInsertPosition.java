package binary_search;

public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int mid = 0;
        int high = nums.length-1;
        while(low <= high){
            mid = low + (high - low)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){
                low = mid +1;
            }
            else{
                high = mid -1;
            }
        }
        if(target<nums[mid]){
            return mid;
        }
        else{
            return mid +1;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        int result = searchInsert(arr, 2);
        System.out.println(result);
    }
}
