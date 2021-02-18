package programmers.levelTest.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q1 {

	
	public static void main(String[] args) {
		
		
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		
		System.out.println(Arrays.toString(solution(record)));

	}
	
	
	
    public static String[] solution(String[] record) {
        
        Map<String, String> idToNickname = new HashMap<>();
        
        for(int recordI = 0; recordI < record.length; recordI++) {
        	
        	String[] oneOfRecord = record[recordI].split(" ");
        	
        	if(oneOfRecord[0].equals("Enter") || oneOfRecord[0].equals("Change"))
        		idToNickname.put(oneOfRecord[1], oneOfRecord[2]);
        	
        	
        }
        
//        Iterator<Entry<String,String>> entryIter = idToNickname.entrySet().iterator();
//        
//        while(entryIter.hasNext()) {
//        	Entry<String, String> idAndNickname = entryIter.next();
//        	System.out.println("id : " + idAndNickname.getKey());
//        	System.out.println("nickname : " + idAndNickname.getValue());
//        	System.out.println("--");
//        }
        
        List<String> results = new ArrayList<>();
        
        for(int recordI = 0; recordI < record.length; recordI++) {
        	
        	String[] oneOfRecord = record[recordI].split(" ");
        	
        	if(oneOfRecord[0].equals("Enter"))
        		results.add(idToNickname.get(oneOfRecord[1]) + "´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.");
        	else if(oneOfRecord[0].equals("Leave"))
        		results.add(idToNickname.get(oneOfRecord[1]) + "´ÔÀÌ ³ª°¬½À´Ï´Ù.");
        }
        
        String[] answer = results.toArray(new String[results.size()]);
        
        return answer;
    }

}
