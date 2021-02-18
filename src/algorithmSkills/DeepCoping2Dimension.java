package algorithmSkills;

public class DeepCoping2Dimension {

	public static void main(String[] args) {
		
		
		String[][] source = {{"a","b","c"}, {"d","e"},{"f","g","h","i"}};
		
		String[][] copied = deepCopy2Dimension(source);
		
		for(int copiedI = 0; copiedI < copied.length; copiedI++) {
			for(int copiedJ = 0; copiedJ < copied[copiedI].length; copiedJ++) {
				
				System.out.print(copied[copiedI][copiedJ] + " ");
				
			}
			System.out.println(", length : " + copied[copiedI].length);
			System.out.println();
		}

	}
	
	
	public static String[][] deepCopy2Dimension(String[][] source){
		
		String[][] copied = new String[source.length][];
		
		for(int copiedI = 0; copiedI < copied.length; copiedI++) {
			
			copied[copiedI] = new String[source[copiedI].length];
 			System.arraycopy(source[copiedI], 0, copied[copiedI], 0, copied[copiedI].length);
			
			
		}
		
		return copied;
		
		
	}

}
