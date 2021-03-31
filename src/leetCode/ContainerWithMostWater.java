package leetCode;

/*

	헷갈렸던 부분
	- 이중 for문으로 O(n^2)의 방법밖에 생각나지 않았다.

	포인트
	- 배열의 양쪽 끝 인덱스부터 낮은 높이의 인덱스를 한 칸씩 옮겨가며 최댓 값을 갱신한다.
	- 낮은 쪽을 업데이트 해야 더 큰 값이 나올 수 있다.
	- 낮은 쪽이 더 높아지면 값이 더 커지기 때문

 */

public class ContainerWithMostWater {

    public static void main(String[] args) {

        ContainerWithMostWater test = new ContainerWithMostWater();

        int[] height = {1,1};

        System.out.println(test.solution(height));

        height = new int[]{4,3,2,1,4};

        System.out.println(test.solution(height));

        height = new int[]{1,2,1};

        System.out.println(test.solution(height));


    }

    public int solution(int[] height) {

        int maxArea = 0;

        int leftIndex = 0;
        int rightIndex = height.length-1;

        while(leftIndex < rightIndex) {

            int leftHeight = height[leftIndex];
            int rightHeight = height[rightIndex];

            int lowerHeight = Math.min(leftHeight, rightHeight);

            maxArea = Math.max(maxArea, lowerHeight * (rightIndex - leftIndex));

            if(leftHeight > rightHeight) {
                rightIndex--;
            }else {
                leftIndex++;
            }
        }

        return maxArea;
    }
}
