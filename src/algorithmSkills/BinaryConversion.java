package algorithmSkills;

public class BinaryConversion {
	
	// n 진법 -> 10진법
	
	public static int convertNToTen(String str, int n) {
		
		int convertedNumber = 0;
		int strLength = str.length();
		for(int strI = strLength - 1; strI >= 0; strI--) {
			convertedNumber += (str.charAt(strI) - '0') * Math.pow(n, strLength - strI - 1);
		}
		
		return convertedNumber;
		
	}
	
	public static int convertTenToN(int ten, int n) {
		
		int value = ten;
		int remain = 0;
		
		StringBuilder answer = new StringBuilder();
		
		while(value >= n) {
			remain = value % n;
			value /= n;
			answer.insert(0, remain);
		}
		answer.insert(0, value);
		System.out.println("answer : " + answer);
		return Integer.parseInt(answer.toString());
	}
	
	public static void main(String[] args) {
		
		int convertedNumber1 = convertNToTen("112001", 3);
		int convertedNumber2 = convertNToTen("12010", 3);
		
		System.out.println(convertedNumber1);
		System.out.println(convertedNumber2);
		
		int convertedToN = convertTenToN(convertedNumber1 + convertedNumber2, 8);
		System.out.println(convertedToN);
	}

}
