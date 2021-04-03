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

}
