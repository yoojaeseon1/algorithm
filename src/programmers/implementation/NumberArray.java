package programmers.implementation;

/*
    나누어 떨어지는 숫자 배열
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberArray {

    public static void main(String[] args) {

        NumberArray numberArray = new NumberArray();

        int[] arr = {5, 9, 7, 10};
        int divisor = 5;

        arr = new int[]{2, 36, 1, 3};
        divisor = 1;

        arr = new int[]{3,2,6};
        divisor = 10;

        System.out.println(Arrays.toString(numberArray.solution(arr, divisor)));

    }

    public int[] solution(int[] arr, int divisor) {

        List<Integer> dividedNumbers = new ArrayList<>();

        for (int number : arr) {

            if(number % divisor == 0) {
                dividedNumbers.add(number);
            }
        }

        if(dividedNumbers.size() == 0)
            return new int[]{-1};

        int[] answer = new int[dividedNumbers.size()];

        for(int answerI = 0; answerI < answer.length; answerI++)
            answer[answerI] = dividedNumbers.get(answerI);

        Arrays.sort(answer);

        return answer;
    }

}
