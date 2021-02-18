package algorithmSkills;

public class Permutation {
	
	public static void main(String[] args) {
		
		int[] source = {1,2,3,4,5};
		int[] selectedIndices = new int[source.length];
		boolean[] visited = new boolean[source.length];
		
		doPermutation(source, source.length, 3, selectedIndices, 0, visited);
		
	}
	
	
	// other method name : searchAllRoute, searchAllCases
	
	public static void doPermutation(int[] source, int n, int r, int[] selectedIndices, int selectedIndex,
			boolean[] visited) {

//		if (r == selectedIndex) {
		if(r == 0){
			StringBuilder permuStr = new StringBuilder();
			for (int si = 0; si < selectedIndex; si++) {
				permuStr.append(source[selectedIndices[si]]);
			}
			System.out.println(permuStr);
			return;
		}
		
		for (int vi = 0; vi < n; vi++) {
			if (!visited[vi]) {
				visited[vi] = true;
				selectedIndices[selectedIndex] = vi;
//				doPermutation(source, n, r , selectedIndices, selectedIndex + 1, visited);
				doPermutation(source, n, r - 1, selectedIndices, selectedIndex + 1, visited);
				visited[vi] = false;
				selectedIndices[selectedIndex] = -1;
			}
		}
	}
}