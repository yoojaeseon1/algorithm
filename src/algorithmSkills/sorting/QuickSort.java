package algorithmSkills.sorting;

import java.util.Arrays;

public class QuickSort {
	
	
	// ��ó & ���� : https://palpit.tistory.com/126

	public static void main(String[] args) {

		QuickSort quickSort = new QuickSort();
		
		int[] numbers = { 69, 10, 30, 2, 16, 8, 31, 22 };


		quickSort.sortArray(numbers, 0, numbers.length - 1);

		System.out.println(Arrays.toString(numbers));


	}

	public int divideArray(int[] arr, int left, int right) {

		int pivot = (left + right) / 2;
		int pivotValue = arr[pivot];

		while (left < right) {

			// left �̵�(pivot�ε��� �� �̻��� ���� ã�� ������)
			while ((arr[left] < pivotValue) && (left < right))
				left++;

			//right �̵�(pivot �ε��� �� �̸��� ���� ã�� ������)
			while ((arr[right] >= pivotValue) && (left < right))
				right--;

			// �Ѵ� ���� ã������
			if (left < right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
		}

		// ��������(2 ���� ���)
		// 1. �� �� �ϳ��� ã��
		// 2. pivot���� ������ (swap�ϸ� �ȵȴ�.)
		if(pivotValue != arr[left]) {
			arr[pivot] = arr[left];
			arr[left] = pivotValue;
		}


		return left;
	}
	
	public void sortArray(int[] arr, int left, int right) {
		
		
		if(left < right) {
			int newPivotIndex = divideArray(arr, left, right);

			sortArray(arr, left, newPivotIndex-1);
			sortArray(arr, newPivotIndex + 1, right);
		}
		
	}

}
