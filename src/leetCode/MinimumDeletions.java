package leetCode;

import java.util.*;


/**
 * 헷갈렸던 부분
 * - 문제를 너무 복잡하게 생각했다. 길이가 긴 것 부터 유일하지 않으면 가장 가까운 길이 중 유일한 길이만큼 줄이면 된다.
 * - 겹치는 것은 최소한으로 줄여서 유일한 길이를 찾으면 된다.
 *
 */


public class MinimumDeletions {

    public int minDeletions(String s) {
        Map<Character, Integer> alphabetToCount = new HashMap<>();

        for(int si = 0; si < s.length(); si++) {
            char alphabet = s.charAt(si);
            int count = alphabetToCount.getOrDefault(alphabet, 0);
            if(count == 0) {
                alphabetToCount.put(alphabet, 1);
            } else{
                alphabetToCount.put(alphabet, count+1);
            }
        }

        Queue<Integer> frequencyQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (Integer value : alphabetToCount.values()) {
            frequencyQueue.add(value);
        }

        int numDeletion = 0;

        while(!frequencyQueue.isEmpty()) {
            int frequency = frequencyQueue.poll();
            if(frequencyQueue.isEmpty())
                return numDeletion;

            if(frequency == frequencyQueue.peek()) {
                if(frequency > 1) {
                    frequencyQueue.add(frequency-1);
                }

                numDeletion++;

            }

        }

        return numDeletion;
    }
}
