package backjoon.implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Q2935 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		BigInteger a = new BigInteger(br.readLine());
		String operator = br.readLine();
		BigInteger b = new BigInteger(br.readLine());

		if ("*".equals(operator)) {
			System.out.println(a.multiply(b));
		} else {
			System.out.println(a.add(b));
		}
	}

}
