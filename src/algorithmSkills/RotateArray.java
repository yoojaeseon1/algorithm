package algorithmSkills;

public class RotateArray {
	
	// rotate 90 degrees

	public static void main(String[] args) {
		
		int[][] source = { { 0, 0, 0 }, { 1, 0, 0 }, { 0, 1, 1 } };
		
		for(int sourceI = 0; sourceI < source.length; sourceI++) {
			for(int sourceJ = 0; sourceJ < source[sourceI].length; sourceJ++) {
				System.out.print(source[sourceI][sourceJ] + " ");
			}
			System.out.println();
		}
		System.out.println("---------");
		
		int[][] rotated = rotate90Degrees(source);
		
		for(int rotatedI = 0; rotatedI < rotated.length; rotatedI++) {
			for(int rotatedJ = 0; rotatedJ < rotated[rotatedI].length; rotatedJ++) {
				System.out.print(rotated[rotatedI][rotatedJ] + " ");
			}
			System.out.println();
		}
	}
	
	public static int[][] rotate90Degrees(int[][] source) {

		int[][] rotated = new int[source.length][source.length];

		
		// center position initializing
		
		if (source.length % 2 == 1)
			rotated[rotated.length / 2][rotated.length / 2] = source[rotated.length / 2][rotated.length / 2];

		for (int si = 0; si < source.length / 2; si++) {

			// line 1 copy

			int[] copied = new int[source.length - (si * 2)];


			for (int line = si, ci = 0; line < source.length - si; line++, ci++) {
				copied[ci] = source[si][line];
			}

			for (int line = si, ci = 0; line < source.length - si; line++, ci++) {

				rotated[line][source.length - si - 1] = copied[ci];
				copied[ci] = source[line][source.length - si - 1];
			}

			// line 2 paste, line 3 copy

			
			for (int line = source.length - si - 1, ci = 0; line >= si; line--, ci++) {

				rotated[source.length - si - 1][line] = copied[ci];
				copied[ci] = source[source.length - si - 1][line];

			}

			// line 3 paste, line 4 copy

			for (int line = source.length - si - 1, ci = 0; line >= si; line--, ci++) {
				rotated[line][si] = copied[ci];
				copied[ci] = source[line][si];
			}

			// paste line 1

			for (int line = si, ci = 0; line < source.length - si; line++, ci++) {
				rotated[si][line] = copied[ci];
			}
		}

		return rotated;
	}

}
