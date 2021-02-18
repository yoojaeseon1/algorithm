package programmers.hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CamouflageRetry {

	public static void main(String[] args) {

		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		

//		String[][] clothes = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
		
		System.out.println(solution(clothes));
		
	}
	
    public static int solution(String[][] clothes) {
       
        Map<String, Integer> typeToCount = new HashMap<>();
        
        for(int clothesI = 0; clothesI < clothes.length; clothesI++) {
        	
        	String[] currentClothe = clothes[clothesI];
        	
        	int count = typeToCount.getOrDefault(currentClothe[1], 0);
        	
        	if(count > 0)
        		typeToCount.put(currentClothe[1], count+1);
        	else
        		typeToCount.put(currentClothe[1], 1);
        		
        	
        }
        
        Iterator<Integer> countIter = typeToCount.values().iterator();
        int answer = 1;
        
        while(countIter.hasNext()) {
        	answer *= (countIter.next() + 1);
        }
        
        answer--;
        
        return answer;
    }

}
