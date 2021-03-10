package leetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 문제번호 : 688
 *
 * 헷갈렸던 부분
 * - 체스판 + 탐색 -> 이차원 배열 탐색 -> DFS 아니면 BFS 일 것이라고 판단
 * - K의 범위를 보고 완전탐색은 아니라고 판단 했어야 한다.
 *
 * 알고리즘
 * - DP사용
 * - dp1 : 해당 좌표에 이동하기 위한 확률이 들어있다.(전부 더하면 정답)
 * - dp2 : dp1에서 다음 이동가능한 좌표로 갈 때 "dp1까지의 확률 / 8.0" 으로 다음 지점의 확률을 계산해준다.
 * - dp1을 dp2로 초기화 해주고 새로운 dp1과 dp2로 다음 움직임에 대한 확률을 구해준다.
 *
 */

public class KnightProbability {

    public static void main(String[] args) {

        KnightProbability knightProbability = new KnightProbability();

        int N = 3;
        int K = 2;
        int r = 0;
        int c = 0;

//        int N = 8;
//        int K = 15;
//        int r = 6;
//        int c = 4;

//        int N = 3;
//        int K = 3;
//        int r = 0;
//        int c = 0;

        System.out.println(knightProbability.knightProbability(N,K,r,c));

    }

    private int[] dc;
    private int[] dr;
    private int[] remainProbabilities;

    public KnightProbability() {

        dc = new int[]{1,2,2,1,-1,-2,-2,-1};
        dr = new int[]{-2,-1,1,2,2,1,-1,-2};

   }

    public double knightProbability(int N, int K, int r, int c) {

        double[][] dp1 = new double[N][N];
        double[][] dp2 = new double[N][N];

        dp1[r][c] = 1.0;

        for (int numMoved = 0; numMoved < K; numMoved++) {

            for (int dpI = 0; dpI < N; dpI++) {
                for (int dpJ = 0; dpJ < N; dpJ++) {

                    if (dp1[dpI][dpJ] > 0.0) {

                        for (int di = 0; di < dc.length; di++) {
                            int movedC = dpJ + dc[di];
                            int movedR = dpI + dr[di];
                            if (movedC >= 0
                                    && movedC < N
                                    && movedR >= 0
                                    && movedR < N
                            ) {

                                dp2[movedR][movedC] += dp1[dpI][dpJ] / 8.0;

                            }
                        }

                    }
                }

            }

            dp1 = dp2;
            dp2 = new double[N][N];

        }

        double answer = 0.0;

        for(int dpI = 0; dpI < N; dpI++) {
            for(int dpJ = 0; dpJ < N; dpJ++) {

                answer += dp1[dpI][dpJ];

            }
        }


        return answer;

    }

//    public double knightProbability(int N, int K, int r, int c) {
//
//        if(K == 0)
//            return 1;
//
//        double answer = 1.0;
//
//        Queue<int[]> fieldQueue = new LinkedList<>();
//
//        for(int di = 0; di < dx.length; di++) {
//            int movedX = c + dx[di];
//            int movedY = r + dy[di];
//            if(movedX >= 0
//                    && movedX < N
//                    && movedY >= 0
//                    && movedY < N) {
//                fieldQueue.add(new int[]{movedX, movedY, c, r});
//            }
//        }
//
//        int beforeQueueSize = fieldQueue.size();
//
//        int numMoved = 1;
//
//        if(beforeQueueSize > 0) {
//            answer = beforeQueueSize / 8.0;
//        }
//
////        System.out.println("answer = " + answer);
//
//        while(!fieldQueue.isEmpty() && numMoved < K) {
//
//            for(int numDequeued = 0; numDequeued < beforeQueueSize; numDequeued++) {
//
//                int[] currentPosition = fieldQueue.poll();
//                int currentX = currentPosition[0];
//                int currentY = currentPosition[1];
//                int beforeX = currentPosition[2];
//                int beforeY = currentPosition[3];
//
//                for(int di = 0; di < dx.length; di++) {
//                    int movedX = currentX + dx[di];
//                    int movedY = currentY + dy[di];
//
//                    if(movedX >= 0
//                            && movedX < N
//                            && movedY >= 0
//                            && movedY < N
//                            && !(movedX == beforeX && movedY == beforeY)
//                    ) {
////                        System.out.println("movedX = " + movedX);
////                        System.out.println("movedY = " + movedY);
////                        System.out.println("========");
//                        fieldQueue.add(new int[]{movedX, movedY, currentX, currentY});
//                    }
//                }
//            }
//
//            beforeQueueSize = fieldQueue.size();
////            System.out.println("beforeQueueSize = " + beforeQueueSize);
//
//            if(beforeQueueSize > 0) {
//                answer *= beforeQueueSize / 8.0;
//            }
//
//            numMoved++;
//
//
//        }
//
//        if(answer == 1.0)
//            return 0;
//
//        return answer;
//    }



//    public double knightProbability(int N, int K, int r, int c) {
//
//        double answer = 1.0;
//
//        remainProbabilities = new int[K+1];
//
//        searchChessBoard(N, r, c, -1, -1, 1, K);
//
////        System.out.println(Arrays.toString(remainProbabilities));
//
//
//
//        for(int remainI = 1; remainI < remainProbabilities.length; remainI++) {
//            answer *= remainProbabilities[remainI] / 8.0;
//        }
//
////        System.out.println(0.25 *0.25);
//
//        return answer;
//    }
//
//    public void searchChessBoard(int N, int currentX, int currentY, int beforeX, int beforeY, int numMoved, int k) {
//
//        if(numMoved > k)
//            return;
//
//
//        for(int di = 0; di < dx.length; di++) {
//            if(currentX + dx[di] >= 0
//                    && currentX + dx[di] < N
//                    && currentY + dy[di] >= 0
//                    && currentY + dy[di] < N
//                    && !((currentX+dx[di]) == beforeX && (currentY+dy[di]) == beforeY)
//            ) {
//
//                remainProbabilities[numMoved]++;
//                searchChessBoard(N, currentX+dx[di], currentY+dy[di], currentX, currentY, numMoved+1, k);
//            }
//        }
//    }

}
