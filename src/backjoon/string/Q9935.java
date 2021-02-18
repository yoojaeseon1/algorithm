package backjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q9935 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder msg = new StringBuilder(br.readLine());
		StringBuilder bomb = new StringBuilder(br.readLine());
		StringBuilder result = new StringBuilder();
		Stack<String> msgStack = new Stack<String>();

		boolean bombCheck = false;
		int tempIdx;

		for (int i = 0; i < msg.length(); i++) {
			if (msg.substring(i, i + 1).equals(bomb.substring(bomb.length() - 1, bomb.length()))) {
				tempIdx = msgStack.size() - 1;
				for (int j = bomb.length() - 2; j >= 0; j--) {
					if (msgStack.get(tempIdx--).equals(bomb.substring(j, j + 1))) {
						bombCheck = true;
					} else {
						bombCheck = false;
						break;
					}
				}
				if (bombCheck) {
					for (int j = 1; j < bomb.length(); j++) {
						msgStack.pop();
					}
				}
				bombCheck = false;
			} else {
				msgStack.push(msg.substring(i, i + 1));
			}
		}

		if (!msgStack.isEmpty()) {
			while (!msgStack.isEmpty()) {
				result.insert(0, msgStack.pop());
			}
			System.out.println(result);
		} else {
			System.out.println("FRULA");
		}
	}

}
