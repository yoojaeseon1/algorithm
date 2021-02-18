package test;

public class CastingTest {

	public static void main(String[] args) {
		
		Object[] test = new Object[3];
		
		test[0] = 1;
		test[1] = 2;
		
		StringBuilder a = new StringBuilder();
		a.append("haha");
		test[2] =a;
		
		int c = (int) test[0];
		int d = (int) test[1];
		
		StringBuilder b = (StringBuilder)test[2];
		
		System.out.println(b);

	}

}
