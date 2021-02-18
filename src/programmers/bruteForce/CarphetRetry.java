package programmers.bruteForce;

import java.util.Arrays;

public class CarphetRetry {

	public static void main(String[] args) {

		int brown = 24;
		int yellow = 24;

		System.out.println(Arrays.toString(solution(brown, yellow)));

	}
	
	// correct
//	public static int[] solution(int brown, int yellow) {
//		int[] answer = new int[2];
//
//		for (int width = 3; width <= yellow + 2; width++) {
//
//			for (int height = 3; height <= width; height++) {
//
//				if (width * height == brown + yellow && brown == (width*2)+(height*2) - 4) {
//					answer[0] = width;
//					answer[1] = height;
//					// System.out.println("1");
//					return answer;
//				}
//			}
//		}
//
//		return answer;
//	}
	
	public static int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
		
		int yellowWidth = yellow;
		int yellowHeight = 1;
		
		while(yellowHeight <= yellowWidth) {
			
			while(yellowWidth*yellowHeight > yellow)
				yellowWidth--;
			
			if((yellowWidth + 2) * 2 + (yellowHeight*2) == brown) {
				answer[0] = yellowWidth + 2;
				answer[1] = yellowHeight + 2;
				break;
			}
			
			yellowHeight++;
		}
		
		return answer;
	}

	// public static int[] solution(int brown, int yellow) {
	// int[] answer = new int[2];
	//
	// if ((yellow + 2) * 2 + 2 == brown) {
	// answer[0] = yellow + 2;
	// answer[1] = 3;
	// System.out.println("1");
	// return answer;
	// }
	//
	// // int yellowLow = yellow;
	// int yellowColumn = 2;
	//
	// int limitColumn = 3;
	// int limitLow = (int) Math.ceil(yellow / 2.0);
	//
	// for (int yellowLow = yellow - 1; yellowLow >= 0; yellowLow--) {
	//
	// yellowColumn = 2;
	// System.out.println("yellowLow : " + yellowLow);
	// // while(yellowColumn < limitColumn) {
	// while (yellowLow * yellowColumn >= yellow && yellowLow >= yellowColumn) {
	// System.out.println("yellowColumn : " + yellowColumn);
	// if ((yellowLow * yellowColumn) - yellow + ((yellowLow + 2) * 2) +
	// (yellowColumn * 2) == brown) {
	// answer[0] = yellowLow + 2;
	// answer[1] = yellowColumn + 2;
	// return answer;
	// }
	// yellowColumn++;
	// }
	//
	// limitColumn++;
	// System.out.println("------------");
	// }
	//
	// System.out.println("2");
	//
	// return answer;
	// }
//	public static int[] solution(int brown, int yellow) {
//		int[] answer = new int[2];
//
//		int lowYellow = yellow;
//		int columnYellow = 1;
//
//		while (lowYellow >= columnYellow) {
//
//			if ((lowYellow + 2) * 2 + (columnYellow * 2) == brown) {
//				answer[0] = lowYellow + 2;
//				answer[1] = columnYellow + 2;
//				break;
//			}
//
//			lowYellow /= 2;
//			columnYellow *= 2;
//		}
//
//		return answer;
//	}

}
