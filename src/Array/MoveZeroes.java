/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.
https://leetcode.com/problems/move-zeroes/

TC: O(n)
SC: O(1)
 */

package Array;

public class MoveZeroes {

    public static void zerosToEnd(int[] arr, int n) {

        //finding first zero occurrence
        int k = 0;
        while (k < n) {
            if (arr[k] == 0) {
                break;
            } else {
                k = k + 1;
            }
        }

        //finding zeros and immediate non-zero elements and swapping them
        int i = k;
        int j = k + 1;
        while (i < n && j < n) {
            if (arr[j] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
            j++;
        }
    }

    static void printArray(int[] arr, int size){
        for (int i = 0; i < size; i++){
            System.out.println(arr[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        int size = arr.length;
        printArray(arr, size);
        zerosToEnd(arr, size);
        printArray(arr, size);
    }
}
