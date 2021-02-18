package backjoon.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q4949 {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		List<String> sentences = new ArrayList<>();
		
		while(true) {
			
			String sentence = br.readLine();
			
			if(sentence.equals("."))
				break;
			
			sentences.add(sentence);
			
		}
		
//		System.out.println(sentences.size());
		
		Stack<Character> bracketStack = new Stack<>();
		for(String sentence : sentences) {
			boolean isStoped = false;
			for(int sentenceI = 0; sentenceI < sentence.length(); sentenceI++) {
				
				char currentChar = sentence.charAt(sentenceI);
				
				if(currentChar == '(' || currentChar == '[')
					bracketStack.push(currentChar);
				
				if(currentChar == ')' || currentChar == ']') {
					
					if(bracketStack.isEmpty()) {
						System.out.println("no");
						isStoped = true;
						break;
					} 
					
					char currentBracket = bracketStack.peek();
					
					if((currentChar == ')' && currentBracket == '(') ||(currentChar == ']' && currentBracket == '[')) {
						bracketStack.pop();
					} else {
						System.out.println("no");
						isStoped = true;
						break;
					}
				}
			}
			
			if(bracketStack.isEmpty() && !isStoped)
				System.out.println("yes");
			else if(!isStoped)
				System.out.println("no");
			
			bracketStack.clear();
			
		}
	}

}
