package backjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10808 {
	
public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder s = new StringBuilder(br.readLine());
		
		int[] countAlpha = new int[26];
		
		for(int i = 0; i < s.length(); i++) {
			countAlpha[(int)s.charAt(i) - 97]++;
		}
		
		for(int i = 0; i < countAlpha.length; i++) {
			System.out.print(countAlpha[i] + " ");
		}
	}

}
