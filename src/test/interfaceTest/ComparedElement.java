package test.interfaceTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparedElement implements Comparator<ComparedElement> {
	
	
	private Integer comparedNumber;
	
	public ComparedElement() {
		// TODO Auto-generated constructor stub
	}
	
	public ComparedElement(Integer comparedNumber) {
		
		this.comparedNumber = comparedNumber;
		
	}
	
	@Override
	public int compare(ComparedElement o1, ComparedElement o2) {
		
		return o2.comparedNumber.compareTo(o1.comparedNumber);
	}
	
	public static void main(String[] args) {
		
		List<ComparedElement> list = new ArrayList<>();
		
		list.add(new ComparedElement(5));
		list.add(new ComparedElement(1));
		list.add(new ComparedElement(10));
		
		Collections.sort(list, new ComparedElement());
		
		for(ComparedElement number : list) {
			System.out.println(number.comparedNumber);
		}
		
		Thread printer = new Thread(System.out::println);
		
		printer.run();
		
	}
}
