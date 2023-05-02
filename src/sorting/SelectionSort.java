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
