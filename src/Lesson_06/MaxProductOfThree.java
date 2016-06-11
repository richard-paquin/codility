package Lesson_06;

import java.util.*;

public class MaxProductOfThree {

    public int solution(int[] A) {
        int N = A.length;
        assert N > 2;
        Arrays.sort(A);
        int opt1 = A[0] * A[1];
        int opt2 = A[N - 3] * A[N - 2];
        int max1 = A[N - 1] * opt1;
        int max2 = A[N - 1] * opt2;
        return max1 > max2 ? max1 : max2;
    }

    public int solution2(int[] A) {
        int N = A.length;
        assert N > 2;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int min3 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int v = A[i];
            int temp;
            if (v > max1) {
                temp = max1;
                max1 = v;
                v = temp;
            }
            if (v > max2) {
                temp = max2;
                max2 = v;
                v = temp;
            }
            if (v > max3) {
                temp = max3;
                max3 = v;
                v = temp;
            }
            v = A[i];
            if (v < min1) {
                temp = min1;
                min1 = v;
                v = temp;
            }
            if (v < min2) {
                temp = min2;
                min2 = v;
                v = temp;
            }
            if (v < min3) {
                min3 = v;
            }
        }
        int v1 = min1 * min2 * max1;
        int v2 = max1 * max2 * max3;
        return v1 > v2 ? v1 : v2;
    }

    public static void Test() {
        ArrayList<int[]> a = new ArrayList<>();
        a.add(new int[]{1, 2, 3});
        a.add(new int[]{-1, 0, 1});
        a.add(new int[]{-2, -1, 0});
        a.add(new int[]{-2, -1, 1});
        a.add(new int[]{-3, -2, -1});
        a.add(new int[]{1, 2, 3, 4});
        a.add(new int[]{-1, 0, 1, -2});
        a.add(new int[]{-2, -1, 1, 8});
        a.add(new int[]{-3, -1, 1, 2, 4});
        a.add(new int[]{-2, -1, 1, 3, 4});
        a.add(new int[]{-2, -1, 0, 1, 2});
        for (int[] A : a) {
            System.out.print(Arrays.toString(A));
            System.out.print(": ");
            System.out.println(new MaxProductOfThree().solution(A));
        }
    }
}
