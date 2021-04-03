package programmers.implementation;

import java.util.Arrays;

public class ReverseNumber {

    public static void main(String[] args) {

        ReverseNumber test= new ReverseNumber();

        long n = 12345;

        System.out.println(Arrays.toString(test.solution(n)));


    }

    public int[] solution(long n) {

        String nToString = Long.toString(n);

        int[] answer = new int[nToString.length()];

        for(int ni = nToString.length()-1, answerI = 0; ni >= 0; ni--, answerI++) {

            answer[answerI] = nToString.charAt(ni) - '0';

        }

        return answer;
    }
}
