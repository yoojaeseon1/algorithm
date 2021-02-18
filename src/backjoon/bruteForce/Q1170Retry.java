package backjoon.bruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q1170Retry {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int M = Integer.parseInt(br.readLine());

		boolean[] isDeadButton = new boolean[10];

		int[] livedButtons = new int[10 - M];
		if (M > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int tokenCount = 1; tokenCount <= M; tokenCount++) {
				isDeadButton[Integer.parseInt(st.nextToken())] = true;
			}
		}

		int livedI = 0;
		
		for (int isDeadI = 0; isDeadI < isDeadButton.length; isDeadI++) {
			if (!isDeadButton[isDeadI])
				livedButtons[livedI++] = isDeadI;
		}
		
		int nLength = Integer.toString(N).length();
		int[] selectedIndices = new int[nLength+1];
		
		if(nLength > 1)
			searchChannels(livedButtons, livedButtons.length, nLength-1, selectedIndices, 0);
		if(nLength < 6)
			searchChannels(livedButtons, livedButtons.length, nLength+1, selectedIndices, 0);
		
		searchChannels(livedButtons, livedButtons.length, nLength, selectedIndices, 0);
		
		int minButtonCount = Math.abs(100 - N);
		
		for(int channelsI = 0; channelsI < channels.size(); channelsI++) {
			
			int currentChannel = channels.get(channelsI);
			int currentButtonCount = Math.abs(currentChannel - N) + Integer.toString(currentChannel).length();
			
			minButtonCount = Math.min(minButtonCount, currentButtonCount);
				
			
		}
		System.out.println(minButtonCount);

	}

	
	private static List<Integer> channels = new ArrayList<>();

	public static void searchChannels(int[] source, int n, int r, int[] selectedIndices, int selectedIndex) {

		if (selectedIndex > 1 && source[selectedIndices[0]] == 0)
			return;

		if (r == 0) {
			StringBuilder numberSB = new StringBuilder();

			for (int selectedI = 0; selectedI < selectedIndex; selectedI++) {
				numberSB.append(source[selectedIndices[selectedI]]);
			}
//			 System.out.println(numberSB);

			channels.add(Integer.parseInt(numberSB.toString()));
			return;
		}

		for (int sourceI = 0; sourceI < source.length; sourceI++) {

			selectedIndices[selectedIndex] = sourceI;
			searchChannels(source, n, r - 1, selectedIndices, selectedIndex + 1);

		}
	}
	
}
