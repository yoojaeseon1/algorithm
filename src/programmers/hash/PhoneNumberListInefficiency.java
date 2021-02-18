package programmers.hash;

import java.util.Arrays;

public class PhoneNumberListInefficiency {

	public static void main(String[] args) {


//		 String[] phone_book = {"119", "97674223", "1195524421"};
//			String[] phone_book = {"123","456","789"};
			String[] phone_book = { "12", "123", "1235", "567", "88" };

			System.out.println(solution(phone_book));

	}
	
	public static boolean solution(String[] phone_book) {

		Arrays.sort(phone_book);

		for (int phoneI = 0; phoneI < phone_book.length - 1; phoneI++) {

			if (phone_book[phoneI].length() < phone_book[phoneI + 1].length()
					&& phone_book[phoneI + 1].indexOf(phone_book[phoneI]) >= 0) {
				return false;
			}
		}
		return true;

	}

}
