package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		char[][] field = new char[N][N];
		StringBuilder oneLine = new StringBuilder();
		for(int fieldI = 0; fieldI < field.length; fieldI++) {
			oneLine.append(br.readLine());

			for(int fieldJ = 0; fieldJ < field[fieldI].length; fieldJ++) {

				field[fieldI][fieldJ] = oneLine.charAt(fieldJ);

			}
			oneLine.setLength(0);
		}

		int[] dx = {0,1,0,-1};
		int[] dy = {-1,0,1,0};

		Queue<int[]> fieldQueue = new LinkedList<>();
		List<Integer> areas = new ArrayList<>();
		for(int fieldI = 0; fieldI < field.length; fieldI++) {

			for(int fieldJ = 0; fieldJ < field[fieldI].length; fieldJ++) {

				if(field[fieldI][fieldJ] == '1') {
					int numHome = 0;
					fieldQueue.add(new int[]{fieldJ, fieldI});
					field[fieldI][fieldJ] = '2';

					while(!fieldQueue.isEmpty()) {
						numHome++;
						int[] currentPosition = fieldQueue.poll();

						int currentX = currentPosition[0];
						int currentY = currentPosition[1];

						for(int di = 0; di < dx.length; di++) {

							if(currentX + dx[di] >= 0
									&& currentX + dx[di] < field[0].length
									&& currentY + dy[di] >= 0
									&& currentY + dy[di] < field.length
									&& field[currentY+dy[di]][currentX+dx[di]] == '1'
							) {
								fieldQueue.add(new int[]{currentX+dx[di], currentY+dy[di]});
								field[currentY+dy[di]][currentX+dx[di]] = '2';
							}


						}

					}
					areas.add(numHome);
				}

			}
		}

		Collections.sort(areas);
		System.out.println(areas.size());
		for (Integer area : areas) {
			System.out.println(area);
		}
		
	}

}
