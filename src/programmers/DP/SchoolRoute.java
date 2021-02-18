package programmers.DP;

public class SchoolRoute {

	public static void main(String[] args) {

		int m = 4;
		int n = 3;
		int[][] puddles = { { 2, 1 } };

		
//		int m = 100;
//		int n = 100;
//		int[][] puddles = {};


		System.out.println(solution(m, n, puddles));

	}

	public static int solution(int m, int n, int[][] puddles) {

		long[][] field = new long[n][m];

		for (int puddlesI = 0; puddlesI < puddles.length; puddlesI++) {

			field[puddles[puddlesI][1] - 1][puddles[puddlesI][0] - 1] = -1;

		}

		for (int fieldI = 0; fieldI < field.length; fieldI++) {

			if (field[fieldI][0] == -1)
				break;
			else {
				field[fieldI][0] = 1;
			}

		}

		for (int fieldI = 0; fieldI < field[0].length; fieldI++) {

			if (field[0][fieldI] == -1)
				break;
			else {
				field[0][fieldI] = 1;
			}
		}

		for (int fieldI = 1; fieldI < field.length; fieldI++) {
			for (int fieldJ = 1; fieldJ < field[fieldI].length; fieldJ++) {

				if (field[fieldI][fieldJ] == 0) {

					if (field[fieldI - 1][fieldJ] > 0)
						field[fieldI][fieldJ] += field[fieldI - 1][fieldJ] % 1000000007;
					
					if(field[fieldI][fieldJ-1] > 0) 
						field[fieldI][fieldJ] += field[fieldI][fieldJ-1] % 1000000007;
					
				}
			}
		}

		return (int)(field[n-1][m-1] % 1000000007);
	}

}
