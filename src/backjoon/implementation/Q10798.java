package backjoon.implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;


//shallow copy : 배열을 수정할 일이 없으므로 deep copy소스로 실행했다.(shallow copy로도 구현 가능)

public class Q10798 {
	
public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[][] words = new char[5][];
		StringBuilder tempWord = new StringBuilder();
		StringBuilder resultWord = new StringBuilder();
		char[] line;
		int maxLength = 0;
		int tempLength = 0;
		
		for(int i = 0; i < 5; i++) {
			tempWord.append(br.readLine());
			tempLength = tempWord.length();
			line = new char[tempLength];
//			words[i] = new char[tempLength];
			maxLength = Math.max(maxLength, tempLength);
			for(int j = 0; j < tempWord.length(); j++) {
				line[j] = tempWord.charAt(j);
			}
//			System.arraycopy(line, 0, words[i], 0, line.length);
			words[i] = line;
			tempWord.setLength(0);
		}
		
		for(int i = 0; i < maxLength; i++) {
			for(int j = 0; j < 5; j++) {
				if(words[j].length > i) {
					resultWord.append(words[j][i]);
				}
			}
		}
		
		System.out.println(resultWord);
		
	}

}
