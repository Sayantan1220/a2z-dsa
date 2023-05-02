/*
Given an unsorted array of size N, use selection sort to sort arr[] in increasing order.

1. We will select the range of the unsorted array using a loop (say i) that indicates the starting index of the range.
2. The loop will run forward from 0 to n-1. The value i = 0 means the range is from 0 to n-1, and similarly, i = 1 means the range is from 1 to n-1, and so on.
(Initially, the range will be the whole array starting from the first index.)
3. In each iteration, we will select the minimum element from the range of the unsorted array using an inner loop.
4. We will swap the minimum element with the first element of the selected range(in step 1).
5. After each iteration, we will find that the array is sorted up to the first index of the range.

TC: O(n2)
SC: O(1)
 */

package sorting;

public class SelectionSort {

    static void selectionSort(int[] arr, int n)
    {
        //code here
        for (int i = 0; i < n - 1; i++){
            int min = i;
            for (int j = i + 1; j < n; j++){
                if (arr[j] < arr[min]){
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    static void printArray(int[] arr, int size){
        for (int i = 0; i < size; i++){
            System.out.println(arr[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 3, 9, 7};
        int size = arr.length;
        printArray(arr, size);
        selectionSort(arr, size);
        printArray(arr, size);
    }
}
