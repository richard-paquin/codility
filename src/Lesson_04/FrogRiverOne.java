package Lesson_04;

import java.util.*;

public class FrogRiverOne {

    public int solution(int X, int[] A) {
        boolean[] hasLeaf = new boolean[X];
        for (int i = 0; i < A.length; i++) {
            int val = A[i] - 1; // zero based
            if (hasLeaf[val]) {
                continue; // already known
            }
            hasLeaf[val] = true;
            X--;
            if (X == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void Test() {
        ArrayList<int[]> a = new ArrayList<>();
        a.add(new int[]{1, 3, 1, 4, 2, 3, 5,});

        for (int[] A : a) {
            System.out.print(Arrays.toString(A));
            System.out.print(": ");
            System.out.println(new FrogRiverOne().solution(5, A));
        }
    }
}
