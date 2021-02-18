package programmers;

import java.util.Arrays;

public class StockPriceRetry {
	
	public static void main(String[] args) {
		
		int[] prices = {1, 2, 3, 2, 3};
		
		System.out.println(Arrays.toString(solution(prices)));
		
	}
	
    public static int[] solution(int[] prices) {
        
    	int[] answer = new int[prices.length];
    	
    	for(int pricesI = 0; pricesI < prices.length-1; pricesI++) {
    		
    		int currentPrice = prices[pricesI];
    		int notDecreasedTime = 0;
    		for(int pricesJ = pricesI+1; pricesJ < prices.length; pricesJ++) {
    			
    			notDecreasedTime++;
    			
    			if(currentPrice > prices[pricesJ])
    				break;
    			
    		}
    		
    		answer[pricesI] = notDecreasedTime;
    		
    	}

        return answer;
    }

}
