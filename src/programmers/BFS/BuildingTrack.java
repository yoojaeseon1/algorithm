package programmers.BFS;

import java.util.LinkedList;
import java.util.Queue;

/*

	헷갈렸던 부분
	- 알고리즘 선택
		- DP인줄 알았다. 예전 카카오 문제중에 비슷한 형식의 문제(보행자 천국)가 있어서 그럴거라고 생각했다.
		- 보행자 천국은 가능한 경로의 수를 구하는 것이었다.
		- 이 문제는 최소 비용의 경로를 구하는 것이기 때문에 BFS가 적절하다.

	포인트
	- 이전과 같은 방향인지 확인하는 부분
		- 방향으로 di를 넣어 다음 좌표에서 움직일 지점의 di가 같은지 확인
		- 이전 방향은 탐색은 하지만 방향이 정 반대 방향이라 600원이 추가되고 비용이 더 크므로 enqueue되지 않는다.

 */

public class BuildingTrack {

    public static void main(String[] args) {

        BuildingTrack test = new BuildingTrack();


        int[][] board = {{0,0,0},{0,0,0},{0,0,0}};



        board = new int[][]{{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};

        board = new int[][]{{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}};
        System.out.println(test.solution(board));

        board = new int[][]{{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}};


    }


    public int solution(int[][] board) {

        int[] dx = {0,1,0,-1};
        int[] dy = {-1,0,1,0};
        int n = board.length;
        int minCost = Integer.MAX_VALUE;

        Queue<PositionBuildingTrack> positionQueue = new LinkedList<>();

        positionQueue.add(new PositionBuildingTrack(0,0,-1,0));

        while(!positionQueue.isEmpty()) {

            PositionBuildingTrack position = positionQueue.poll();

            int x = position.getX();
            int y = position.getY();
            int cost = position.getCost();
            int direction = position.getDirection();

            if(x == n-1 && y == n-1) {
                minCost = Math.min(minCost, cost);
            }

            for(int di = 0; di < dx.length; di++) {
                int movedX = x + dx[di];
                int movedY = y + dy[di];
                int movedCost = cost;

                if(movedX < 0 || movedX >= board[0].length || movedY < 0 || movedY >= board.length)
                    continue;

                if(direction == - 1 || direction == di) {
                    movedCost += 100;
                } else
                    movedCost += 600;

                int beforeMovedCost = board[movedY][movedX];

                if(beforeMovedCost == 0 || beforeMovedCost >= movedCost) {

                    board[movedY][movedX] = movedCost;
                    positionQueue.add(new PositionBuildingTrack(movedX, movedY, di, movedCost));

                }
            }

        }

        return minCost;
    }
}

class PositionBuildingTrack{

    private int x;
    private int y;
    private int direction;
    private int cost;

    public PositionBuildingTrack(int x, int y, int direction, int cost) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.cost = cost;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDirection() {
        return direction;
    }

    public int getCost() {
        return cost;
    }
}