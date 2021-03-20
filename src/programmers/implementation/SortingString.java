package programmers.implementation;

import java.util.Arrays;
import java.util.Comparator;

public class SortingString {

    public static void main(String[] args) {

        SortingString sortingString= new SortingString();

//        Integer[] numbers = {4,3,6,1,2};
//
//        Arrays.sort(numbers, new Comparator<>(){
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1-o2;
//            }
//        });
//
//        System.out.println(Arrays.toString(numbers));

//        for (Integer number : numbers) {
//            System.out.println("number = " + number);
//        }


        String[] strings = {"sun", "bed", "car"};
        int n = 1;

        System.out.println(Arrays.toString(sortingString.solution(strings, n)));

        strings = new String[]{"abce", "abcd", "cdx"};
        n = 2;

        System.out.println(Arrays.toString(sortingString.solution(strings, n)));

    }


    public String[] solution(String[] strings, int n) {

        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                char o1CharNIndex = o1.charAt(n);
                char o2CharNIndex = o2.charAt(n);

                if(o1CharNIndex == o2CharNIndex)
                    return o1.compareTo(o2);

                return o1CharNIndex - o2CharNIndex;
            }
        });

        return strings;
    }






}
