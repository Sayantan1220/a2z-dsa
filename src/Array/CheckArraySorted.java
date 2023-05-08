/*
Check if array is sorted
https://practice.geeksforgeeks.org/problems/check-if-an-array-is-sorted0701/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=check-if-an-array-is-sorted

TC: O(n)
SC: O(1)
 */


package Array;

public class CheckArraySorted {

    static boolean arraySortedOrNot(int[] arr, int n) {
        // code here
        for (int i = 0; i < n - 1; i++){
            if (arr[i] > arr[i+1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1, 8, 87, 56, 90};
        int size = arr.length;
        boolean result = arraySortedOrNot(arr, size);
        System.out.println(result);
    }
}
