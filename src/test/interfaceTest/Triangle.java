package test.interfaceTest;

public class Triangle implements Shape {

	private int width;
	private int height;
	
	
	public Triangle() {
		// TODO Auto-generated constructor stub
	}
	
	public Triangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	@Override
	public double getArea() {
		
		return 0.5 * this.width * this.height;
	}
	
	

}
