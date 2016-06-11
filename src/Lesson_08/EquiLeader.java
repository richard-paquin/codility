package Lesson_08;

import java.util.*;

public class EquiLeader {

    public int solution(int[] A) {
        int N = A.length;
        int[] leaderBeginEnd = new int[N];
        int[] leaderEndBegin = new int[N];
        int value = Integer.MAX_VALUE;
        int leaderStack = 0;
        for (int i = 0; i < N; i++) {
            if (leaderStack == 0) {
                value = A[i];
                leaderStack += 1;
            } else if (A[i] == value) {
                leaderStack += 1.0;
            } else {
                leaderStack--;
                if (leaderStack == 0) {
                    value = Integer.MAX_VALUE;
                }
            }
            leaderBeginEnd[i] = value;
        }
        value = Integer.MAX_VALUE;
        leaderStack = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (leaderStack == 0) {
                value = A[i];
                leaderStack += 1;
            } else if (A[i] == value) {
                leaderStack += 1.0;
            } else {
                leaderStack--;
                if (leaderStack == 0) {
                    value = Integer.MAX_VALUE;
                }
            }
            leaderEndBegin[i] = value;
        }
        int equi = 0;
        for (int i = 0; i < N - 1; i++) {
            if (leaderBeginEnd[i] == Integer.MAX_VALUE) {
                continue;
            }
            if (leaderEndBegin[i + 1] == leaderBeginEnd[i]) {
                equi += 1;
            }
        }
        return equi;
    }

    public static void Test() {
        ArrayList<int[]> a = new ArrayList<>();
        a.add(new int[]{2, 2, 1, 2, 2});
        a.add(new int[]{4, 3, 4, 4, 4, 2});
        a.add(new int[]{1, 1, 2, 2});
        a.add(new int[]{2, 1, 1, 2, 2, 2});
        a.add(new int[]{1, 1, 1});
        a.add(new int[]{1});
        a.add(new int[]{1, 2, 3, 4, 3, 2, 1});
        a.add(new int[]{1, 1, 2, 3, 2, 1});
        a.add(new int[]{8, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 6});

        for (int[] A : a) {
            System.out.print(Arrays.toString(A));
            System.out.print(": ");
            System.out.println(new EquiLeader().solution(A));
        }
    }
}
