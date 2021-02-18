package backjoon.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1509 {
	
	static StringBuilder palineCheckWord;
	static int palineLength;
	static int palineCount;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		palineCheckWord = new StringBuilder(br.readLine());
		palineLength = palineCheckWord.length();
		palineCount = 0;
		
//		System.out.println(palineLength);
		dividePaline(0,palineLength-1);
		
		
		System.out.println(palineCount);
	}

	public static void dividePaline(int firstIndex, int lastIndex) {
		
//		if(firstIndex == 35 && lastIndex == 34) return;
		if (firstIndex == lastIndex ||firstIndex < 0 || lastIndex >= palineCheckWord.length()) {
//			palineCount++;
			return;
		}

		int left = 0;
		int right = 0;
		StringBuilder currentWord = new StringBuilder();
		System.out.println("firstIndex : " + firstIndex);
		System.out.println("lastIndex : " + lastIndex);
		if ((firstIndex + lastIndex) % 2 == 0) { // odd count
//			System.out.println("centerIndex : " + firstIndex + lastIndex / 2);
			currentWord.append(palineCheckWord.charAt((firstIndex + lastIndex) / 2));
			left = ((firstIndex + lastIndex) / 2) - 1;
			right = left + 2;

			while (left >= 0 && right < palineLength && palineCheckWord.charAt(left) == palineCheckWord.charAt(right)) {
				currentWord.append(palineCheckWord.charAt(right++));
				currentWord.insert(0, palineCheckWord.charAt(left--));
			}
			if (currentWord.length() > 0)
				palineCount++;
			System.out.println("right : " + right);
			System.out.println("left : " + left);
			if(right >= palineLength || left < 0) return;
			dividePaline(right, palineLength - 1);
			dividePaline(0, left);

		} else {
			left = (firstIndex + lastIndex) / 2;
			right = left + 1;
			while (left >= 0 && right < palineCheckWord.length()
					&& palineCheckWord.charAt(left) == palineCheckWord.charAt(right)) {
				currentWord.append(right++);
				currentWord.insert(0, left--);
			}
//			if (currentWord.length() > 0)
				palineCount++;
			System.out.println("right : " + right);
			System.out.println("left : " + left);
			if(right >= palineLength || left < 0) return;
			dividePaline(right, lastIndex);
			dividePaline(firstIndex, left);
		}
	}

}
