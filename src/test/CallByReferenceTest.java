package test;

public class CallByReferenceTest {

	public static void main(String[] args) {
		
		Person a = new Person("jaeseon");
		
		System.out.println(a.getName());
		
		changeName(a);
		
		System.out.println(a.getName());

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
