package task7;
import java.util.*;
public class HeapSort {
	 public static void heapSort(int[] arr) {
	        int n = arr.length;

	        // Build the min heap
	        for (int i = n / 2 - 1; i >= 0; i--)
	            heapify(arr, n, i);

	        // Extract elements from the heap in sorted order
	        for (int i = n - 1; i >= 0; i--) {
	            int temp = arr[0];
	            arr[0] = arr[i];
	            arr[i] = temp;

	            heapify(arr, i, 0);
	        }
	    }

	    public static void heapify(int[] arr, int n, int i) {
	        int smallest = i;
	        int leftChild = 2 * i + 1;
	        int rightChild = 2 * i + 2;

	        if (leftChild < n && arr[leftChild] < arr[smallest])
	            smallest = leftChild;

	        if (rightChild < n && arr[rightChild] < arr[smallest])
	            smallest = rightChild;

	        if (smallest != i) {
	            int temp = arr[i];
	            arr[i] = arr[smallest];
	            arr[smallest] = temp;

	            heapify(arr, n, smallest);
	        }
	    }

	    public static void main(String[] args) {
	        int[] arr = {9, 5, 7, 2, 1, 8, 4, 6, 3};

	        heapSort(arr);

	        System.out.println(Arrays.toString(arr));
	    }
	}

