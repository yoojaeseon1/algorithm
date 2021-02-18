package programmers.heap;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class RamenFactory {

	public static void main(String[] args) {
		int stock = 4;
		int[] dates = {4,10,15};
		int[] supplies = {20,5,10};
		int k = 30;
		
		System.out.println(solution(stock,dates,supplies,k));

	}
	
    public static int solution(int stock, int[] dates, int[] supplies, int k) {
        int numSupplyment = 0;
        
        Queue<Integer> supplyQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int today = 0, datesI = 0; today < k;today++) {
            if(datesI < dates.length && today == dates[datesI])
            	supplyQueue.add(supplies[datesI++]);

            if(stock == 0) {
                stock += supplyQueue.poll();
                numSupplyment++;
            }
            
            stock--;
        }
        return numSupplyment;
    }

}
