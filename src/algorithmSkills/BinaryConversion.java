package algorithmSkills;

public class BinaryConversion {
	
	// n ���� -> 10����
	
	public static int convertNToTen(String str, int n) {
		
		int convertedNumber = 0;
		int strLength = str.length();
		for(int strI = strLength - 1; strI >= 0; strI--) {
			convertedNumber += (str.charAt(strI) - '0') * Math.pow(n, strLength - strI - 1);
		}
		
		return convertedNumber;
		
	}

	public static String convertTenToN(int n, int number) {

		StringBuilder calculatedNumber = new StringBuilder();
		char[] alphabets = {'A','B','C','D','E','F'};

		int value = number;
		int remain = 0;

		while(value > 0) {

			remain = value % n;
			value /= n;

			if(remain >= 10) {
				calculatedNumber.insert(0, alphabets[remain - 10]);
			} else
				calculatedNumber.insert(0, remain);
		}


		System.out.println("calculatedNumber = " + calculatedNumber);

		return calculatedNumber.toString();

	}
	
	public static void main(String[] args) {
		
		int convertedNumber1 = convertNToTen("112001", 3);
		int convertedNumber2 = convertNToTen("12010", 3);
		
		System.out.println(convertedNumber1);
		System.out.println(convertedNumber2);
		
		String convertedToN = convertTenToN( 8, convertedNumber1 + convertedNumber2);
		System.out.println(convertedToN);
	}

}
