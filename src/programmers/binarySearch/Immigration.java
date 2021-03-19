package programmers.binarySearch;

import java.util.*;

/**
 * 
 * 헷갈렸던 부분
 * - 이분 탐색으로 배열의 인덱스만 찾을거라는 고정관념
 * - 답이 될 수 있는 최솟값과 최댓값을 가지고 이분탐색을 통해 정답을 찾아갈 수 있다.
 * - long answer = 10000000 * 1000000;
 *      - 우측 항이 둘다 int형이기 때문에 더한 값도 int형이 된다.
 *      - int의 범위를 벗어난다면 answer에는 알 수 없는 값이 초기화된다.
 *      - 해결 방법
 *          - long answer = 10000000 * 1000000L; // 둘 중 하나를 long으로 캐스팅하면 계산했을 때 long이 된다.
 *          - int형 변수일 때는 (long) 으로 캐스팅 해주면 된다.
 * 
 * 포인트
 * - 최솟값 : 1
 * - 최댓값 : n * 1,000,000,000 (times = {100000000} 일 경우)
 * - numPassed += targetTime / times[i]; : 각 심사관이 심사할 수 있는 인원
 * - 전부 더 했을 때 numPassed가 n 이상이어야 답이 될 수 있다.
 */

public class Immigration {

    public static void main(String[] args) {

        Immigration immigration = new Immigration();

//        int n = 10;
//        int[] times = {7,10,15,20};
        int n = 3;
        int[] times = {1000000000, 1000000000, 1000000000};

//        System.out.println(immigration.solution(n, times));

//        long number = 1000000000 * 1000000000L;
//        System.out.println("number = " + number);
    }

    public long solution(int n, int[] times) {
        Arrays.sort(times);
        return binerySearch(times, n, times[times.length - 1]);
    }


    public long binerySearch(int[] times, int n, long maxTime){

        long minRequiredTime = 1;
        long maxRequiredTime = maxTime * n;
        long requiredTime = Long.MAX_VALUE;

        while(minRequiredTime <= maxRequiredTime){
            long midIndex = (minRequiredTime + maxRequiredTime) / 2;

            if(isPassed(times, n, midIndex)){
                requiredTime = Math.min(requiredTime, midIndex);
                maxRequiredTime = midIndex - 1;
            } else {
                minRequiredTime = midIndex + 1;
            }
        }
        return requiredTime;
    }

    public boolean isPassed(int[] times, int n, long targetTime){
        long numPassed = 0;

        for(int i = 0 ; i < times.length ; ++i){
            numPassed += targetTime / times[i];
        }

        if(numPassed >= n)
            return true;
        else
            return false;
    }

//    public long solution(int n, int[] times) {
//        long answer = 0;
//
//        Arrays.sort(times);
//
//        Queue<long[]> waitingQueue = new PriorityQueue<>(new Comparator<long[]>() {
//            @Override
//            public int compare(long[] o1, long[] o2) {
//                return Long.compare(o1[0]+o1[1], o2[0]+o2[1]);
//            }
//        });
//
//        for(int timesI = 0; timesI < times.length; timesI++) {
//
//            int time = times[timesI];
//
//            answer = time;
//
//            if(timesI == n - 1)
//                return answer;
//
//            waitingQueue.add(new long[]{time, time});
//
//        }
//
//        int currentPerson = times.length;
//
//        while(currentPerson < n) {
//
//            long[] currentTime = waitingQueue.poll();
//            answer = currentTime[0]+currentTime[1];
//
//            waitingQueue.add(new long[]{currentTime[0]+currentTime[1], currentTime[1]});
//
//            currentPerson++;
//        }
//
//
//        return answer;
//    }

}
