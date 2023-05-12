package task_2;
import java.util.HashSet;

	public class CheckArrays {

	    public static void main(String[] args) {
	        int[] arr1 = {1, 2, 3, 4, 5};
	        int[] arr2 = {5, 7, 3, 2, 1};
	        
	        boolean result = checkSameSet(arr1, arr2);
	        
	        System.out.println(result);
	    }
	    
	    public static boolean checkSameSet(int[] arr1, int[] arr2) {
	        HashSet<Integer> set1 = new HashSet<Integer>();
	        HashSet<Integer> set2 = new HashSet<Integer>();
	        
	        for (int i = 0; i < arr1.length; i++) {
	            set1.add(arr1[i]);
	        }
	        
	        for (int i = 0; i < arr2.length; i++) {
	            set2.add(arr2[i]);
	        }
	        
	        return set1.equals(set2);
	    }
	}



