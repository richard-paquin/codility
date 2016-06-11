package Lesson_09;

import java.util.*;

public class MaxSliceDoubleSum {

    public int solution1(int[] A) {
        // this solution doesn't work for {-1, -1, -1, 2, 1, 0};
        assert false;
        long maxDS = 0;
        long maxDSE = 0;
        long maxS = A[1];

        for (int i = 2; i < A.length - 1; ++i) {
            maxDSE = Math.max(maxDSE + A[i], maxS);
            maxDS = Math.max(maxDS, maxDSE);
            maxS = Math.max(0, Math.max(A[i], maxS + A[i]));
        }

        return (int) maxDS;
    }

    public int solution2(int[] A) {
        int N = A.length;
        int[] K1 = new int[N];
        int[] K2 = new int[N];

        for (int i = 1; i < N - 1; i++) {
            K1[i] = Math.max(K1[i - 1] + A[i], 0);
        }
        for (int i = N - 2; i > 0; i--) {
            K2[i] = Math.max(K2[i + 1] + A[i], 0);
        }

        int max = 0;

        for (int i = 1; i < N - 1; i++) {
            max = Math.max(max, K1[i - 1] + K2[i + 1]);
        }

        return max;
    }

    public int solution3(int[] A) {
        int N = A.length;
        int[] maxLeft = new int[N];
        int[] maxRight = new int[N];
        int max = 0;

        for (int i = 1; i < N; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1] + A[i], 0);
        }
        for (int i = N - 2; i > 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1] + A[i], 0);
        }
        for (int i = 1; i < N - 1; i++) {
            max = Math.max(max, maxLeft[i - 1] + maxRight[i + 1]);
        }
        return max;
    }

    public static void Test() {
        ArrayList<int[]> a = new ArrayList<>();
//        a.add(new int[]{3, 2, 6, -1, 4, 5, -1, 2});
//        a.add(new int[]{1, 2, 3});
//        a.add(new int[]{3, 2, 1});
//        a.add(new int[]{-1, -2, -3});
//        a.add(new int[]{-3, -2, -1});
//        a.add(new int[]{-1, -2, -3, -4, -5});
//        a.add(new int[]{-5, -4, -3, -2, -1});
//        a.add(new int[]{1, 2, 3, 4, 5});
//        a.add(new int[]{5, 4, 3, 2, 1});
//        a.add(new int[]{-1, -2, -3, -4, -5});
//        a.add(new int[]{-5, -4, -3, -2, -1});
//        a.add(new int[]{-1, 1, -1, 1, -1});
//        a.add(new int[]{-1, -1, -1, 0, 1, 2});
        a.add(new int[]{-1, -1, -1, 2, 1, 0});
        a.add(new int[]{0, 1, 2, -1, -1, -1,});
        a.add(new int[]{2, 1, 0, -1, -1, -1,});
        a.add(new int[]{1, 1, 1, 0, 0, 0, 0, 0, 0, 1000, -5, -5, -5, -5, 2000, 0});

        //a.add(new int[]{});
        //a.add(new int[]{-2, -3, 4, -1, -2, 1, 5, -3});
        a.add(new int[]{23171, 21011, 21123, 21366, 21013, 21367});

        for (int[] A : a) {
            System.out.print(Arrays.toString(A));
            System.out.print(": ");
            int x = new MaxSliceDoubleSum().solution1(A);
            int y = new MaxSliceDoubleSum().solution2(A);
            System.out.print(x);
            System.out.print("|");
            System.out.println(y);
            break;

        }
    }
}
