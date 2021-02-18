package algorithmSkills;

public class Combination {

	public static void main(String[] args) {

		Combination ex = new Combination();
		int[] source = { 1, 2, 3, 4, 5 };
		int n = source.length;
		int r = 2;
		int[] selectedIndice = new int[r];

//		ex.doCombination(source, n, r, selectedIndice, 0, 0);  // n = 5, r = 2
		
		System.out.println(computeCombiValue(4,2));
		
	}
	
	// combination using for loop
	
	public static void selectNumber(int[] source, int[] selectedIndices, int selectedIndex, int nextIndex) {
		
		if(selectedIndex == selectedIndices.length) {
			for(int selectedI = 0; selectedI < selectedIndices.length-1;selectedI++) {
				System.out.print(selectedIndices[selectedI] + " ");
			}
			System.out.println(selectedIndices[selectedIndices.length-1]);
			return;
		}
		
		for(int numbersI = nextIndex; numbersI < source.length; numbersI++) {
			selectedIndices[selectedIndex] = source[numbersI];
			selectNumber(source, selectedIndices, selectedIndex+1, numbersI+1);
			
		}
	}

	
	// other method name : searchAllRoute, searchAllCases
	
	public void doCombination(int[] source, int n, int r, int[] selectedIndices, int selectedIndex, int targetIndex) {

		if (r == 0) {
			
			for (int si = 0; si < selectedIndex; si++) {
				System.out.print(source[selectedIndices[si]] + " ");
				
			}

		} else if (targetIndex == n) {
			return;

		} else {
			selectedIndices[selectedIndex] = targetIndex;

			doCombination(source, n, r - 1, selectedIndices, selectedIndex + 1, targetIndex + 1);

			doCombination(source, n, r, selectedIndices, selectedIndex, targetIndex + 1);
		}
	}
	
	
	public static int computeCombiValue(int n, int r) {
		
		int answer = computePactorial(n) / (computePactorial(r) * computePactorial(n-r));
		
		return answer;
	}
	
	public static int computePactorial(int n) {
		
		if(n == 1)
			return 1;
		else
			return computePactorial(n-1) * n;
		
		
	}
	
	public static int computePermuValue(int n, int r) {
		
		int answer = computePactorial(n) / computePactorial(n-r);
		
		return answer;
		
	}
}