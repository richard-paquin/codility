package Lesson_01_03;

import java.util.*;

public class PermMissingElem {

    public int solution(int[] A) {
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
        return A.length + 1;
    }

    public static void Test() {
        ArrayList<int[]> a = new ArrayList<>();
        a.add(new int[]{1, 3});
        a.add(new int[]{3, 1});
        a.add(new int[]{1, 2});
        a.add(new int[]{2, 3});
        a.add(new int[]{1});
        a.add(new int[]{2});

        for (int[] A : a) {
            System.out.print(Arrays.toString(A));
            System.out.print(": ");
            System.out.println(new PermMissingElem().solution(A));
        }
    }
}
