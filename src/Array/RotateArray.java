package Array;

public class RotateArray {

    public static void rotate(int[] nums, int n, int k) {
        if (k == 0) return;
        k = k%n;
        reverse (nums,0,n-1);
        reverse (nums,0,k-1);
        reverse (nums,k,n-1);
    }

    public static void reverse(int[] nums, int start, int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    static void printArray(int[] arr, int size){
        for (int i = 0; i < size; i++){
            System.out.println(arr[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int size = arr.length;
        int k = 3;
        printArray(arr, size);
        rotate(arr, size, k);
        printArray(arr, size);
    }
}