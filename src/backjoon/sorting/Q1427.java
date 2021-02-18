package backjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

//배열이 list로 정렬하는 것보다 훨씬(약 3배) 빠르다.

public class Q1427 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String nStr = br.readLine();
		
		String[] nArr = nStr.split("");
		
//		String[] nArr = new String[nStr.length()];
		
//		for(int i = 0; i < nArr.length; i++) {
//			nArr[i] = nStr.substring(i, i+1);
//		}
		
//		List<String> nList = new ArrayList<>();
		
//		for(int i = 0; i < nStr.length(); i++) {
//			nList.add(nStr.substring(i, i+1));
//		}
		
		
//		Collections.sort(nList, (o1,o2)->o2.compareTo(o1));
//		Collections.sort(nList, (o1,o2)->Integer.parseInt(o2)-Integer.parseInt(o1));
//		Collections.sort(nList, (o1,o2)->o2.compareTo(o1));
		
		Arrays.sort(nArr, Collections.reverseOrder());
		
		for(int i = 0; i < nArr.length; i++) {
//		for(int i = 0; i < nList.size(); i++) {
			System.out.print(nArr[i]);
//			System.out.print(nList.get(i));
		}
	}
}