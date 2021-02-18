package test.interfaceTest;

public interface ShapeEquals {
	
	public default int getMultipleValue(int width, int height) {
		
		return width * height;
	}

}
