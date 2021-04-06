package programmers.implementation;

import java.util.regex.Pattern;

public class RecommendingNewID {

    public static void main(String[] args) {

        RecommendingNewID q1 = new RecommendingNewID();

//        String new_id = "...!@BaT#*..y.abcdefghijklm";
//        String new_id = "z-+.^.";
//        String new_id = "=.=";
//        String new_id = "123_..def";
        String new_id = "..";
//        String new_id = "abcdefghijklmn.p";

        String pattern2 = "[\\.]{2,}";

        System.out.println(Pattern.matches(pattern2, new_id));


//        String new_id = "asd13..-_";
//        System.out.println(q1.solution(new_id));

//        q1.convertValidId(new_id);

    }

    public String solution(String new_id) {

        String pattern1 = "[a-z0-9\\-\\_\\.]{3,15}"; // true
        boolean isValidId = true;

        if(!Pattern.matches(pattern1, new_id) || new_id.charAt(0) == '.' || new_id.charAt(new_id.length()-1) == '.')
            isValidId = false;

        if(isValidId) {
            boolean isConsecuteDot = false;
            for (int newI = 0; newI < new_id.length(); newI++) {

                if (new_id.charAt(newI) == '.') {
                    if (isConsecuteDot) {
                        isValidId = false;
                        break;
                    }
                    isConsecuteDot = true;
                } else
                    isConsecuteDot = false;
            }
        }

        if(isValidId)
            return new_id;
        else
            return convertToValidId(new_id);

    }

    public String convertToValidId(String invalidId) {

        String convertedId = invalidId.toLowerCase()
                .replaceAll("[^0-9a-z\\.\\-\\_]|", "")
                .replaceAll("[\\.]{2,}", ".");

        if(convertedId.charAt(0) == '.')
            convertedId = convertedId.substring(1);

        if(convertedId.length() > 0 && convertedId.charAt(convertedId.length()-1) == '.')
            convertedId = convertedId.substring(0, convertedId.length()-1);

        if(convertedId.length() == 0)
            convertedId = "a";

        if(convertedId.length() >= 16) {

            if(convertedId.charAt(14) == '.')
                convertedId = convertedId.substring(0, 14);
            else
                convertedId = convertedId.substring(0, 15);
        }

        while(convertedId.length() <= 2) {
            convertedId += convertedId.substring(convertedId.length()-1);
        }

        return convertedId;

    }
}
