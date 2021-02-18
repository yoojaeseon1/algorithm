package programmers.DFS;

public class WordChanging {
	
	static String target;
	static String[] words;
	static int minRouteCount;
	public static void main(String[] args) {

		
		String[] testWords = {"hot", "dot", "dog", "lot", "log", "cog"};	
//		String[] testWords = {"hot", "dot", "dog", "lot", "log"};	

		System.out.println(solution("hit", "cog", testWords));

	}

	public static int solution(String begin, String target, String[] words) {
		
		WordChanging.target = target;
		WordChanging.words = words;
		minRouteCount = Integer.MAX_VALUE;
		
		
		int[] visitSequence = new int[words.length];
		doDFS(begin, visitSequence, 0);
		
		
		if(minRouteCount == Integer.MAX_VALUE) return 0;
		else return minRouteCount;
	}

	public static void doDFS(String source, int[] visitSequence, int visitCount) {		
		
		if(target.equals(source)) {
			minRouteCount = Math.min(minRouteCount, visitCount);
			return;
		}
		
//		System.out.println("source : " + source);
		for(int wi = 0; wi < visitSequence.length; wi++) {
			if(checkEqualWord(source, words[wi]) && visitSequence[wi] == 0) {
				visitSequence[wi] = visitCount + 1;
				doDFS(words[wi], visitSequence, visitCount+1);
				visitSequence[wi] = 0;
			}
		}
		
//		System.out.println("-----------");
	}

	public static boolean checkEqualWord(String str1, String str2) {

		int notEqualCount = 0;

		for (int si = 0; si < str1.length(); si++) {
			if (str1.charAt(si) != str2.charAt(si))
				notEqualCount++;
		}

		if (notEqualCount == 1)
			return true;
		else
			return false;
	}
}
