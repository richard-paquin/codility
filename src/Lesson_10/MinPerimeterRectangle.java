package Lesson_10;

import java.util.*;

public class MinPerimeterRectangle {

    public int solution(int N) {
        int s = (int) Math.sqrt(N);
        if (s * s == N) {
            return 4 * s;
        }
        for (int i = s; i > 0; i--) {
            if (N % i == 0) {
                return 2 * (i + N / i);
            }
        }
        return -1;
    }

    public static void Test() {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(36);
        a.add(30);
        a.add(1);
        a.add(17);

        for (int A : a) {
            System.out.print(A);
            System.out.print(": ");
            System.out.println(new MinPerimeterRectangle().solution(A));
        }
    }
}