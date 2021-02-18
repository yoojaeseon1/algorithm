package programmers.hash;

public class PhoneNumberList {

	public static void main(String[] args) {

		 String[] phone_book = {"119", "97674223", "1195524421"};
//		String[] phone_book = {"123","456","789"};
//		String[] phone_book = { "12", "123", "1235", "567", "88" };

		System.out.println(solution(phone_book));

	}

	public static boolean solution(String[] phone_book) {

		for (int pi = 0; pi < phone_book.length; pi++) {

//			String baseNumber = phone_book[pi];

			for (int pj = pi + 1; pj < phone_book.length; pj++) {

				if (phone_book[pj].length() > phone_book[pi].length()) {
					if (isEqualChars(phone_book[pi], phone_book[pj]))
						return false;
				} else {
					if (isEqualChars(phone_book[pj], phone_book[pi]))
						return false;
				}
			}
		}
		return true;
	}

	public static boolean isEqualChars(String str1, String str2) {

		for (int si = 0; si < str1.length(); si++) {
			if (str1.charAt(si) != str2.charAt(si))
				return false;
		}
		return true;
	}

}
