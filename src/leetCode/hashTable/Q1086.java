package leetCode.hashTable;

import java.util.*;

public class Q1086 {

    public static void main(String[] args) {

        int[][] items = new int[][]{{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};

        items = new int[][]{{1,100},{7,100},{1,100},{7,100},{1,100},{7,100},{1,100},{7,100},{1,100},{7,100}};

        int[][] answer = highFive(items);

        for (int[] ints : answer) {
            System.out.println(Arrays.toString(ints));
        }

//        System.out.println(Arrays.toString(highFive(items)));

    }

    public static int[][] highFive(int[][] items) {

        Map<Integer, List<Integer>> idToScores = new TreeMap<>();

        for (int[] item : items) {

            List<Integer> scores = idToScores.getOrDefault(item[0], new ArrayList<>());

            scores.add(item[1]);

            idToScores.put(item[0], scores);

        }

        int[][] answer = new int[idToScores.size()][2];
        int answerI = 0;

        for (Map.Entry<Integer, List<Integer>> entry : idToScores.entrySet()) {

            List<Integer> scores = entry.getValue();

            Collections.sort(scores, Collections.reverseOrder());

            int sumTopFiveScores = 0;
            for(int scoresI = 0; scoresI < 5; scoresI++) {
                sumTopFiveScores += scores.get(scoresI);
            }

            answer[answerI++] = new int[]{entry.getKey(), sumTopFiveScores / 5};

        }


        return answer;
    }

}
