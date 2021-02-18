package test;

import java.util.HashMap;
import java.util.Map;

public class NullInitTest {

	public static void main(String[] args) {
		
		Map<String, Integer> testMap = new HashMap<>();
		
//		testMap.put("haha", 1);
		
		
		System.out.println(testMap.getOrDefault("haha", 2));

	}

}
