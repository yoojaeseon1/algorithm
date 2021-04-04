package programmers.implementation;

public class CenterCharacter {

    public static void main(String[] args) {


        CenterCharacter test = new CenterCharacter();


        String s = "abcde";

        s = "qwer";

        System.out.println(test.solution(s));

    }


    public String solution(String s) {

        String answer = "";

        int sLength = s.length();

        if(sLength % 2 == 1){
            answer = s.substring(sLength / 2 , (sLength / 2) + 1);

        } else {
            answer = s.substring((sLength / 2) - 1, (sLength / 2) + 1);
        }


        return answer;
    }


}
