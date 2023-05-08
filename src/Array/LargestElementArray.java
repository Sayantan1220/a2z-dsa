package Array;

public class LargestElementArray {

    public static int largestElement(int arr[], int n)
    {
        int max = 0;
        for (int i = 0; i < n; i++){
            if (arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    static void printArray(int[] arr, int size){
        for (int i = 0; i < size; i++){
            System.out.println(arr[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 8, 7, 56, 90};
        int size = arr.length;
        int result = largestElement(arr, size);
        System.out.println(result);
    }
}
