package test;

import java.util.Scanner;
import java.util.StringTokenizer;

public class ScannerTest {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		StringTokenizer st;
		
		int[][] arr = new int[5][4];		
		for(int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(input.nextLine());
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
