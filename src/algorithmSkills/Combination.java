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

	// combination using for loop 1(DFS처럼 탐색한다.(자식으로 재귀로 들어가서 탐색))

	// nextIndex 없이 모든 loop를 0부터 하면 순열로 사용할 수 있다.

	public void selectIndices(String[] source, int nextIndex, int numSelected, int targetNumSelected) {

		if(numSelected == targetNumSelected) {

			StringBuilder condition = new StringBuilder();

			for (int sourceI = 0; sourceI < source.length - 1; sourceI++) {
				condition.append(source[sourceI]);
			}

			return;
		}


		for(int sourceI = nextIndex; sourceI < source.length-1; sourceI++) {
			String currentCondition = source[sourceI];
			source[sourceI] = "-";
			selectIndices(source, sourceI+1, numSelected + 1, targetNumSelected);
			source[sourceI] = currentCondition;
		}

	}

	// BFS처럼 탐색한다.(1개 전부 탐색 ~ n개 전부 탐색)
	// 너무 비효율 적이다. 10C5하고 10C6을 하면 10C6에서 10C5까지의 연산을 한 번 더 하면서 하나를 더 뽑는 것이기 때문에 굉장히 비효율 적이다.
	// 그냥 위의 반복문 코드를 사용하는게 낫다.
	// 필요에 따라 사용하면 된다.(최솟값을 찾는 경우 유용)

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
	
	// combination using for loop 2
	
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