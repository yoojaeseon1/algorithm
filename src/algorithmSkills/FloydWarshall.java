package algorithmSkills;

public class FloydWarshall {


    /*
     * 플로이드 와샬 알고리즘
     * - 모든 노드의 부분 경로에 대해서 가중치의 합이 최소가 되는 경로를 구하는 알고리즘
     * - DP를 기반으로 한다.
     * - O(n^3) 이지만 DFS보다 훨씬 효율적이다.(카카오에서도 효율성 통과하는 것으로 봐선 괜찮다.)
     *
     * 포인트
     * - minFare[start][end] : start -> end로 가는 최소 비용(경유한 것까지 포함)
     * - minFare[start][end] = Math.min(minFare[start][end], minFare[start][via]+minFare[via][end])
     * - start == via 또는 end == via 또는 start == end인 경우는 제외한다.
     *      - 경유지의 의미가 없어지니까
     *          - [start][via] -> [via][end] 일 때, start == via면 [start][via]==0이기 때문에 [via][end]만 계산해도 되는 것이기 때문이다.
     *          - 그 경우는 [via][end]가 [start][end]일 경우에 계산 된다. 여기서 한 번 더 할 필요가 없다.(via == end의 경우도 마찬가지)
     *          - start == end는 minFare[start][end] == 0이기 때문에 사전에 0으로 초기화 되어있기 때문에 한 번 더 할 필요가 없다.
     *      
     *
     *
     * 주의 사항
     * - 직접 경로가 없는 경우 Integer.MAX_VALUE로 하면 안된다.
     *       - MAX_VALUE에 값을 더해 int 범위를 초과하면 예측 불가능한 값이 나온다.
     *       - 해결 방법
     *          - MAX_VALUE보다 적은 적당한 값(문제에서 모든 경로에서 나올 수 있는 비용의 최댓 값)으로 정한다.
     *
     * 
     */

    /**
     * @param n : 노드 개수
     * @param a : 도착 노드 번호
     * @param b : 도착 노드 번호
     * @param fares : [출발 노드번호, 도착 노드번호, 비용]
     * @return
     */
    public int searchFloydWarshall(int n, int a, int b, int[][] fares) {

        // minFare[a][b] : a -> b로 가는 최소 비용(경유한 것까지 포함)
        int[][] minCost = new int[n][n];

        for(int fieldI = 0; fieldI < n; fieldI++) {
            for(int fieldJ = 0; fieldJ < n; fieldJ++) {
                if(fieldI != fieldJ)
                    minCost[fieldI][fieldJ] = 100000000; // 직접 경로가 없는 경우(아래에서 직접 경로를 초기화 해주면 초기화 안된 부분만 이 값이 된다.)
            }
        }

        for(int faresI = 0; faresI < fares.length; faresI++) {
            int[] fare = fares[faresI];

            minCost[fare[0]-1][fare[1]-1] = fare[2];
            minCost[fare[1]-1][fare[0]-1] = fare[2];

        }

        for(int via = 0; via < n; via++) {
            for(int start = 0; start < n; start++) {
                if(via == start)
                    continue;
                for(int end = 0; end < n; end++) {

                    if(via == end || start == end)
                        continue;

                    int startToEnd = minCost[start][end];
                    int startToVia = minCost[start][via];
                    int viaToEnd = minCost[via][end];

                    minCost[start][end] = Math.min(startToEnd, startToVia + viaToEnd);

                }
            }
        }


        return minCost[a][b];
    }


// 출발지 지정, 특정 지점 경유 후 도착지가 2개로 나눠지는 경우의 최소 비용(합승택시요금(2021 카카오 공채))
    /**
     * @param n : 노드 개수
     * @param s : 출발 노드 번호
     * @param a : 도착 노드 번호
     * @param b : 도착 노드 번호
     * @param fares : [출발, 도착, 비용]
     * @return
     */
    public int searchFloydWarshall(int n, int s, int a, int b, int[][] fares) {

        // minFare[a][b] : a -> b로 가는 최소 비용(경유한 것까지 포함)
        int[][] minFares = new int[n][n];

        s--;
        a--;
        b--;

        for(int fieldI = 0; fieldI < n; fieldI++) {
            for(int fieldJ = 0; fieldJ < n; fieldJ++) {
                if(fieldI != fieldJ)
                    minFares[fieldI][fieldJ] = 100000000; // 직접 경로가 없는 경우(아래에서 직접 경로를 초기화 해주면 초기화 안된 부분만 이 값이 된다.)
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

                    int startToEnd = minFares[start][end];
                    int startToVia = minFares[start][via];
                    int viaToEnd = minFares[via][end];

                    minFares[start][end] = Math.min(startToEnd, startToVia + viaToEnd);

                }
            }
        }

        int answer = Integer.MAX_VALUE;

        
        // 특정 지점 경유 후 도착지가 2개로 나눠지는 경우의 최소 비용(합승택시요금(2021 카카오 공채))
//        for(int via = 0; via < n; via++) {
//
//            answer = Math.min(answer, minFares[s][via] + minFares[via][a] + minFares[via][b]);
//
//        }

        return answer;
    }
}
