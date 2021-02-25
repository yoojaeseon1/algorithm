package leetCode;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * 헷갈렸던 부분
 * - 접근방식 : 순열로 구하고 정렬 -> 오름 / 내림으로는 안되고, 답이 여러 개가 나오기 때문에 정렬로 접근하는 것은 좋지 않다.
 *
 * 해결 방법
 * - 쉬프트 연산(<<)으로 1bit씩 옮겨가면서 더해준다.(규칙성 발견이 핵심)
 * - 비트 연산문제는 쉬프트 연산을 한 번 생각해보고 넘어가는게 좋겠다.
 *
 */

public class GrayCode {

    public static void main(String[] args) {

        List<Integer> integers = grayCode(3);

        for (Integer integer : integers) {
            System.out.println("integer = " + integer);
        }

    }

    public static List<Integer> grayCode(int n) {

        if(n==0){
            List<Integer> result = new ArrayList<Integer>();
            result.add(0);
            return result;
        }

        List<Integer> result = grayCode(n-1);
        int numToAdd = 1<<(n-1);
        for(int resultI=result.size()-1; resultI>=0; resultI--){
            result.add(numToAdd+result.get(resultI));
        }

        return result;

    }

}
