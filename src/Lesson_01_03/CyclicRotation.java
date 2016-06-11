package Lesson_01_03;

import java.util.*;

public class CyclicRotation {

    public int[] solution(int[] A, int K) {
        int len = A.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[(i + K) % len] = A[i];
        }
        return result;
    }

    public static void Test() {
        CyclicRotation r = new CyclicRotation();
        ArrayList<int[]> a = new ArrayList<>();
        a.add(new int[]{3, 8, 9, 7, 6});
        for (int[] x : a) {
            x = r.solution(x, 1);
            System.out.println(Arrays.toString(x));
        }
    }
}
