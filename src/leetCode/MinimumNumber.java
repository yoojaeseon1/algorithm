package leetCode;


/**
 * 
 * 헷갈렸던 부분
 * - 최소 날짜를 찾는 거라서 우선순위 큐를 사용해야 된다고 생각(문제를 많이 안풀어봐서 생긴 문제)
 *
 * 해결 방법
 * - 이분 탐색을 사용해서 찾으면 된다.
 * 
 */

public class MinimumNumber {

    public static void main(String[] args) {


//        int[] bloomDay = {1,10,3,10,2};
//        int m = 3;
//        int k = 1;

//        int m = 3;
//        int k = 2;

//        int[] bloomDay = {7,7,7,7,12,7,7};
//        int m = 2;
//        int k = 3;


//        int[] bloomDay = {1000000000,1000000000};
//        int m = 1;
//        int k = 1;


        int[] bloomDay = {1,10,2,9,3,8,4,7,5,6};
        int m = 4;
        int k = 2;


        System.out.println(minDays(bloomDay,m,k));

    }

    public static int minDays(int[] bloomDay, int m, int k) {



        int minBloomDay = Integer.MAX_VALUE;
        int maxBloomDay = Integer.MIN_VALUE;

        for(int bloomI = 0; bloomI < bloomDay.length; bloomI++) {

            int currentBloomDay = bloomDay[bloomI];

            minBloomDay = Math.min(minBloomDay, currentBloomDay);
            maxBloomDay = Math.max(maxBloomDay, currentBloomDay);

        }

        int result = -1;

        while(maxBloomDay >= minBloomDay) {

            int midBloomDay = (maxBloomDay + minBloomDay) / 2;

            if (isSufficient(bloomDay, midBloomDay, m, k)) {
                result = midBloomDay;
                maxBloomDay = midBloomDay - 1;
            } else {
                minBloomDay = midBloomDay + 1;
            }
        }

        return result;

    }

    public static boolean isSufficient(int[] bloomDay, int day, int m, int k) {

        int result = 0;
        int counter = 0;

        for(int bloomI = 0; bloomI < bloomDay.length; bloomI++) {

            if(bloomDay[bloomI] <= day && counter < k) {
                counter++;
            } else if(bloomDay[bloomI] > day && counter > 0)
                counter = 0;

            if(counter == k) {
                result++;
                counter = 0;
            }

        }

        return result >= m;


    }




}
