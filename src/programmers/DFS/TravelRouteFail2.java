package programmers.DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TravelRouteFail2 {
	
	public static void main(String[] args){
		
		
//		ReachableLocation location2 = new ReachableLocation("bbc", 2);
//		ReachableLocation location1 = new ReachableLocation("abc", 1);
//		
//		List<ReachableLocation> locations = new ArrayList<>();
//		
//		locations.add(location2);
//		locations.add(location1);
//		
//		System.out.println(locations.get(0).getLocation());
//		System.out.println(locations.get(1).getLocation());
//		
//		Collections.sort(locations, new LocationComparator());
//		System.out.println(locations.get(0).getLocation());
//		System.out.println(locations.get(1).getLocation());
		
		
//		String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
//		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		
		String[][] tickets = {{"ICN","JFK"},{"JFK","ICN"}, {"ICN", "ATL"}};
		
		String[] answer = solution(tickets);
		
		for(int answerI = 0; answerI < answer.length; answerI++) {
			System.out.print(answer[answerI] + " ");
		}
		
		
		
	}
	
    public static String[] solution(String[][] tickets) {
		
        
        
        List<String> route = new ArrayList<>();
        
        int numUsedTicket = 0;
        
        route.add("ICN");
        while(numUsedTicket < tickets.length) {
        	
        	String currentLocation = route.get(route.size()-1);
        	
        	List<ReachableLocation> reachables = new ArrayList<>();
        	
        	for(int ticketsI = 0; ticketsI < tickets.length; ticketsI++) {
        		
        		if(tickets[ticketsI][0].equals(currentLocation)) {
        			
        			reachables.add(new ReachableLocation(tickets[ticketsI][1], ticketsI));	
        		}
        		
        	}
        	
        	if(reachables.size() > 0) {
        		
        		if(reachables.size() > 1) Collections.sort(reachables, new ReachablesComparator());
        		
        		route.add(reachables.get(0).getLocation());
        		
        		tickets[reachables.get(0).getTicketIndex()][0] = "";
        		numUsedTicket++;
        		
        	}
        	
        }
        
//        for(int routeI = 0; routeI < route.size(); routeI++) {
//        	System.out.print(route.get(routeI) + " ");
//        }
        
        
        String[] answer = route.toArray(new String[route.size()-1]);
        
        return answer;
        
    }
	
	

}

class ReachableLocation{
	
	private String location;
	private int ticketIndex;
	
	
	public ReachableLocation() {
		
	}


	public ReachableLocation(String location, int ticketIndex) {
		this.location = location;
		this.ticketIndex = ticketIndex;
	}

	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public int getTicketIndex() {
		return ticketIndex;
	}


	public void setTicketIndex(int ticketIndex) {
		this.ticketIndex = ticketIndex;
	}

}

class ReachablesComparator implements Comparator<ReachableLocation> {

	@Override
	public int compare(ReachableLocation o1, ReachableLocation o2) {
		
		return o1.getLocation().compareTo(o2.getLocation());
	}
	
}
