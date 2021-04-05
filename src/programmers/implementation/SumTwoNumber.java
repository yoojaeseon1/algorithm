package programmers.implementation;

public class SumTwoNumber {

    public static void main(String[] args) {

        SumTwoNumber test = new SumTwoNumber();

        int a = 3;
        int b = 3;

        System.out.println(test.solution(a,b));

    }


    public long solution(int a, int b) {
        long answer = 0;

        int bigger = Math.max(a,b);
        int lower = Math.min(a,b);


        while(lower <= bigger) {
            answer += lower;
            lower++;
        }

        return answer;
    }


}
