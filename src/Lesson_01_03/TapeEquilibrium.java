package Lesson_01_03;

import java.util.*;

public class TapeEquilibrium {

    public int solution(int[] A) {
        int len = A.length;
        int totalSum = 0;
        for (int i = 0; i < len; i++) {
            totalSum += A[i];
        }
        int left = 0, right = totalSum;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < len - 1; i++) {
            left += A[i];
            right -= A[i];
            int diff = Math.abs(left - right);
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        return minDiff;
    }

    public static void Test() {
        ArrayList<int[]> a = new ArrayList<>();
        a.add(new int[]{3, 1, 2, 4, 3});
        a.add(new int[]{0, 0});
        a.add(new int[]{-1000, 1000});
        a.add(new int[]{-1, -1, 1, 1, 0});
        a.add(new int[]{-1, -1, 1, 1});

        for (int[] A : a) {
            System.out.print(Arrays.toString(A));
            System.out.print(": ");
            System.out.println(new TapeEquilibrium().solution(A));
        }
    }

}
