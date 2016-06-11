package Lesson_05;

import java.util.*;

public class MinAvgTwoSlice {

    /*
    public int solution(int[] A) {
        int N = A.length;
        assert N > 1;

        // Normalise
        int minA = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if (A[i] < minA) {
                minA = A[i];
            }
        }
        for (int i = 0; i < N; i++) {
            A[i] -= minA;
        }

        // Calc prefsum
        double[] prefSum = new double[N + 1];
        for (int i = 0; i < N; i++) {
            prefSum[i + 1] = prefSum[i] + A[i];
        }

        // Find minSteep
        double minSteep = Double.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 2; j <= N; j++) {
                double steep = (prefSum[j] - prefSum[i]) / (j - i);
                if (steep < minSteep) {
                    minSteep = steep;
                    minIndex = i;
                }
            }
        }
        return minIndex;
    }
     */
    public int solution(int[] A) {
        int N = A.length;
        assert N > 1;

        // Normalise
        int minA = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if (A[i] < minA) {
                minA = A[i];
            }
        }
        for (int i = 0; i < N; i++) {
            A[i] -= minA;
        }

        // Calc prefsum
        double[] prefSum = new double[N + 1];
        for (int i = 0; i < N; i++) {
            prefSum[i + 1] = prefSum[i] + A[i];
        }

        // Find minSteep len 2
        double minSteep = Double.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < N - 1; i++) {
            double steep = (prefSum[i + 2] - prefSum[i]) / (2);
            if (steep < minSteep) {
                minSteep = steep;
                minIndex = i;
            }
        }
        // Find minSteep len 3
        for (int i = 0; i < N - 2; i++) {
            double steep = (prefSum[i + 3] - prefSum[i]) / (3);
            if (steep < minSteep) {
                minSteep = steep;
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void Test() {
        ArrayList<int[]> a = new ArrayList<>();
        a.add(new int[]{4, 2, 2, 5, 1, 5, 8});
//        a.add(new int[]{1, 1, 1, 1, 1, 3});
//        a.add(new int[]{3, 3, 3, 1, 1, 1});
//        a.add(new int[]{3, 3, -3, -3, 1, 1});
//        a.add(new int[]{-1, 1, -1, 1, -1, 1});
        a.add(new int[]{1, -1, 1, -1, 1, -1});
        a.add(new int[]{1, -1, 1, -1, 1, -1, 1});

        for (int[] A : a) {
            System.out.print(Arrays.toString(A));
            System.out.print(": ");
            System.out.println(new MinAvgTwoSlice().solution(A));
        }
    }
}
