package backjoon;

public class Solution {

	public static void main(String[] args) {

		String begin = "hit";
		String target = "cog";
		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };

		solution(begin, target, words);

	}

	public static int solution(String begin, String target, String[] words) {
		int answer;

		StringBuilder tempString = new StringBuilder();
//		int criteria = -1;

		for (int i = 0; i < words.length; i++) {
			for (int criteria = 0; criteria < begin.length(); criteria++) {
				System.out.println(" criteria  : " + criteria);
				System.out.println("begin start: " + begin.substring(0, criteria + 1));
				System.out.println("words start: " + words[i].substring(0, criteria + 1));
				System.out.println("begin end : " + begin.substring(criteria + 2, begin.length()));
				System.out.println("words end : " + words[i].substring(criteria + 2, words[i].length()));
				if (begin.substring(0, criteria + 1).equals(words[i].substring(0, criteria + 1))
						&& begin.substring(criteria + 2, begin.length())
								.equals(words[i].substring(criteria + 2, words[i].length()))) {
					System.out.println(words[i] + " : " + criteria);
				}
				System.out.println("-----------");
			}
		}

		return 0;
	}

}
