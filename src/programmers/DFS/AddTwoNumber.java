package programmers.DFS;

/*
    두 개 뽑아서 더하기



 */

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class AddTwoNumber {

    public static void main(String[] args) {

        AddTwoNumber test = new AddTwoNumber();

        int[] numbers = {2,1,3,4,1};

        numbers = new int[]{5,0,2,7};

        System.out.println(Arrays.toString(test.solution(numbers)));

    }

    private Set<Integer> numAddedSet;

    public AddTwoNumber() {

        numAddedSet = new TreeSet<>();

    }

    public int[] solution(int[] numbers) {

        selectNumber(numbers, new int[2], 0 ,0);

        int[] answer = new int[numAddedSet.size()];

        int answerI  = 0;
        for (Integer integer : numAddedSet) {
            answer[answerI++] = integer;
        }

        return answer;
    }

    public void selectNumber(int[] numbers, int[] selectedIndices, int selectedIndex, int targetIndex) {

        if(selectedIndex == selectedIndices.length) {

            int addedNumber = 0;

            for(int selectedI = 0; selectedI < selectedIndex; selectedI++) {
                addedNumber += numbers[selectedIndices[selectedI]];
            }

            numAddedSet.add(addedNumber);


        } else if(targetIndex == numbers.length) {
            return;
        } else {

            selectedIndices[selectedIndex] = targetIndex;

            selectNumber(numbers, selectedIndices, selectedIndex+1, targetIndex+1);
            selectNumber(numbers, selectedIndices, selectedIndex, targetIndex+1);


        }

    }

}
