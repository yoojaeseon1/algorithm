package leetCode;

/**
 * 문제 번호 : 718
 *
 *
 *
 */

public class MaximumLength {

    public static void main(String[] args) {

        int[] A = {1,2,3,2,1};
        int[] B = {3,2,1,4,7};

        System.out.println(findLength(A,B));

    }

    public static int findLength(int[] A, int[] B) {

        int answer = 0;
        int tempAnswer = 1;

        for(int ai = 0; ai < A.length; ai++) {

            for(int bi = 0; bi < B.length; bi++) {

//                if(ai < A.length && A[ai] == B[bi]) {
//                    tempAnswer++;
//                    ai++;

                if(A[ai] == B[bi]) {
//                    System.out.println(ai);
                    int currentAi = ai+1;
                    for(int bj = bi+1; bj < B.length; bj++) {
                        if(currentAi < A.length && A[currentAi] == B[bj]) {
//                            System.out.println("bj = " + bj);
                            tempAnswer++;
                            currentAi++;
                        }
                        else {
                            break;
                        }
                    }

                    answer = Math.max(answer, tempAnswer);
                    tempAnswer = 1;
                }
            }
        }


        if(answer > 0)
            answer = Math.max(answer, tempAnswer);

        return answer;

    }

}
