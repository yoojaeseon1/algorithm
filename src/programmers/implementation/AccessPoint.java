package programmers.implementation;

public class AccessPoint {
	
	public static void main(String[] args) {

		 int n = 11;
		 int[] stations = {4,11};
		
		 int w = 1;

//		int n = 16;
//		int[] stations = { 9 };
//
//		int w = 2;

		System.out.println(solution(n, stations, w));

	}

	public static int solution(int n, int[] stations, int w) {
		int minNewAP = 0;

		int currentLocation = 1;
		int stationsI = 0;

		while (stationsI < stations.length) {

			if (currentLocation < stations[stationsI] - w) {
				minNewAP++;
				currentLocation += (2 * w) + 1;
			} else {
				currentLocation = stations[stationsI] + w + 1;
				stationsI++;
			}
		}
		
		if(currentLocation <= n) {
			
			minNewAP += (n - currentLocation + 1) / (2*w+1);
			if((n - currentLocation + 1) % (2*w+1) > 0)
				minNewAP++;

		}
		return minNewAP;
	}

}
