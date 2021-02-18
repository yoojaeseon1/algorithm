package programmers.stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class BridgeTruck {
	
	public static void main(String[] args) {

		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7,4,5,6};
//		int bridge_length = 100;
//		int weight = 100;
//		int[] truck_weights = {10};
		
		System.out.println("answer : " + solution(bridge_length, weight, truck_weights));
		

	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        
		int answer = 0;
        		
		Queue<int[]> truckQueue = new LinkedList<>();
		int[] truckInfo = {1,truck_weights[0]};
		truckQueue.add(truckInfo);
		int ti = 1;
		int currentWeight = truck_weights[0];
		int currentTime = 1;
		
		while(truckQueue.size() > 0) {

			currentTime++;
			
			int[] headTruck = truckQueue.peek();
			
			if(headTruck[0]+bridge_length == currentTime) {
				answer = headTruck[0] + bridge_length;
				currentWeight -= headTruck[1];
				truckQueue.poll();
//				System.out.println(answer);
			}
			
			if(truck_weights.length > ti && truck_weights[ti] + currentWeight >= weight) {
				truckInfo = new int[2];
				truckInfo[0] = currentTime;
				truckInfo[1] = truck_weights[ti++];
				truckQueue.add(truckInfo);
				currentWeight += truckInfo[1];
//				System.out.println("enqueue : " + truckInfo[0]);
			}
		}

        return answer;
    }
}
