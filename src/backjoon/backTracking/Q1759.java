package backjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1759 {
	
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char[] arr = new char[C];
		int[] combArr = new int[C];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(arr);
		
		doCombination(combArr, C, L, 0, 0, arr);
		
	}
	
	public static void doCombination(int[] combArr, int n, int r, int index, int target, char[] arr) {
		
		
		if(r == 0) {
			int vowelCount = 0;
			int consonantCnt = 0;
			
			for(int i = 0; i < index; i++) {
				if(arr[combArr[i]] == 'a' || arr[combArr[i]] == 'e' || arr[combArr[i]] == 'i' || arr[combArr[i]] == 'o' || arr[combArr[i]] == 'u') {
					vowelCount++;
				} else {
					consonantCnt++;
				}
			}
			
			if(vowelCount >= 1 && consonantCnt >= 2) {
				for(int i = 0; i < index; i++) {
					System.out.print(arr[combArr[i]]);
				}
				System.out.println();
			}
			
			
		} else if(target == n){
			
			return;
			
		} else {
			
			combArr[index] = target;
			
			doCombination(combArr, n, r - 1, index+1, target+1, arr);
			
			doCombination(combArr, n, r, index, target+1, arr);
			
		}
		
	}
}