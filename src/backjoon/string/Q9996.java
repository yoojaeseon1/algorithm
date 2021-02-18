package backjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9996 {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		String[] pattern = br.readLine().split("\\*");
		StringBuilder fileName = new StringBuilder();
		StringBuilder[] files = new StringBuilder[n];
		
		for(int i = 0; i < n; i++) {
			files[i] = new StringBuilder();
			files[i].append(br.readLine());
		}

		for (StringBuilder file : files) {
			
			if(file.length() < (pattern[0].length() + pattern[1].length())) {
				System.out.println("NE");
				continue;
			}
			if (pattern[0].equals(file.substring(0, pattern[0].length()))
					&& pattern[1].equals(file.substring(file.length() - pattern[1].length()))) {
				System.out.println("DA");
			} else {
				System.out.println("NE");
			}
			fileName.setLength(0);
		}
	}

}
