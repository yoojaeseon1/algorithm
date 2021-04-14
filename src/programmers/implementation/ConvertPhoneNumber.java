package programmers.implementation;

public class ConvertPhoneNumber {

    public String solution(String phone_number) {

        StringBuilder convertedString = new StringBuilder();

        for(int phoneI = 0; phoneI < phone_number.length() - 4; phoneI++) {
            convertedString.append('*');
        }

        for(int phoneI = phone_number.length()-4; phoneI < phone_number.length(); phoneI++) {
            convertedString.append(phone_number.charAt(phoneI));
        }

        return convertedString.toString();
    }
}
