package backjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q3986 {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Stack<Character> goodCheckStack = new Stack<>();

		StringBuilder currentWord = new StringBuilder();
		int goodWordCount = 0;

		for (int wordCnt = 0; wordCnt < N; wordCnt++) {
			currentWord.append(br.readLine());

			for (int wi = 0; wi < currentWord.length(); wi++) {
				
				if(goodCheckStack.isEmpty() || goodCheckStack.peek() != currentWord.charAt(wi))
					goodCheckStack.push(currentWord.charAt(wi));
				else 
					goodCheckStack.pop();
			}

			if (goodCheckStack.isEmpty()) {
				goodWordCount++;
			} else
				goodCheckStack.clear();

			currentWord.setLength(0);

		}
		System.out.println(goodWordCount);
	}

}
