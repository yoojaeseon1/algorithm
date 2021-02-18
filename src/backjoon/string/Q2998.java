package backjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2998 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder inputNum = new StringBuilder(br.readLine());
		StringBuilder answer = new StringBuilder();

		if (inputNum.length() % 3 != 0) {
			for (int i = 0; i < 2; i++) {
				inputNum.insert(0, 0);
				if (inputNum.length() % 3 == 0)
					break;
			}
		}
		
		int tempAnswer;
		
		for(int i = 0; i < inputNum.length(); i+=3) {
			tempAnswer = 0;
			if(inputNum.charAt(i) == '1') tempAnswer += 4;
			if(inputNum.charAt(i+1) == '1') tempAnswer += 2;
			if(inputNum.charAt(i+2) == '1') tempAnswer += 1;
			answer.append(Integer.toString(tempAnswer));
		}
		System.out.println(answer);
	}
}
