package backjoon.backTracking;

public class Combination {
	public static void main(String[] ar) {
		Combination ex = new Combination();
		int[] arr = {1,2,3};
		int n = arr.length;
		int r = 2;
		int[] combArr = new int[n];

		ex.doCombination(combArr, n, r, 0, 0, arr); // n = 3, r = 2
	}

	public void doCombination(int[] combArr, int n, int r, int index, int target, int[] arr) {
//		System.out.println("=> " + n + " " + r + " " + index + " " + target);

		// r ==0 이란 것은 뽑을 원소를 다 뽑았다는 뜻.
		if (r == 0) {
//			System.out.println(Arrays.toString(combArr));
			for (int i = 0; i < index; i++)
				System.out.print(arr[combArr[i]] + " ");

			System.out.println();

		} else if (target == n) {

			return;

		} else {
			combArr[index] = target;
			doCombination(combArr, n, r - 1, index + 1, target + 1, arr);

			doCombination(combArr, n, r, index, target + 1, arr);
		}
	}
}