package labs;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class countingSort {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);  
		System.out.println("Enter the upper bound: ");
		int k = reader.nextInt();
	
		System.out.println("Enter the number of integers: ");
		int n = reader.nextInt();
		
		int[] countingArray = new int[n - 1];
		createArray(countingArray, k);
		
		System.out.println("Array before Counting Sort: ");
		printArray(countingArray);
		System.out.println();
		
		System.out.println();
		System.out.println("Array after Counting sort: ");
		countingSort(countingArray, 0, k);
		printArray(countingArray);

	}	
	public static void createArray(int[] arr, int upper){
		for(int i = 0; i < arr.length; i++){
		    
			if(i == 0){
				arr[i] = upper;
				continue;
			}
			
			Random rand = new Random();
		    int randomNum = rand.nextInt((upper) + 1);
		    arr[i] = randomNum;

	
		}
	}
	

	public static void countingSort(int[] array, int low, int high){
		int count[] = new int[high - low + 1];
		
		for(int i : array){
			count[i - low]++;
		}
		int current = 0;
		
		for(int i = 0; i < count.length; i++){
			Arrays.fill(array, current, current + count[i], i + low);
			current += count[i];
		}
	}
	
	public static void printArray(int[] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
	}
}
