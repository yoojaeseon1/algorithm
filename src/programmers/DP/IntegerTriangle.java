package programmers.DP;

public class IntegerTriangle {

	public static void main(String[] args) {

		int[][] triangle = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };

		System.out.println(solution(triangle));

	}

	public static int solution(int[][] triangle) {

		int[][] maxComputeds = new int[triangle.length][];

		maxComputeds[0] = new int[1];

		maxComputeds[0][0] = triangle[0][0];
		
		for (int maxCompI = 1; maxCompI < maxComputeds.length; maxCompI++) {
			
			maxComputeds[maxCompI] = new int[triangle[maxCompI].length];

			maxComputeds[maxCompI][0] = maxComputeds[maxCompI - 1][0] + triangle[maxCompI][0];

			maxComputeds[maxCompI][maxComputeds[maxCompI].length
					- 1] = maxComputeds[maxCompI - 1][maxComputeds[maxCompI - 1].length - 1]
							+ triangle[maxCompI][triangle[maxCompI].length - 1];

			for (int maxCompJ = 1; maxCompJ < maxComputeds[maxCompI].length - 1; maxCompJ++) {

				maxComputeds[maxCompI][maxCompJ] = Math.max(maxComputeds[maxCompI - 1][maxCompJ - 1],
						maxComputeds[maxCompI - 1][maxCompJ]) + triangle[maxCompI][maxCompJ];

			}

		}

		int maxRouteComputed = 0;

		for (int maxCompI = 0; maxCompI < maxComputeds[maxComputeds.length - 1].length; maxCompI++) {

			maxRouteComputed = Math.max(maxRouteComputed, maxComputeds[maxComputeds.length - 1][maxCompI]);

		}
		
		return maxRouteComputed;

	}
}
