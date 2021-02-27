package leetCode;


/**
 * 
 * 헷갈렸던 부분
 * - 두 개를 뽑아서 합치는 것이니까 조합으로 해결하려고 했다.
 * - n의 길이가 너무 길어서 조합으로 하면 시간초과가 된다.
 *
 * 해결 방법
 * - a % 60 == 0 && b % 60 == 0 과 (a % 60) + (b % 60) = 60 일 때 (a+b) % 60 == 0임을 사용해서 푼다.(완전 수학적인 문제)
 * 
 */

public class PairsOfSongs {

    public static void main(String[] args) {

        int[] time = {30,20,150,100,40};
//        int[] time = {60,60,60};

        System.out.println(numPairsDivisibleBy60(time));

    }

    static int numPairs;

//    public static int numPairsDivisibleBy60(int[] time) {
//
//        numPairs = 0;
//
//        selectSongs(time, 0, 0, 0);
//
//        return numPairs;
//
//    }

    public static int numPairsDivisibleBy60(int[] time) {
        int remainders[] = new int[60];
        int count = 0;

        for (int t: time) {
            if (t % 60 == 0) { // check if a%60==0 && b%60==0
                count += remainders[0];
            } else { // check if a%60+b%60==60
                count += remainders[60 - t % 60];
            }
            remainders[t % 60]++; // remember to update the remainders
        }
        return count;
    }

    public static void selectSongs(int[] source, int targetIndex, int sumDuration, int numSongs) {

        if(numSongs == 2) {


            if(sumDuration % 60 == 0) {
                numPairs++;
                return;
            }

        } else if(targetIndex == source.length) {
            return;
        } else {

            selectSongs(source, targetIndex+1, sumDuration+source[targetIndex], numSongs+1);
            selectSongs(source, targetIndex+1, sumDuration, numSongs);


        }

    }






}
