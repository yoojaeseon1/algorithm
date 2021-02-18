package backjoon.Map;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Q7785 {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		 Map<String, Boolean> logMap = new HashMap<>();
//		Set<String> logSet = new TreeSet<>((o1,o2)->o2.compareTo(o1));

		StringTokenizer st;

		for (int logCount = 1; logCount <= n; logCount++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String status = st.nextToken();

//			if ("enter".equals(status))
//				logSet.add(name);
//			else
//				logSet.remove(name);

			 if (logMap.containsKey(name)) {
			 if (logMap.get(name))
			 logMap.put(name, false);
			 else
			 logMap.put(name, true);
			 } else {
			 logMap.put(name, true);
			 }
		}

		Iterator<String> logIter = logMap.keySet().iterator();
		
//		Iterator<String> logIter = logSet.iterator();

		List<String> workingList = new ArrayList<>();
		
		

		while (logIter.hasNext()) {
			String currentName = logIter.next();

			if (logMap.get(currentName))
				workingList.add(currentName);
			
			workingList.add(logIter.next());
			
//			System.out.println(logIter.next());

		}
		

		Collections.sort(workingList, Collections.reverseOrder());

		for (int wi = 0; wi < workingList.size(); wi++) {
			System.out.println(workingList.get(wi));
		}
	}

}
