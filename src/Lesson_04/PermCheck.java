package Lesson_04;

import java.util.*;

public class PermCheck {

    public int solution(int[] A) {
        int N = A.length;
        boolean[] found = new boolean[N];
        for (int i = 0; i < N; i++) {
            int val = A[i] - 1; //zero based
            if (val >= N) {
                return 0;
            }
            if (found[val]) {
                return 0;
            }
            found[val] = true;
        }
        return 1;
    }

    public static void Test() {
        ArrayList<int[]> a = new ArrayList<>();
        a.add(new int[]{1});
        a.add(new int[]{4});
        a.add(new int[]{4, 1, 3, 2});
        a.add(new int[]{4, 1, 3});
        a.add(new int[]{1, 2, 1});

        for (int[] A : a) {
            System.out.print(Arrays.toString(A));
            System.out.print(": ");
            System.out.println(new PermCheck().solution(A));
        }
    }
}
