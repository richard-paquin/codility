package Lesson_08;

import java.util.*;

public class Dominator {

    public int solution(int[] A) {
        throw new UnsupportedOperationException("Not supported yet.");
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
