package backjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2857 {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder[] inputs = new StringBuilder[5];

		int[] fbiCount = new int[5];
		int agencyCount = 0;

		for (int i = 0; i < inputs.length; i++) {
			inputs[i] = new StringBuilder(br.readLine());
		}

		for (int i = 0; i < inputs.length; i++) {

			for (int j = 0; j < inputs[i].length() - 2; j++) {
				if (inputs[i].charAt(j) == 'F') {
					if (inputs[i].charAt(j + 1) == 'B' && inputs[i].charAt(j + 2) == 'I') {
						fbiCount[agencyCount++] = i + 1;
						break;
					}
				}
			}
		}
		if (agencyCount == 0)
			System.out.println("HE GOT AWAY!");
		else {
			for (int i = 0; i < fbiCount.length; i++) {
				if (fbiCount[i] != 0)
					System.out.print(fbiCount[i] + " ");
			}
		}
	}

}
