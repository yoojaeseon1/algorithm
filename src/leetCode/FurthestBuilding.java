package leetCode;

import java.util.PriorityQueue;
import java.util.Queue;


/**
 *
 * 헷갈렸던 부분
 * - 그리디로 벽돌을 먼저써서 해결하면 될 것이라고 생각했다.
 * - 벽돌, 사다리 둘 중 하나를 선택할 수 있기 때문에 한 개를 먼저 쓰는 것이 해결책이 될리 없었다.
 *
 * 해결 방법
 * - 최소 힙(Priority Queue)을 사용해서 벽돌 or 사다리가 필요하면 큐에 다 넣고 사다리의 개수보다 커지면
 * dequeue를 해서 벽돌을 최소한 사용하도록 해서 해결
 *
 *
 */

public class FurthestBuilding {

    public static void main(String[] args) {


//        int[] heights = {4,2,7,6,9,14,12};
//        int bricks = 5;
//        int ladders = 1;

//        int[] heights = {4,12,2,7,3,18,20,3,19};
//        int bricks = 10;
//        int ladders = 2;

//        int[] heights = {14,3,19,3};
//        int bricks = 17;
//        int ladders = 0;

        int[] heights = {1,5,1,2,3,4,10000};
        int bricks = 4;
        int ladders = 1;


        System.out.println(furthestBuilding(heights, bricks, ladders));


    }

    public static int furthestBuilding(int[] heights, int bricks, int ladders) {


        Queue<Integer> queue = new PriorityQueue<>();

        int heightsI = 1;

        for(; heightsI < heights.length; heightsI++) {

            int needBricks = heights[heightsI] - heights[heightsI-1];

            if(needBricks > 0)
                queue.add(needBricks);

            if(queue.size() > ladders) {
                bricks -= queue.poll();

                if(bricks < 0)
                    return heightsI - 1;
            }
        }

        return heightsI - 1;

    }
}
