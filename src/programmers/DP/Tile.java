package programmers.DP;

public class Tile {

	
	public static void main(String[] args){
		
//		System.out.println(solution(5));
		System.out.println(solution(80));
		
		
		
	}
	
	
	public static long solution(int N) {
        
        long[] rectangles = new long[N+1];
        
        rectangles[1] = 1;
        rectangles[2] = 1;
        
        if(N == 1) return 4;
        
        for(int rectI = 3; rectI < rectangles.length; rectI++) {
        	
        	rectangles[rectI] = rectangles[rectI-1] + rectangles[rectI-2];
//        	System.out.println(rectangles[rectI]);
        	
        }
        return (rectangles[N] + rectangles[N-1]) * 2 + rectangles[N] * 2;
    }
	
	
}
