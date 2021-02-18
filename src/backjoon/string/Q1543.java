package backjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1543 {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder document = new StringBuilder();

		String searchedWord;

		document.append(br.readLine());
		searchedWord = br.readLine();

		int wordCnt = 0;

		if (document.length() >= searchedWord.length()) {
			for (int i = 0; i <= document.length() - searchedWord.length(); i++) {
				if (searchedWord.equals(document.substring(i, i + searchedWord.length()))) {
					wordCnt++;
					i += (searchedWord.length() - 1);
				}
			}
		}
		System.out.println(wordCnt);
	}

}
