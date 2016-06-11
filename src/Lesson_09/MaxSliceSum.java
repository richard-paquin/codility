package Lesson_09;

import java.util.*;

public class MaxSliceSum {

    public int solution(int[] A) {
        int N = A.length;
        assert N > 0;
        if (N < 2) {
            return A[0];
        }
        int curMax = A[0];
        int totalMax = A[0];
        for (int i = 1; i < N; i++) {
            if (curMax + A[i] > A[i]) {
                curMax = curMax + A[i];
            } else {
                curMax = A[i];
            }
            totalMax = Math.max(curMax, totalMax);
        }
        return totalMax;
    }

    public static void Test() {
        ArrayList<int[]> a = new ArrayList<>();
        a.add(new int[]{3, 2, -6, 4, 0});
        a.add(new int[]{1, 2, 3});
        a.add(new int[]{3, 2, 1});
        a.add(new int[]{-1, -2, -3});
        a.add(new int[]{-3, -2, -1});
        a.add(new int[]{-1, -2, -3, -4, -5});
        a.add(new int[]{-5, -4, -3, -2, -1});
        a.add(new int[]{1, 2, 3, 4, 5});
        a.add(new int[]{5, 4, 3, 2, 1});
        a.add(new int[]{-1, -2, -3, -4, -5});
        a.add(new int[]{-5, -4, -3, -2, -1});
        a.add(new int[]{-1, 1, -1, 1, -1});
        a.add(new int[]{-1, -1, -1, 0, 1, 2});
        a.add(new int[]{-1, -1, -1, 2, 1, 0});
        a.add(new int[]{0, 1, 2, -1, -1, -1,});
        a.add(new int[]{2, 1, 0, -1, -1, -1,});

        a.add(new int[]{100, -1, -2, -3});
        a.add(new int[]{100, -3, -2, -1});
        a.add(new int[]{100, -1, -2, -3, -4, -5});
        a.add(new int[]{100, -5, -4, -3, -2, -1});
        a.add(new int[]{100, 1, 2, 3, 4, 5});
        a.add(new int[]{100, 5, 4, 3, 2, 1});
        a.add(new int[]{100, -1, -2, -3, -4, -5});
        a.add(new int[]{100, -5, -4, -3, -2, -1});
        a.add(new int[]{100, -1, 1, -1, 1, -1});
        a.add(new int[]{100, -1, -1, -1, 0, 1, 2});
        a.add(new int[]{100, -1, -1, -1, 2, 1, 0});
        a.add(new int[]{100, 0, 1, 2, -1, -1, -1,});
        a.add(new int[]{100, 2, 1, 0, -1, -1, -1,});

        a.add(new int[]{1, 2, 3, 100});
        a.add(new int[]{3, 2, 1, 100});
        a.add(new int[]{-1, -2, -3, 100});
        a.add(new int[]{-3, -2, -1, 100});
        a.add(new int[]{-1, -2, -3, -4, -5, 100});
        a.add(new int[]{-5, -4, -3, -2, -1, 100});
        a.add(new int[]{1, 2, 3, 4, 5, 100});
        a.add(new int[]{5, 4, 3, 2, 1, 100});
        a.add(new int[]{-1, -2, -3, -4, -5, 100});
        a.add(new int[]{-5, -4, -3, -2, -1, 100});
        a.add(new int[]{-1, 1, -1, 1, -1, 100});
        a.add(new int[]{-1, -1, -1, 0, 1, 2, 100});
        a.add(new int[]{-1, -1, -1, 2, 1, 0, 100});
        a.add(new int[]{0, 1, 2, -1, -1, -1, 100});
        a.add(new int[]{2, 1, 0, -1, -1, -1, 100});

        a.add(new int[]{100, 1, 2, 3, 100});
        a.add(new int[]{100, 3, 2, 1, 100});
        a.add(new int[]{100, -1, -2, -3, 100});
        a.add(new int[]{100, -3, -2, -1, 100});
        a.add(new int[]{100, -1, -2, -3, -4, -5, 100});
        a.add(new int[]{100, -5, -4, -3, -2, -1, 100});
        a.add(new int[]{100, 1, 2, 3, 4, 5, 100});
        a.add(new int[]{100, 5, 4, 3, 2, 1, 100});
        a.add(new int[]{100, -1, -2, -3, -4, -5, 100});
        a.add(new int[]{100, -5, -4, -3, -2, -1, 100});
        a.add(new int[]{100, -1, 1, -1, 1, -1, 100});
        a.add(new int[]{100, -1, -1, -1, 0, 1, 2, 100});
        a.add(new int[]{100, -1, -1, -1, 2, 1, 0, 100});
        a.add(new int[]{100, 0, 1, 2, -1, -1, -1, 100});
        a.add(new int[]{100, 2, 1, 0, -1, -1, -1, 100});

        a.add(new int[]{1, 1, 1, 0, 0, 0, 0, 0, 0, 1000, -5, -5, -5, -5, 2000, 0});
        for (int[] A : a) {
            System.out.print(Arrays.toString(A));
            System.out.print(": ");
            System.out.println(new MaxSliceSum().solution(A));
        }
    }
}
