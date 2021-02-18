package backjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5622 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder input = new StringBuilder(br.readLine());
		int alphaToAscii;
		int totalTime = 0;
		
		for(int i = 0; i < input.length(); i++) {
			alphaToAscii = (char)input.charAt(i);
			
			if(alphaToAscii>=65 && alphaToAscii<=67) {
				totalTime += 3;
			} else if(alphaToAscii <= 70) {
				totalTime += 4;
			} else if(alphaToAscii <= 73) {
				totalTime += 5;
			} else if(alphaToAscii <= 76) {
				totalTime += 6;
			} else if(alphaToAscii <= 79) {
				totalTime += 7;
			} else if(alphaToAscii <= 83) {
				totalTime += 8;
			} else if(alphaToAscii <= 86) {
				totalTime += 9;
			} else if(alphaToAscii <= 90) {
				totalTime += 10;
			}
		}
		System.out.println(totalTime);
	}
}
