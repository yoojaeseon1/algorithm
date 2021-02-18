package backjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2529 {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int K = Integer.parseInt(br.readLine());

		char[] operator = new char[K];

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int oi = 0; oi < K; oi++)
			operator[oi] = st.nextToken().charAt(0);

		StringBuilder maxNum = new StringBuilder();
		StringBuilder minNum = new StringBuilder();

		if (operator[0] == '>') { // 하나만 append하면 각각 nextNum을 다르게 초기화 해줘야 한다.
			maxNum.append("98");
			minNum.append("10");
		} else {
			maxNum.append("89");
			minNum.append("01");
		}
		
		int nextNum = 7;

		for (int oi = 1; oi < K; oi++) {
			if (operator[oi] == '>')
				maxNum.append(nextNum--);
			else { // operator[i] == '<'
				int oj = oi;
				while (oj >= 0 && operator[oj] == '<')
					oj--;
				maxNum.insert(oj + 1, nextNum--);
			}
		}
		
		
		nextNum = 2;
		
		for(int oi = 1; oi < K; oi++) {
			
			if(operator[oi] == '<')
				minNum.append(nextNum++);
			else { // operator[i] == '>'
				int oj = oi;
				while(oj >= 0 && operator[oj] == '>')
					oj--;
				minNum.insert(oj+1, nextNum++);
			}
		}
		
		System.out.println(maxNum);
		System.out.println(minNum);

	}

}
