package programmers.implementation;

/**
 *
 * 헷갈렸던 점
 * - 진법 변환에 대한 이해가 부족했다.
 *
 * 포인트
 * - 진법 변환의 알고리즘을 그대로 적용하면 된다.
 *      - 해당 진법의 숫자 종류 개수로 나눈 나머지를 답의 맨 앞에 계속 추가
 *      - 몫으로 계속 계산
 *      - 몫이 0일 떄까지 나머지를 답에 추가
 *      - 다음 루프에서 몫이 0이기 때문에 들어가지 않고 종료된다.
 *
 */

public class Nation124 {

    public String solution(int n) {

        int[] remains = {4,1,2};
        StringBuilder answer = new StringBuilder();

        while(n > 0) {
            int remainN = n % 3;
            n /= 3;

            if(remainN == 0) {
                n--;
            }


            answer.insert(0, remains[remainN]);
        }

        return answer.toString();
    }
}
