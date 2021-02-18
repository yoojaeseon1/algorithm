package backjoon.implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q5532 {
	
public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int l = Integer.parseInt(br.readLine());
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		int d = Integer.parseInt(br.readLine());
		int languageTime, mathTime;
		
		if(a%c == 0) languageTime = a / c;
		else languageTime = (a/c) + 1;
		
		System.out.println("language time : " + languageTime);
		
		if(b%d == 0) mathTime = b/d;
		else mathTime = (b/d) + 1;
		System.out.println("math time : " + mathTime);
		
		System.out.println(l-Math.max(languageTime,mathTime));
		
	}

}
