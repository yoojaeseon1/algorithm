package programmers.heap;

public class RamenFactoryFail {

	public static void main(String[] args) {
		
		int stock = 4;
		int[] dates = {4,10,15};
		int[] supplies = {20,5,10};
		int k = 30;
		
		System.out.println(solution(stock,dates,supplies,k));
	
	}
	
	
	
    public static int solution(int stock, int[] dates, int[] supplies, int k) {
    	
        int numSupplyment = 0;
        
        int today = 0;
        int supplyIndex = -1;
        
        for(int datesI = 0; datesI < dates.length; datesI = supplyIndex+1) {
            
            int supplyAmount = -1;
            
            System.out.println("1 datesI : " + datesI);
            while(true) {
                
            	System.out.println("2  datesI : " + datesI);
                if(datesI < dates.length && dates[datesI] <= today+stock) {
                    if(supplyAmount < dates[datesI] + supplies[datesI])
                        supplyAmount = supplies[datesI];
                        supplyIndex = datesI;
                        
                } else
                    break;
                datesI++;
            }
            
            today += stock;
            stock = supplyAmount;
            numSupplyment++;
            
            if(today+stock >= k)
                return numSupplyment;
        }
		return supplyIndex;
    }

}