package backjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q11650 {
	
public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		int n = Integer.parseInt(br.readLine());
		
		int[][] coordiArr = new int[n][2];
		
		StringTokenizer st;
		
		for(int i = 0; i < coordiArr.length; i++) {
			st = new StringTokenizer(br.readLine());
			coordiArr[i][0] = Integer.parseInt(st.nextToken());
			coordiArr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(coordiArr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				if(o1[0] > o2[0]) return 1;
				else if(o1[0] == o2[0]) {
					return Integer.compare(o1[1], o2[1]);
				} else
					return -1;
			}
		});
		
		for(int i = 0; i < coordiArr.length; i++) {
			System.out.println(coordiArr[i][0] + " "+ coordiArr[i][1]);
		}

	}

}
