package codility.implementation;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {

//		 int[] A = {1,3,6,4,1,2};
//		 int[] A = {1,2,3};
//		 int[] A = {-1,-3};
//		 int[] A = {-1,5};
//		 int[] A = {-3,-1,0,5};
//		 int[] A = {-3,-1,-5,7};
//		 int[] A = {2,3,4};
//		 int[] A = {0,3,4,5,6,7};
//		int[] A = { -3, -5, -10, 1, 2, 3, 4, 5, 6, 7 };
		 int[] A = {-3,-5,-10,1};

		System.out.println(solution(A));

	}

	public static int solution(int[] A) {

		int answer = 0;

		Arrays.sort(A);

		if (A[0] > 1 || A[A.length - 1] <= 0) {
			answer = 1;
			return answer;
		}

		int beforeA = A[0];
		for (int ai = 1; ai < A.length; ai++) {

			int currentA = A[ai];

			if (currentA < 0 || currentA == beforeA || currentA == beforeA + 1)
				beforeA = currentA;
			else if(currentA == 1)
				beforeA = currentA;
			else {
				if (beforeA <= 0)
					answer = 1;
				else
					answer = beforeA + 1;

				break;
			}
		}

		if (answer == 0) 
			answer = A[A.length - 1] + 1;
		

		return answer;

	}

}
