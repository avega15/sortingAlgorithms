package labs;

import java.util.Random;

public class randomizedQuickSort {
	
	public static void main(String[] args) {
	int[] array = {10, 6, 8, 3, 80, 55, 43, 85};
	
	System.out.println("Array before Quick Sorting: ");
	printArray(array);
	System.out.println();
	
	System.out.println();
	System.out.println("Array after Quick Sorting: ");
	quickSort(array, 0, array.length - 1);
	printArray(array);
	
	}
	
	
	public static void quickSort(int arr[], int left, int right){
		int index = partition(arr, left, right);
		
		if(left < index - 1){
			quickSort(arr, left, index - 1);
		}
		if(index < right){
			quickSort(arr, index, right);
		}
	}
	
	public static int partition(int[] arr, int lft, int rght){
		int left = lft;
		int right = rght;
		int temp;
		Random random = new Random();
		
		int pivot = arr[left + random.nextInt(right - left)];
		
		while(left <= right){
			while(arr[left] < pivot){
				left++;
			}
			while(arr[right] > pivot){
				right--;
			}
			if(left <= right){
				temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}
		
		return left;
	}

	public static void printArray(int[] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
	}
}
