package programmers.greedy;

import java.util.LinkedList;
import java.util.Queue;

public class LifeBoat {

	public static void main(String[] args) {
		
		
		String a= "zzz";
		
		Queue<String> queue = new LinkedList<>();
		
		
		queue.add("zzz");
		queue.add("aaa");
		queue.add("ccc");
		
		queue.remove("zzz");
		System.out.println(queue.poll());
		

	}
	
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if(cacheSize == 0) {
            answer = cities.length * 5;
            return answer;
        }
        
        Queue<String> citiesQueue = new LinkedList<>();
        
        for(String city : cities) {
            
            city = city.toUpperCase();
            
            if(citiesQueue.contains(city))
                answer++;
            else{
                if(citiesQueue.size() == cacheSize)
                    citiesQueue.poll();
                    
                citiesQueue.add(city);
                answer += 5;
            }
        }
        
        
        return answer;
    }

}
