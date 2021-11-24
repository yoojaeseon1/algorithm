package backjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2178_4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] field = new int[N][M];

        StringBuilder oneLine = new StringBuilder();
        for(int fieldI = 0; fieldI < field.length; fieldI++) {
            oneLine.append(br.readLine());

            for(int fieldJ = 0; fieldJ < field[fieldI].length; fieldJ++) {

                field[fieldI][fieldJ] = oneLine.charAt(fieldJ) - 48;
            }
            oneLine.setLength(0);
        }

        int[] dx = {0,1,0,-1};
        int[] dy = {-1,0,1,0};

        Queue<int[]> fieldQueue = new LinkedList<>();

        fieldQueue.add(new int[]{0,0});
        field[0][0] = 0;

        while(!fieldQueue.isEmpty()) {
            int[] currentPosition = fieldQueue.poll();
            int currentX = currentPosition[0];
            int currentY = currentPosition[1];
            for(int di = 0; di < dx.length; di++) {

                int movedX = currentX + dx[di];
                int movedY = currentY + dy[di];

                if(movedX >= 0 && movedX < M && movedY >= 0 && movedY < N
                        && field[movedY][movedX] == 1) {
                    field[movedY][movedX] = field[currentY][currentX] + 1;
                    fieldQueue.add(new int[]{movedX, movedY});
                }
            }
        }

        System.out.println(field[N-1][M-1] + 1);
    }

}
