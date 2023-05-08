package Array;

public class RemoveDuplicateElementSortedArray {

    static int remove_duplicate(int[] arr, int N){
        // code here
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        int size = arr.length;
        int result = remove_duplicate(arr, size);
        System.out.println(result);
    }
}
