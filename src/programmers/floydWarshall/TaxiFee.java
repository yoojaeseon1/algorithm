package programmers.floydWarshall;

// 합승 택시 요금

/**
 *
 * 헷갈렸던 부분
 * - 없었다.
 * - 플로이드 와샬 알고리즘을 몰라서 못 풀었다.
 *
 * 포인트
 * - 플로이드 와샬 알고리즘 사용
 * - answer = min(answer, minFares[s][via] + minFares[via][a] + minFares[via][b]);
 * - 출발지 -> 경유지 까지는 같이 이동하기 때문에 한 번만 추가
 * - 경유지 이후에는 나눠지므로 나눠진 값을 모두 추가
 * - 경유지가 a,b,s 다 될 수 있기 때문에 최단 경로(minFare)를 구한 다음 모든 가능성에 대해 최소 비용을 구해야 한다.
 */

public class TaxiFee {

    public static void main(String[] args) {

        TaxiFee q4 = new TaxiFee();

//        int n = 6;
//        int s = 4;
//        int a = 6;
//        int b = 2;
//        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};



//        int n = 7;
//        int s = 3;
//        int a = 4;
//        int b = 1;
//        int[][] fares = {{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}};


        int n = 6;
        int s = 4;
        int a = 5;
        int b = 6;
        int[][] fares =  {{2,6,6}, {6,3,7}, {4,6,7}, {6,5,11}, {2,5,12}, {5,3,20}, {2,4,8}, {4,3,9}};

        System.out.println(q4.solution(n,s,a,b,fares));
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {


        int[][] minFares = new int[n][n];

        s--;
        a--;
        b--;

        for(int fieldI = 0; fieldI < n; fieldI++) {
            for(int fieldJ = 0; fieldJ < n; fieldJ++) {
                if(fieldI != fieldJ)
                    minFares[fieldI][fieldJ] = 100000000;
            }
        }

        for(int faresI = 0; faresI < fares.length; faresI++) {
            int[] fare = fares[faresI];

            minFares[fare[0]-1][fare[1]-1] = fare[2];
            minFares[fare[1]-1][fare[0]-1] = fare[2];

        }

        for(int via = 0; via < n; via++) {
            for(int start = 0; start < n; start++) {
                if(via == start)
                    continue;
                for(int end = 0; end < n; end++) {
                    if(via == end || start == end)
                        continue;

                    int startToVia = minFares[start][via];
                    int viaToEnd = minFares[via][end];
                    int startToEnd = minFares[start][end];

                    minFares[start][end] = Math.min(startToEnd, startToVia + viaToEnd);

                }
            }
        }

        int answer = Integer.MAX_VALUE;

        for(int via = 0; via < n; via++) {

            answer = Math.min(answer, minFares[s][via] + minFares[via][a] + minFares[via][b]);

        }

        return answer;
    }


}

