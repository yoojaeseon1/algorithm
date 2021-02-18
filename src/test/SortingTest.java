package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingTest {
	
	public static void main(String[] args) {
		
		
		Integer[] arr = {1,4,5,7,2,8,2};
		
		List<Integer> list = new ArrayList<>();
		List<String> strList = new ArrayList<>();
		
		list.add(3);
		list.add(5);
		list.add(2);
		list.add(7);
		list.add(1);
		list.add(8);
		list.add(4);
		Collections.sort(list, (o1,o2)->(o2-o1));
		
		strList.add("11");
		strList.add("1000");
		strList.add("102");
		
		
		System.out.print("str order(ascending) : ");
		Collections.sort(strList, (o1,o2)->o1.compareTo(o2));
		for(int i = 0; i < strList.size(); i++) {
			System.out.print(strList.get(i) + " ");
		}
		System.out.println();
		System.out.print("str order(descending) : ");
		
		Collections.sort(strList, (o1,o2)->o2.compareTo(o1));
		for(int i = 0; i < strList.size(); i++) {
			System.out.print(strList.get(i) + " ");
		}
		
		System.out.println();
		System.out.print("num order(ascending) : ");
		
		Collections.sort(strList, (o1,o2)->Integer.parseInt(o1)-Integer.parseInt(o2));
		for(int i = 0; i < strList.size(); i++) {
			System.out.print(strList.get(i) + " ");
		}
		
		System.out.println();
		System.out.print("num order(descending) : ");
		
		Collections.sort(strList, (o1,o2)->Integer.parseInt(o2)-Integer.parseInt(o1));
		for(int i = 0; i < strList.size(); i++) {
			System.out.print(strList.get(i) + " ");
		}
		
		
//		for(int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
//		Arrays.sort(arr, new Descending());
//		Arrays.sort(arr, Collections.reverseOrder());
		
//		for(int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
		
	}

}

class Descending implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		
		if(o1 > o2) {
			return -1;
		} else if(o1 == o2) {
			return 0;
		} else {
			return 1;
		}
	}
}
