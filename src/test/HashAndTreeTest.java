package test;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class HashAndTreeTest {

	public static void main(String[] args) {
		
		Set<String> testSet = new TreeSet<>();
//		Set<Integer> testSet = new TreeSet<>();
		
		
		testSet.add("1100");
		testSet.add("100");
		testSet.add("111");
		
//		testSet.add(1100);
//		testSet.add(100);
//		testSet.add(111);
		
		Iterator<String> testIter = testSet.iterator();
//		Iterator<Integer> testIter = testSet.iterator();
		
		while(testIter.hasNext()) {
			System.out.println(testIter.next());
		}
		
		

	}

}
