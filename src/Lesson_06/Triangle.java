package Lesson_06;

import java.util.*;

public class Triangle {

    //bad perf, obv... (33%)
    public int solution(int[] A) {
        int N = A.length;
        if (N < 3) {
            return 0;
        }
        for (int P = 0; P < N - 2; P++) {
            for (int Q = P + 1; Q < N - 1; Q++) {
                for (int R = Q + 1; R < N; R++) {
                    long p = A[P];
                    long q = A[Q];
                    long r = A[R];
                    if ((p + q > r) && (q + r > p) && (r + p > q)) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    // better perf.
    public int solution2(int[] A) {
        int N = A.length;
        if (N < 3) {
            return 0;
        }
        Arrays.sort(A);
        for (int i = 0; i < N - 2; i++) {
            if ((long) A[i] + (long) A[i + 1] > (long) A[i + 2]) {
                return 1;
            }
        }
        return 0;
    }

    public static void Test() {

        ArrayList<int[]> a = new ArrayList<>();
        a.add(new int[]{0});

        for (int[] A : a) {
            System.out.print(Arrays.toString(A));
            System.out.print(": ");
            System.out.println(new Triangle().solution(A));
        }
    }

}
