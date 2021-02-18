package programmers.DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TravelRoute {

	public static void main(String[] args) {
		
//		String[][] tickets = {{"ICN","JFK"},{"JFK","ICN"}, {"ICN", "ATL"}};
		
//		String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		
		String[] answer = solution(tickets);
		
		for(int answerI = 0; answerI < answer.length; answerI++) {
			System.out.print(answer[answerI] + " ");
		}

	}
	
	private static List<List<String>> routes;
	
	public static String[] solution(String[][] tickets) {
		
		routes = new ArrayList<>();
		
		List<String> oneOfRoute = new ArrayList<>();
		
		oneOfRoute.add("ICN");
		
		doDFS(tickets, oneOfRoute);
		
		Collections.sort(routes, new Comparator<List<String>>(){

			@Override
			public int compare(List<String> o1, List<String> o2) {
				
				for(int oi = 0; oi < o1.size(); oi++) {
					
					int compareResult = o1.get(oi).compareTo(o2.get(oi));
					
					if(compareResult > 0) return 1;
					else if(compareResult < 0) return -1;
				
				}
				
				return 0;
			}

		});
		
		
		String[] answer = routes.get(0).toArray(new String[routes.get(0).size()]);
		
		return answer;
	}
	
	public static void doDFS(String[][] tickets, List<String> oneOfRoute) {
		
		String currentLocation = oneOfRoute.get(oneOfRoute.size()-1);
		int numPushed = 0;
		
		for(int ticketsI = 0; ticketsI < tickets.length; ticketsI++){
			
			if(tickets[ticketsI][0].equals(currentLocation)) {
				
				oneOfRoute.add(tickets[ticketsI][1]);
				String tempLocation = tickets[ticketsI][0];
				tickets[ticketsI][0] = "";
				doDFS(tickets, oneOfRoute);
				numPushed++;
				oneOfRoute.remove(oneOfRoute.size()-1);
				tickets[ticketsI][0] = tempLocation;
				
			}
		}
		
		if(numPushed == 0 && oneOfRoute.size() == tickets.length+1) {
			
			List<String> deepCopied = new ArrayList<>();
			
//			for(int oneOfRouteI = 0; oneOfRouteI < oneOfRoute.size(); oneOfRouteI++) {
//				deepCopied.add(oneOfRoute.get(oneOfRouteI));
//			}
			
			deepCopied.addAll(oneOfRoute);
			
			routes.add(deepCopied);
		}
		
		return;
		
	}
	

}
