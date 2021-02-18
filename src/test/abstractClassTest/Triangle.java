package test.abstractClassTest;

public class Triangle extends Shape{

	
	public Triangle() {
		// TODO Auto-generated constructor stub
	}
	
	public Triangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	double getArea() {
		
		return 0.5 * this.width * this.height;
	}

}
