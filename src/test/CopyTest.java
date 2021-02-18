package test;

public class CopyTest {

	public static void main(String[] args) {

		Test yoo = new Test();
		yoo.setAge(27);
		yoo.setName("yoojs");

		Test test = yoo;

		System.out.println(test.getName());

		yoo.setName("haha");

		System.out.println(test.getName());

		System.out.println("--------------");

		// String name = "name";

		String name = new String("name");

		String copyName = name;

		System.out.println(copyName);

		name = "haha name";
		System.out.println(name);
		System.out.println(copyName);

		System.out.println("--------------");

		Integer a = new Integer(5);

		Integer b = new Integer(a);

		System.out.println("a : " + a);
		System.out.println("b : " + b);

		a = new Integer(1);

		System.out.println("a : " + a);
		System.out.println("b : " + b);

		// int a = 5;
		//
		// int b = a;
		//
		// System.out.println("b : " + b);
		//
		// a = 1;
		//
		// System.out.println("a : " + a);
		//
		// System.out.println("b : " + b);

		int[][] original = { { 1, 2 }, { 3, 4 }, { 5, 6 } };

		// int[][] copied = original;
		int[][] copied = copyArray(original);

		original[1][1] = 8;

		// int[] copied = new int[original.length];

		// System.arraycopy(original, 0, copied, 0, original.length);

		// original[1] = 8;

		for (int i = 0; i < copied.length; i++) {
			System.out.println(copied[i][0] + " " + copied[i][1]);
		}

	}

	static int[][] copyArray(int[][] original) {

		int[][] copied = new int[original.length][original[0].length];

		for (int i = 0; i < original.length; i++) {
			System.arraycopy(original[i], 0, copied[i], 0, original[i].length);
		}

		return copied;
	}

}

class Test {

	private String name;
	private int age;

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
