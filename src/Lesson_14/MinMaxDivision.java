package Lesson_14;

import java.util.*;
public class MinMaxDivision {

    public int divideSection(int[] A, int begin, int end) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int solution(int K, int M, int[] A) {
        int N = A.length;
        int[] pSum = new int[N + 1];
        for (int i = 0; i < N; i++) {
            pSum[i + 1] = pSum[i] + A[i];
        }
        return -1;
    }

    public static void Test() {

        MinMaxDivision t = new MinMaxDivision();
        ArrayList<int[]> a = new ArrayList<>();

        a.add(new int[]{2, 1, 5, 1, 2, 2, 2});

        for (int[] A : a) {
            System.out.print(Arrays.toString(A));
            System.out.print(": ");
            System.out.println(t.solution(3, 5, A));
        }
    }
}