package test;

import java.util.ArrayList;
import java.util.List;

public class CallByReferenceTest {

	public static void main(String[] args) {
		
//		Person a = new Person("jaeseon");
//		
//		System.out.println(a.getName());
//		
//		changeName(a);
//		
//		System.out.println(a.getName());
		
		String string = "1234";
		String string2 = "1234";


		System.out.println(string == string2);
//		System.out.println("string = " + string);
		changeString(string);

//		System.out.println("string = " + string);


		List<Integer> numbers = new ArrayList<>();

		Integer[] integers = numbers.toArray(new Integer[numbers.size()]);


	}

//	public static int[] calcNumbers() {
//
//		List<Integer> numbers = new ArrayList<>();
//
//		Integer[] integers = numbers.toArray(new Integer[numbers.size()]);
//
//		return integers;
//	}
	
	public static void changeString(String string) {
		string = "hahahoho";
	}
	
	public static void changeName(Person p) {
		p.setName("haha");
	}



}

class Person {
	
	
	private String name;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	public Person(String name) {
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	
}
