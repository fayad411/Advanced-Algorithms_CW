package task_1;

import java.util.Arrays;

public class RemoveDuplicates {
	 public static void main(String[] args) {
	        char[] arr = {'a', 'b', 'c', 'c', 'd', 'd', 'f', 'f', 'a', 'e', 'e'};
	        char[] result = removeDuplicates(arr);
	        System.out.println(Arrays.toString(result));
	    }

	    public static char[] removeDuplicates(char[] arr) {
	        if (arr == null || arr.length == 0) {
	            return arr;
	        }
	        int n = arr.length;
	        int tail = 1;
	        for (int i = 1; i < n; i++) {
	            int j;
	            for (j = 0; j < tail; j++) { 
	                if (arr[i] == arr[j]) {
	                    break;
	                }
	            }
	            if (j == tail) {
	                arr[tail] = arr[i];
	                tail++;
	            }
	        }
	        return Arrays.copyOfRange(arr, 0, tail);
	    }
	}




