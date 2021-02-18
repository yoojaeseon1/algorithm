package test.interfaceTest;

public interface Shape {
	
	public double getArea();
	
	public default int getMultipleValue(int width, int height) {
		
		return width * height;
	}
	
}
