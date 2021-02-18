package leetCode;

public class Solution {

	public static void main(String[] args) {
			
		int[] nums = {3,2,1,0,4};
//		int[] nums = {2,3,1,1,4};
		
		System.out.println(canJump(nums));

	}
	
	static boolean canReach;
	
    public static boolean canJump(int[] nums) {
    	
    	if(nums.length == 1 && nums[0] == 0)
    		return true;
        canReach = false;
        
    	
        doDFS(nums, 0);
    	
    	return canReach;
    }
    
    public static void doDFS(int[] source, int currentIndex) {
    	if(canReach)
    		return;
    	int maxJump = source[currentIndex];
    	for(int sourceI = currentIndex+1; sourceI <= currentIndex + maxJump; sourceI++) {
    		if(sourceI >= source.length)
    			return;
    		if(sourceI == source.length-1) {
    			canReach = true;
    			return;
    		}
    		
    		doDFS(source, sourceI);
    		
    	}
    	
    }


}