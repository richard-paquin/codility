package Lesson_04;

import java.util.*;

public class MissingInteger {

    // 77 %
    public int solution2(int[] A) {
        int N = A.length;
        boolean[] found = new boolean[N];
        for (int i = 0; i < N; i++) {
            int val = A[i] - 1; // zero based
            if (val < 0 || val > N - 1) {
                continue;
            }
            found[val] = true;
        }
        for (int i = 0; i < N; i++) {
            if (!found[i]) {
                return i + 1;
            }
        }
        return -1;
    }

    // 100% but ugly
    public int solution(int[] A) {
        int N = A.length;
        Arrays.sort(A);
        boolean passedZero = false;
        int i = -1;
        int expected = 1;
        int val = Integer.MAX_VALUE;
        while (++i < N) {
            if (A[i] == val) {
                continue;
            }
            val = A[i]; // zero based
            if (!passedZero) {
                if (val < 1) {
                    continue;
                }
                passedZero = true;
            }
            if (val != expected) {
                return expected;
            }
            expected++;
        }
        if (!passedZero) {
            return 1;
        }
        return A[N - 1] + 1;
    }

}
