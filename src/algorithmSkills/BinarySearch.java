package algorithmSkills;


// 그림 참고 URL : https://hee96-story.tistory.com/80

/**
 * 주의사항
 * - 오름차순 정렬이 되어있어야 한다.(내림차순도 가능하지만 아래의 코드는 오름차순 기준)
 *
 * 포인트
 * - middle 인덱스의 값이 클 때 / 작을 때의 이동은 다 똑같다.
 *      같을 때
 *          - lower bound : endIndex--
 *          - uppder bound : startIndex++
 *          - 정확한 값을 찾을 때 : return
 *
 * - 배열 뿐만 아니라 특정 값의 범위가 주어졌을 때 평균 값을 구할 때도 쓰인다.
 *      - 카카오 엔터프라이즈 공장 문제
 */

public class BinarySearch {

    public static void main(String[] args) {

        int[] numbers = {1,2,2,3,3,3,4,6,7};

        BinarySearch binarySearch = new BinarySearch();

        System.out.println(binarySearch.searchTarget(numbers, 3));
        System.out.println(binarySearch.searchLowerBound(numbers, 3));
        System.out.println(binarySearch.searchUpperBound(numbers, 3));

    }

    // search correct value

    public int searchTarget(int[] numbers, int target) {

        int startIndex = 0;
        int endIndex = numbers.length - 1;

        while(startIndex < endIndex) {

            int midIndex = (startIndex + endIndex) / 2;
            int midIndexValue = numbers[midIndex];

//            System.out.println("midIndex = " + midIndex);

            if(midIndexValue == target)
                return midIndex;
            else if(target > midIndexValue) {
                startIndex = midIndex + 1;
            } else
                endIndex = midIndex - 1;

        }

        return -1;
    }

    // lower bound(target 이상인 값 중 맨 처음 index)

    public int searchLowerBound(int[] numbers, int targetNumber){

        int startIndex = 0;
        int endIndex = numbers.length - 1;

        while(startIndex <= endIndex){

            int midIndex= (startIndex + endIndex) / 2;

            if(numbers[midIndex] < targetNumber){
                startIndex=midIndex+1;
            }else{
                endIndex=midIndex-1;
            }
        }

        return startIndex;
    }

    // upper bound(target 보다 큰 값 중 맨 처음 index)

    public int searchUpperBound(int[] numbers, int targetNumber){

        int startIndex = 0;
        int endIndex = numbers.length - 1;

        while(startIndex <= endIndex){

            int midIndex= (startIndex + endIndex) / 2;

            if(numbers[midIndex] <= targetNumber){
                startIndex=midIndex+1;
            }else{
                endIndex=midIndex-1;
            }
        }

        return startIndex;
    }




}
