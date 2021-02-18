package backjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Q1181 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String[] words = new String[n];
		
		for(int i = 0; i < words.length; i++) {
			words[i] = br.readLine();
		}
		
		
		
		Arrays.sort(words, new Comparator<String>() {

			@Override
			public int compare(String arg0, String arg1) {
				if(arg0.length() > arg1.length()) {
					return 1;
				} else if(arg0.length() == arg1.length()) {
					return arg0.compareTo(arg1);
				} else {
					return -1;
				}
			}
			
		});
//		Set<String> wordsSet = new HashSet<>(Arrays.asList(words));
//		List<String> wordsList = new ArrayList<>(wordsSet);
		
		System.out.println(words[0]);
		for(int i = 1; i < words.length; i++) {
			if(!words[i-1].equals(words[i])) {
				System.out.println(words[i]);
			}	
		}

	}
}

//class StringCompare implements Comparator<String>{
//
//	@Override
//	public int compare(String arg0, String arg1) {
//		
//		if(arg0.length() > arg1.length()) {
//			return 1;
//		} else if(arg0.length() == arg1.length()) {
//			return arg0.compareTo(arg1);
//		} else {
//			return -1;
//		}		
//	}
//}
