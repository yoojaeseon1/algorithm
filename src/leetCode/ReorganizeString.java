package leetCode;


import java.util.Arrays;
import java.util.Comparator;

/**
 * 문제 번호 : 767
 *
 * 헷갈렸던 부분
 * - 인접하지 않게 재배열 하는 로직을 정확히 생각하지 못했다.
 *      - char[]로 한 칸씩 띄워서 배열하고(인덱스 2씩 증가) 배열 범위 넘어가면
 *          - 0부터 시작했으면 1
 *          - 1부터 시작했으면 0
 *      - 한 칸씩 띄엄띄엄 배치만 하면 된다.
 *      - 연속해서 같은 문자를 넣지만 안으면 어떤 방식으로 배열해도 상관 없다.
 *
 */
public class ReorganizeString {

    public static void main(String[] args) {

        ReorganizeString reorganizeString = new ReorganizeString();

//        String S = "aab";
//        String S = "aaab";
//        String S = "aaabb";
        String S = "vvvlo";

        System.out.println(reorganizeString.reorganizeString(S));

    }
    
    
    // 현재 코드는 count 내림차순, answerI = 0으로 시작(0부터 한 칸씩 띄워서 했을 때 가장 빈도 높은 문자를 배치 할 수 있으므로)
    // 주석 처리 count 오름차순, answerI = 1로 시작

    public String reorganizeString(String S) {

        int N = S.length();
        Integer[][] alphabetCounts = new Integer[26][2];

        for(int alphabetI = 0; alphabetI < alphabetCounts.length; alphabetI++) {
            alphabetCounts[alphabetI] = new Integer[]{alphabetI, 0};
//            alphabetCounts[alphabetI][0] = alphabetI;
        }

        for(int si = 0; si < S.length(); si++) {

            alphabetCounts[S.charAt(si) - 'a'][1]++;

        }

        Arrays.sort(alphabetCounts, new Comparator<Integer[]>(){

            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return Integer.compare(o2[1], o1[1]);
            }

//            @Override
//            public int compare(Integer[] o1, Integer[] o2) {
//                return Integer.compare(o1[1], o2[1]);
//            }
        });

        char[] answer = new char[N];

        int answerI = 0;

//        int answerI = 1;



        for (Integer[] code: alphabetCounts) {

            int count = code[1];
            char alphabet = (char) ('a' + code[0]);

            // 한 칸씩 띄어서 넣을 수 있는 공간보다 더 길면 만들 수 없다.
            if (count > (N+1) / 2)
                return "";

            for (int i = 0; i < count; ++i) {
                if (answerI >= N)
                    answerI = 1;
//                   answerI = 0;

                answer[answerI] = alphabet;
                answerI += 2;
            }
        }

        return String.valueOf(answer);
    }

//    public String reorganizeString(String S) {
//
//        int N = S.length();
//        int[] alphabetCounts = new int[26];
//        for (char c: S.toCharArray())
//            alphabetCounts[c-'a'] += 100;
//
//        for (int alphabetI = 0; alphabetI < 26; ++alphabetI)
//            alphabetCounts[alphabetI] += alphabetI;
//
//        Arrays.sort(alphabetCounts);
//
//        char[] answer = new char[N];
//
//        int answerI = 1;
//
//        for (int code: alphabetCounts) {
//
//            int count = code / 100;
//            char alphabet = (char) ('a' + (code % 100));
//
//            // 한 칸씩 띄어서 넣을 수 있는 공간보다 더 길면 만들 수 없다.
//            if (count > (N+1) / 2)
//                return "";
//
//            for (int i = 0; i < count; ++i) {
//                if (answerI >= N)
//                    answerI = 0;
//
//                answer[answerI] = alphabet;
//
//                answerI += 2;
//            }
//        }
//
//        return String.valueOf(answer);
//    }

//    public String reorganizeString(String S) {
//
//
//        int[] alphabetCounts = new int[26];
//
//        for(int si = 0; si < S.length(); si++) {
////            System.out.println(S.charAt(si) - 'a');
//
//            alphabetCounts[S.charAt(si) - 'a']++;
//
//        }
//
////        for (int alphabetCount : alphabetCounts) {
////            System.out.print(alphabetCount + " ");
////        }
//
//        StringBuilder rearrangedS = new StringBuilder();
//        int beforeIndex = 0;
//
//        for(int alphabetI = 0; alphabetI < alphabetCounts.length; alphabetI++) {
//            if(alphabetCounts[alphabetI] > 0) {
//                rearrangedS.append((char)(alphabetI + 'a'));
//                beforeIndex = alphabetI;
//                alphabetCounts[alphabetI]--;
//                break;
//            }
//        }
//
////        System.out.println("rearrangedS = " + rearrangedS);
//
//        int beforeLength = 0;
//
//        while(rearrangedS.length() == beforeLength + 1){
//
//            beforeLength++;
//
//            for(int alphabetI = 0; alphabetI < alphabetCounts.length; alphabetI++) {
//
//                if(alphabetCounts[alphabetI] > 0 && alphabetI != beforeIndex) {
//                    rearrangedS.append((char)(alphabetI + 'a'));
//                    beforeIndex = alphabetI;
//                    alphabetCounts[alphabetI]--;
//                    break;
//                }
//            }
//        }
//
//        System.out.println("rearrangedS = " + rearrangedS);
//
//        if(S.length() == rearrangedS.length())
//            return rearrangedS.toString();
//        else
//            return "";
//    }

}
