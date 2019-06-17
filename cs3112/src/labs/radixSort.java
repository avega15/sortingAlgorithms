package labs;

public class radixSort {

	public static void main(String[] args) {
		int[] array = {10, 6, 8, 3, 80, 55, 43, 85};
		
		System.out.println("Array before Radix Sorting: ");
		printArray(array);
		System.out.println();
		
		System.out.println();
		System.out.println("Array after Radix Sorting: ");
		radixSort(array);
		printArray(array);

	}
	
	public static void printArray(int[] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void radixSort(int[] arr){
		int m = arr[0];
		int exp = 1;
		int[] b = new int[10];
		
		for(int i = 1; i < arr.length; i++){
			if(arr[i] > m){
				m = arr[i];
			}
		}
	
		while(m / exp > 0){
			int[] bucket = new int[10];
			
			for(int i = 0; i < arr.length; i++){
				bucket[(arr[i] / exp) % 10]++;
			}
			
			for(int i = 1; i < 10; i++){
				bucket[1] += bucket[i - 1];
			}
			
			for(int i = arr.length - 1; i >= 0; i--){
				b[--bucket[(arr[i] / exp) % 10]] = arr[i];
			}
			
			for(int i = 0; i < arr.length; i++){
				arr[i] = b[i];
			}
			exp *= 10;
		}
	}
}