package backjoon.implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q3034 {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		int digonal = (int) Math.sqrt((width * width) + (height * height));
		int matchLength;
		for (int i = 0; i < N; i++) {
			matchLength = Integer.parseInt(br.readLine());
			if (matchLength <= width || matchLength <= height || matchLength <= digonal)
				System.out.println("DA");
			else
				System.out.println("NE");
		}
	}

}
