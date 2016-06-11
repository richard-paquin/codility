package Lesson_04;

import java.util.*;

public class MaxCounters {

    // 100% -- 1st attempt (yay)
    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int currentMin = 0; // dont iterate on all values for A[K] >= N
        int currentMax = 0;
        for (int X : A) {
            X--; // zero based
            if (X >= N) {
                currentMin = currentMax;
            } else {
                counters[X] = Math.max(currentMin + 1, counters[X] + 1);
                if (counters[X] > currentMax) {
                    currentMax = counters[X];
                }
            }
        }
        for (int i = 0; i < N; i++) {
            counters[i] = Math.max(currentMin, counters[i]);
        }
        return counters;
    }

    public static void Test() {
        ArrayList<int[]> a = new ArrayList<>();
//        a.add(new int[]{0});
//        a.add(new int[]{1});
//        a.add(new int[]{1, 1});
//        a.add(new int[]{1, 2});
//        a.add(new int[]{2, 1});
//        a.add(new int[]{1, 2, 3});
//        a.add(new int[]{-1, 0, 1});
//        a.add(new int[]{-2, -1, 0});
//        a.add(new int[]{-2, -1, 1});
//        a.add(new int[]{-3, -2, -1});
        a.add(new int[]{3, 4, 4, 6, 1, 4, 4});

        for (int[] A : a) {
            System.out.print(Arrays.toString(A));
            System.out.print(": ");
            System.out.println(Arrays.toString(new MaxCounters().solution(5, A)));
        }
    }

}
