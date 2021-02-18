package test.interfaceTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Rectangle implements Shape, ShapeEquals{

	
	public static void main(String[] args) {
		
		
		List<Integer> list = new ArrayList<>();
		
		Collections.sort(list, new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
			
		});
	}
	
	private int width;
	private int height;
	
	
	public Rectangle() {
		// TODO Auto-generated constructor stub
	}
	
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	@Override
	public double getArea() {
		
		return this.width * this.height;
		
	}

	@Override
	public int getMultipleValue(int width, int height) {
		// TODO Auto-generated method stub
		return Shape.super.getMultipleValue(width, height);
	}
	
	
}
