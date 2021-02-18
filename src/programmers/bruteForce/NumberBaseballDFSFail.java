package programmers.bruteForce;

import java.util.ArrayList;
import java.util.List;

public class NumberBaseballDFSFail {
	
	static List<int[]> caseList;
	

	public static void main(String[] args) {
		
		
//		int[] source = {1,2,3};
//
//		int[] selectedIndices = new int[source.length];
//		caseList = new ArrayList<>();
//		
//		doCombination(source, source.length, 1, selectedIndices, 0,0, false);

		int[][] baseball = {{123,1,1}};
		solution(baseball);
			

	}

	public static int solution(int[][] baseball) {
        int answer = 0;
        
		int[] source = {1,2,3};

		int[] selectedIndices = new int[source.length];
        
        caseList = new ArrayList<>();
        
        doCombination(source, source.length, 1, selectedIndices, 0, 0, false);
        
		for(int ci = 0; ci < caseList.size(); ci++) {
			
			for(int ai = 0; ai < caseList.get(ci).length; ai++) {
				
				System.out.print(caseList.get(ci)[ai] + " ");
				
			}
			System.out.println();
			
		}
        
        return answer;
    }

	public static void doCombination(int[] source, int n, int r, int[] selectedIndices, int selectedIndex, int target, boolean zeroFlag) {
		
		if(r == 0) {
			
			if(!zeroFlag) {
				
				int[] oneOfCase = new int[3];
				
				for(int si = 0; si < selectedIndex; si++) {
					
//					System.out.println(source[selectedIndices[si]]);
					oneOfCase[selectedIndices[si]] = source[selectedIndices[si]];
					
				}
				
//				System.out.println("-----------");
				caseList.add(oneOfCase);

			} else {
				
				
				
			}
			
		} else if(target == n) {
			return;
		} else {
			
			selectedIndices[selectedIndex] = target;
			
			doCombination(source, n, r-1, selectedIndices, selectedIndex+1, target+1, zeroFlag);
			
			doCombination(source, n, r, selectedIndices, selectedIndex, target+1, zeroFlag);
			
			
		}
	}
	
	public static void doPermutation(int[] source, int n, int r, int[] selectedIndices, int selectedIndex, boolean[] visited, boolean zeroFlag) {
		
		if(r == selectedIndex) {
			
			if(!zeroFlag) {
				
			} else {
				
				// check appliable
				
				for(int si = 0; si < selectedIndex; si++) {
					
				}
				
				
			}
			
		} else {
			
			for(int vi = 0; vi < visited.length; vi++) {
				if(!visited[vi]) {
					visited[vi] = true;
					selectedIndices[selectedIndex] = vi;
					doPermutation(source, n, r, selectedIndices, selectedIndex+1, visited, zeroFlag);
					visited[vi] = false;
					selectedIndices[selectedIndex] = 0;
				}
			}
		}
		
	}
	

}
