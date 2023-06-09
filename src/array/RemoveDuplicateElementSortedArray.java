/*
Remove duplicate elements from sorted Array
https://practice.geeksforgeeks.org/problems/remove-duplicate-elements-from-sorted-array/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=remove-duplicate-elements-from-sorted-array

TC: O(n)
SC: O(1)
 */

package array;

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
