package algorithmSkills;

public class QuickSort {
	
	
	// 출처 & 설명 : https://palpit.tistory.com/126

	public static void main(String[] args) {
		
		
		int[] arrs = { 69, 10, 30, 2, 16, 8, 31, 22 };
		quickSort(arrs, 0, arrs.length - 1);
		System.out.println("결과");

		for (int i : arrs) {
			System.out.print(i + " ");
		}


	}

	public static int partition(int[] arr, int left, int right) {

		int pivot = arr[(left + right) / 2];
		while (left < right) {
			while ((arr[left] < pivot) && (left < right))
				left++;
			while ((arr[right] > pivot) && (left < right))
				right--;

			if (left < right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
		}
		return left;
	}
	
	public static void quickSort(int[] arr, int left, int right) {
		
		
		if(left < right) {
			int newPivotIndex = partition(arr, left, right);
			
			quickSort(arr, left, newPivotIndex-1);
			quickSort(arr, newPivotIndex + 1, right);
		}
		
	}

}
