package algorithmSkills.sorting;

import java.util.Arrays;

/**
 *
 * 핵심
 * - divideArray호출이 종료되는 시점에서 두 인덱스(left / right)가 만나는 지점은 정렬된 배열에서 정확히 그 위치를 찾은 지점이다.
 * - 그렇기 때문에 그 기준으로 나눠서 재귀 호출을 통해 divide and conquer를 하는 것이다.
 * - 위의 설명을 이해시키기 위한 방법을 생각해 봐야한다.
 *
 * swap의 의미
 * - 둘다 값을 찾았을 때 : pivot값 기준으로 큰 값 / 작은 값을 정렬 한것
 * - pivot과 교체할 때
 * 		- left만 찾았을 때 : pivot보다 큰 값을 정렬한 것
 * 	 	- right만 찾았을 때 : pivot보다 작은 값을 정렬한 것	
 * 
 */

public class QuickSort {
	
	
	// 출처 & 설명 : https://palpit.tistory.com/126

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

			// left 이동(pivot인덱스 값 이상인 값을 찾을 때까지)
			while ((arr[left] < pivotValue) && (left < right))
				left++;

			//right 이동(pivot 인덱스 값 미만인 값을 찾을 때까지)
			while ((arr[right] >= pivotValue) && (left < right))
				right--;

			// 둘다 값을 찾았으면
			if (left < right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
		}

		// 만났으면(2 가지 경우)
		// 1. 둘 중 하나만 찾고
		// 2. pivot에서 만나고 (swap하면 안된다.)
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
