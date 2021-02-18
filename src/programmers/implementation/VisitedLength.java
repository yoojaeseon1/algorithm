package programmers.implementation;

import java.util.HashMap;
import java.util.Map;

public class VisitedLength {
	
	public static void main(String[] args) {
		
//		String dirs = "LULLLLLLU";
//		String dirs = "ULURRDLLU";
//		String dirs = "UDRULDDDUU";
		String dirs = "RRRRRRRRRRRRL";
		
		solution(dirs);
		
		
	}
	
    public static int solution(String dirs) {
        int answer = 0;
        
        boolean[][][] road = new boolean[11][11][4];
        
        int currentX = 5;
        int currentY = 5;
        
        Map<Character, Integer> commandToIndex = new HashMap<>();
        commandToIndex.put('U', 0);
        commandToIndex.put('D', 1);
        commandToIndex.put('R', 2);
        commandToIndex.put('L', 3);
        
        for(int dirsI = 0; dirsI < dirs.length(); dirsI++) {
        	int nextX, nextY;
        	char command = dirs.charAt(dirsI);
        	if(command == 'U') {
        		nextX = currentX;
        		nextY = currentY-1;
        	}
        	else if(command == 'D') {
        		nextX = currentX;
        		nextY = currentY + 1;
        	} else if(command == 'R'){
        		nextX = currentX + 1;
        		nextY = currentY;
        	} else {
        		nextX = currentX - 1;
        		nextY = currentY;
        	}
 
        	
        	if(nextX < 0 || nextX > 10 || nextY < 0 || nextY > 10)
        		continue;
        	
        	int roadIndex = calculateNextRoad(command);
        	
        	if(road[nextY][nextX][roadIndex]) {
        		currentX = nextX;
        		currentY = nextY;
        	} else {
        		road[nextY][nextX][roadIndex] = true;
        		road[currentY][currentX][commandToIndex.get(command)] = true;
        		currentX = nextX;
        		currentY = nextY;
        		answer++;
        	}
     
        }
        
        
        
        return answer;
    }
    
    public static int calculateNextRoad(char command) {
    	
    	if(command == 'D')
    		return 0;
    	else if(command == 'U')
    		return 1;
    	else if(command == 'L')
    		return 2;
    	else
    		return 3;
    	
    }

}
