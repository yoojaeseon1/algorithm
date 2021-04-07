package programmers.exhaustiveSearching;

// 순위 검색

import java.util.*;

/**
 *
 * 헷갈렸던 부분
 * - 효율성을 보기 때문에 완전탐색은 아니라고 생각했다.
 * - 완전탐색 + DP 문제
 * - 재귀 할 때 절대 배열 / List 깊은 복사 하지 말자(무조건 시간초과 라고 생각하고 하나로 잘 돌려쓰자)
 *
 *
 * 포인트
 * - 전체 조건을 다 나눠서 조건에 해당하는 점수를 모아 놓는 것
 * - 조건 별로 점수 오름차순 정렬 후 이분 탐색(lower bound)으로 값을 찾는 것
 *
 */

public class SearchingRank {

    private int conditionsI;
    private Map<String, List<Integer>> conditionToPoints;

    public SearchingRank() {
        conditionToPoints = new HashMap<>();
    }

    public static void main(String[] args) {

        SearchingRank q3 = new SearchingRank();

        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

        System.out.println(Arrays.toString(q3.solution(info, query)));


    }

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        int answerI = 0;

        for(int infoI = 0; infoI < info.length; infoI++) {
            conditionsI = 0;
            String[] condition = info[infoI].split(" ");

            addCondition(condition, 0, Integer.parseInt(condition[4]));


        }

        for (List<Integer> value : conditionToPoints.values()) {
            Collections.sort(value);
        }


        for(int queryI = 0; queryI < query.length; queryI++) {

            String[] split = query[queryI].split(" and ");
            String[] queryCondition = new String[5];

            System.arraycopy(split, 0, queryCondition, 0, split.length-1);
            queryCondition[3] = split[3].split(" ")[0];
            queryCondition[4] = split[3].split(" ")[1];

            StringBuilder condition = new StringBuilder();
            for(int queryConditionI = 0; queryConditionI < queryCondition.length - 1; queryConditionI++) {
                condition.append(queryCondition[queryConditionI]);
            }

            List<Integer> points = conditionToPoints.get(condition.toString());

            int targetPoint = Integer.parseInt(queryCondition[4]);

            if(points == null) {
                answer[answerI++] = 0;
                continue;
            }

            int startIndex = 0;
            int endIndex = points.size()-1;

            while(startIndex <= endIndex){

                int midIndex= (startIndex + endIndex) / 2;

                if(points.get(midIndex) < targetPoint){
                    startIndex=midIndex+1;
                }else{
                    endIndex=midIndex-1;
                }
            }

            answer[answerI++] = points.size() - startIndex;
        }
        return answer;
    }

    public void addCondition(String[] source, int nextIndex, int point) {

        StringBuilder condition = new StringBuilder();

        for(int sourceI = 0; sourceI < source.length - 1; sourceI++) {
            condition.append(source[sourceI]);
        }

//        List<Integer> points = conditionToPoints.getOrDefault(condition.toString(), new ArrayList<>());
        List<Integer> points = conditionToPoints.get(condition.toString());
//
        if(points == null) {
            points = new ArrayList<>();
            points.add(point);
            conditionToPoints.put(condition.toString(), points);
        } else {
            points.add(point);
        }


        for(int sourceI = nextIndex; sourceI < source.length-1; sourceI++) {
            String currentCondition = source[sourceI];
            source[sourceI] = "-";
            addCondition(source, sourceI+1, point);
            source[sourceI] = currentCondition;
        }

    }

}
