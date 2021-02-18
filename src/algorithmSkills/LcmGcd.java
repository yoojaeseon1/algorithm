package algorithmSkills;

public class LcmGcd {
	
	
	public static void main(String[] args) {
		
		int[] arr = {6,12,18};
		
		
		
		System.out.println(solution(arr));
		
		
//		System.out.println(gcd(arr));

	}
	
	public static int solution(int[] arr) {
		
	      int answer = lcm(arr);
	      
	      return answer;
	  }
	
	//lcm(multiple numbers)
	
	public static int lcm(int[] num) {
		
		int answer = num[0];
		int small = 0;
		int big = 0;
		
		for(int ni = 1; ni < num.length ; ni++ ){
			small = Math.min(answer,  num[ni]);
			big = Math.max(answer, num[ni]);
			
			answer = (small * big) / gcd(small, big);
		}
		
		return answer;
		
	}
	
	// gcd(two numbers)
	
	public static int gcd(int small, int big) {
		
		int answer = 0;
		
		for(int i = 1; i <= small; i++) {
			if(small % i == 0 && big % i == 0) answer = i;
		}
//		System.out.println("gcd : " + answer);
		return answer;
	}
	
	// gcd(multiple numbers)
	
	public static int gcd(int[] nums) {
		
		int answer = nums[0];
		
		for(int ni = 1; ni < nums.length; ni++) {
			
			answer = gcd(answer, nums[ni]);
			
		}
		
		System.out.println("gcd : " + answer);
		return answer;

	}

}
