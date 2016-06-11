package Lesson_15;

import java.util.*;

public class CountTriangles {

    // 1st attemps -- 45%
    // https://codility.com/demo/results/trainingQT3YN4-7AX/
    // first I realised the condition with Q didn't make sense (you can have 2
    // long sides and 1 small)
    // https://codility.com/demo/results/trainingUNDQZ8-Q2W/
    // then I realised I wasn't using A2...
    // then I realised A2 wasn't useful.
    // and the I understood the caterpillar.
    // no need to recalculate everything, just move the middle a tiny bit...
    // or something.
    // https://codility.com/demo/results/training546TSZ-HJ5/ 72%
    // there has to be a break somewhere...
    public int solution(int[] A) {
        int N = A.length;
        int count = 0;
        Arrays.sort(A);
        for (int P = 0; P < N - 2; P++) {
            int R = P + 2;
            for (int Q = P + 1; Q < N - 1; Q++) {
                while (R < N && A[P] + A[Q] > A[R]) {
                    R++;
                }
                count += R - Q - 1;
            }
        }
        return count;
    }
    
}
