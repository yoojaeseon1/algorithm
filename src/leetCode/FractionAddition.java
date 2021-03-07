package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 헷갈렸던 부분
 * - 논리적으로 어려웠던 부분은 없지만, 생각을 정리하는게 잘 안됐다.
 * - 공책에 코드로 간략하게 정리를 잘 하자.
 *
 */

public class FractionAddition {

    public static void main(String[] args) {

        FractionAddition fractionAddition = new FractionAddition();

        System.out.println(fractionAddition.fractionAddition("-1/2+1/2"));
        System.out.println("===========");
        System.out.println(fractionAddition.fractionAddition("-1/2+1/2+1/3"));
        System.out.println("===========");
        System.out.println(fractionAddition.fractionAddition("1/3-1/2"));
        System.out.println("===========");
        System.out.println(fractionAddition.fractionAddition("5/3+1/3"));
        System.out.println("===========");
        System.out.println(fractionAddition.fractionAddition("7/3+5/2-3/10"));




    }

    public String fractionAddition(String expression) {

        boolean isNumerator = true;

        List<Integer> numerators = new ArrayList<>();
        List<Integer> denominators = new ArrayList<>();



        StringBuilder number = new StringBuilder();
        int expI = 0;
        for(; expI < expression.length() - 2; expI++) {
            char currentChar = expression.charAt(expI);
            if(isNumerator) {

                while(expI < expression.length()  - 1 && currentChar != '/') {
                    number.append(currentChar);
                    currentChar = expression.charAt(++expI);
                }

                numerators.add(Integer.parseInt(number.toString()));
                number.setLength(0);
                isNumerator = false;

            } else {

                while(expI < expression.length() - 1 && currentChar != '+' && currentChar != '-') {
                    number.append(currentChar);
                    currentChar = expression.charAt(++expI);
                }

                denominators.add(Integer.parseInt(number.toString()));
                number.setLength(0);

                number.append(currentChar);

                isNumerator = true;

            }

        }

        for(;expI < expression.length(); expI++) {
            number.append(expression.charAt(expI));
        }

        denominators.add(Integer.parseInt(number.toString()));

        int lcmOfDenominator = calculdateLcm(denominators);


        int sumNumerator = 0;
        for(int numeratorI = 0; numeratorI < numerators.size(); numeratorI++) {
            sumNumerator += numerators.get(numeratorI) * (lcmOfDenominator / denominators.get(numeratorI));
        }

        int gcdOfNumAndDenom = calculateGcd(Math.abs(sumNumerator), lcmOfDenominator);

        if(sumNumerator == 0)
            return "0/1";

        lcmOfDenominator /= gcdOfNumAndDenom;
        sumNumerator /= gcdOfNumAndDenom;

        if(lcmOfDenominator == sumNumerator)
            return "1/1";
        else
            return sumNumerator + "/" + lcmOfDenominator;
    }

    public static int calculdateLcm(List<Integer> numbers) {

        int answer = numbers.get(0);

        for(int numberI = 1; numberI < numbers.size() ; numberI++ ){

            int currentNumber = numbers.get(numberI);

            int smaller = Math.min(answer,  currentNumber);
            int bigger = Math.max(answer, currentNumber);

            answer = (smaller * bigger) / calculateGcd(smaller, bigger);
        }

        return answer;

    }

    public static int calculateGcd(int number1, int number2) {

        int answer = 0;

        int smaller = Math.min(number1, number2);
        int bigger = Math.max(number1, number2);

        for(int divider = 1; divider <= smaller; divider++) {
            if(smaller % divider == 0 && bigger % divider == 0) answer = divider;
        }

        return answer;
    }
}
