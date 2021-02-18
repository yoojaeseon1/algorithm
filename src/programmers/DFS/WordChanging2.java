package programmers.DFS;

public class WordChanging2 {

	
	private static int minSearchCount;
	
	public static void main(String[] args) {
		
		String begin = "hit";
		String target = "cog";
		
//		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"}; 
		String[] words = {"hot", "dot", "dog", "lot", "log"}; 
		
		
		
//		System.out.println(isDifferentOneChar(str1, str2));
		System.out.println(solution(begin, target, words));

	}
	

	public static int solution(String begin, String target, String[] words) {
		minSearchCount = words.length+1;
		
		searchWord(begin, target, words, 0);
		
		if(minSearchCount < words.length+1)
			return minSearchCount;
		else 
			return 0;
	}
	
	
	public static void searchWord(String begin, String target, String[] words, int searchCount) {
		
//		System.out.println("begin : " + begin);
		
		
		if(begin.equals(target)) {
			minSearchCount = Math.min(minSearchCount, searchCount);
//			System.out.println("searchCount : " + searchCount);
			return;
		}
		
		for(int wordsI = 0; wordsI < words.length; wordsI++) {
			
			if(words[wordsI].length() > 0 && isDifferentOneChar(begin, words[wordsI])) {
				String word = words[wordsI];
				words[wordsI] = "";
				searchWord(word, target, words, searchCount+1);
				words[wordsI] = word;
			}
		}
	}

	public static boolean isDifferentOneChar(String str1, String str2) {

		int numDifferedChar = 0;

		for (int strI = 0; strI < str1.length(); strI++) {
			if (str1.charAt(strI) != str2.charAt(strI))
				numDifferedChar++;

			if (numDifferedChar > 1)
				return false;
		}

		// if (numDifferedChar == 1)
		return true;

	}

}
