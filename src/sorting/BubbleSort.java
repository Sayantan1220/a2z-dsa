/*
Given an Integer N and a list arr. Sort the array using bubble sort algorithm.
https://practice.geeksforgeeks.org/problems/bubble-sort/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=bubble-sort

1. We will select the range of the unsorted array. For that, we will run a loop(say i) that will signify the last index of the selected range.
The loop will run backward from index n-1 to 0(where n = size of the array).
The value i = n-1 means the range is from 0 to n-1, and similarly, i = n-2 means the range is from 0 to n-2, and so on.
2. Within the loop, we will run another loop(say j, runs from 0 to i-1 though the range is from 0 to i) to push the maximum element to the last index of the selected range, by repeatedly swapping adjacent elements.
3. We will swap adjacent elements(if arr[j] > arr[j+1]) until the maximum element of the range reaches the end.
4. After each iteration, the last part of the array will become sorted.
Like: after the first iteration, the array up to the last index will be sorted, and after the second iteration, the array up to the second last index will be sorted, and so on.
After (n-1) iteration, the whole array will be sorted.

TC: O(n2)
SC: O(1)
 */

package sorting;

public class BubbleSort {

    public static void bubbleSort(int[] arr, int n)
    {
        //code here
        for (int i = n-1; i>= 0; i--){
            for (int j = 0; j<=i-1; j++){
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
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
        bubbleSort(arr, size);
        printArray(arr, size);
    }

}
