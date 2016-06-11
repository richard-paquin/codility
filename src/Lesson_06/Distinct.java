package Lesson_06;

import java.util.*;

public class Distinct {

    // better perf.
    public int solution1(int[] A) {
        int N = A.length;
        if (N < 1) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }

        Arrays.sort(A);
        int count = 1;
        for (int i = 1; i < N; i++) {
            if (A[i] != A[i - 1]) {
                count++;
            }
        }
        return count;
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
