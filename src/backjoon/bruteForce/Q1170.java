package backjoon.bruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1170 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int M = Integer.parseInt(br.readLine());

		boolean[] isDeadButton = new boolean[10];

		if (M > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int tokenCount = 1; tokenCount <= M; tokenCount++) {
				isDeadButton[Integer.parseInt(st.nextToken())] = true;
			}
		}
		
		
		int minButtonCount = Math.abs(100 - N);
		
		for(int channel = 0; channel < 1000000; channel++) {
			
			if(isPushableChannel(isDeadButton,channel))
				minButtonCount = Math.min(minButtonCount, Math.abs(N - channel) + Integer.toString(channel).length());
			
		}
		
		System.out.println(isPushableChannel(isDeadButton, 1234));
		
		System.out.println(minButtonCount);

	}

	public static boolean isPushableChannel(boolean[] isDeadButton, int channelNumber) {
		
		String channelString = Integer.toString(channelNumber);
		
		for(int channelI = 0; channelI < channelString.length(); channelI++) {
			
			if(isDeadButton[channelString.charAt(channelI) - '0'])
				return false;
			
		}
		
		return true;
		
	}
}
