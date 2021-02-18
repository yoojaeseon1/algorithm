package backjoon.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q9093 {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int testCase = 1; testCase <= T; testCase++) {
			
			String sentence = br.readLine();
			
			StringBuilder word = new StringBuilder();
			
			for(int sentenceI = 0; sentenceI < sentence.length(); sentenceI++) {
				
				char currentChar = sentence.charAt(sentenceI) ;
				
				if(currentChar == ' ') {
					System.out.print(word.reverse() + " ");
					word.setLength(0);
				} else {
					word.append(currentChar);
				}
			}
			System.out.println(word.reverse());		
		}

	}

}
