package backjoon.DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q6603 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		
		while (true) {
			
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			if (n == 0) {
				break;
			}
			
			int[] numbers = new int[n];
			int[] selectedIndices = new int[6];
			for (int i = 0; i < n; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}	
			
			selectNumber(numbers, selectedIndices, 0,0);
			System.out.println();
		}

	}
	
	
	public static void selectNumber(int[] numbers, int[] selectedIndices, int selectedIndex, int nextIndex) {
		
		if(selectedIndex == selectedIndices.length) {
			for(int selectedI = 0; selectedI < selectedIndices.length-1;selectedI++) {
				System.out.print(selectedIndices[selectedI] + " ");
			}
			System.out.println(selectedIndices[selectedIndices.length-1]);
			return;
		}
		
		for(int numbersI = nextIndex; numbersI < numbers.length; numbersI++) {
			selectedIndices[selectedIndex] = numbers[numbersI];
			selectNumber(numbers, selectedIndices, selectedIndex+1, numbersI+1);
			
		}
	}
	

}
