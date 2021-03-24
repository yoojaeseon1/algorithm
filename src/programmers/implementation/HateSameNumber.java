package programmers.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HateSameNumber {

    public static void main(String[] args) {

        HateSameNumber test = new HateSameNumber();

        int[] arr = {1,1,3,3,0,1,1};

        System.out.println(Arrays.toString(test.solution(arr)));

        arr = new int[]{4,4,4,3,3};
        System.out.println(Arrays.toString(test.solution(arr)));



    }

    public int[] solution(int []arr) {

        List<Integer> numbers = new ArrayList<>();

        for(int arrI = 0; arrI < arr.length-1; arrI++) {
            int number = arr[arrI];
            if(number != arr[arrI+1]) {
                numbers.add(number);
            }
        }

        numbers.add(arr[arr.length-1]);

        int[] answer = new int[numbers.size()];

        for(int answerI = 0; answerI < answer.length; answerI++)
            answer[answerI] = numbers.get(answerI);

        return answer;
    }

}
