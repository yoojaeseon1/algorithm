package backjoon.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1839 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[][] relations = new boolean[N+1][N+1];
		
		for(int numRelation = 1; numRelation <= M; numRelation++) {
			
			st = new StringTokenizer(br.readLine());
			int person1 = Integer.parseInt(st.nextToken());
			int person2 = Integer.parseInt(st.nextToken());
			
			relations[person1][person2] = true;
			relations[person2][person1] = true;
		}
		
		
		int[][] kebins = new int[N+1][N+1];
		Queue<int[]> relationQueue = new LinkedList<>();
		
		int[] sumKebins = new int[N+1]; 
		
		for(int relationsI = 1; relationsI < relations.length; relationsI++) {
			int numConnection = 1;
			for(int relationsJ = 1; relationsJ < relations[relationsI].length; relationsJ++) {
				if(relations[relationsI][relationsJ]) {
					int[] relation = {relationsJ, numConnection};
					relationQueue.add(relation);
					kebins[relationsI][relationsJ] = numConnection;
				}
			}
			
			while(!relationQueue.isEmpty()) {
				
				int[] relation = relationQueue.poll();
				
				for(int innerRelationsI = 0; innerRelationsI < relations.length; innerRelationsI++) {
					
					if(innerRelationsI != relationsI && relations[relation[0]][innerRelationsI] && kebins[relationsI][innerRelationsI] == 0) {
						kebins[relationsI][innerRelationsI] = relation[1] + 1;
						
						int[] addedRelation = {innerRelationsI, relation[1]+1};
						
						relationQueue.add(addedRelation);
						
					}
					
				}
			}
			
			int sumKebin = 0;
			for(int kebinsI = 0; kebinsI < kebins.length; kebinsI++) {
				sumKebin += kebins[relationsI][kebinsI];
			}
			
			
			
			
//			sumKebins[relationsI] = new int[2];			
//			sumKebins[relationsI][0] = relationsI;
			sumKebins[relationsI] = sumKebin;
			
		}
		
		int minKebinNumber = 0;
		int minKebin  = Integer.MAX_VALUE;
		for(int sumKebinsI = 1; sumKebinsI < sumKebins.length; sumKebinsI++) {
			if(sumKebins[sumKebinsI] < minKebin) {
				minKebin = sumKebins[sumKebinsI];
				minKebinNumber = sumKebinsI;
			}
		}
		
		System.out.println(minKebinNumber);
	}

}
