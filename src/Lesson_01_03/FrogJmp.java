package Lesson_01_03;

import java.util.*;

public class FrogJmp {

    int solution(int X, int Y, int D) {
        Y -= X;
        int jump = 0;
        while (Y > 0) {
            Y -= D;
            jump++;
        }
        return jump;
    }

    int solution2(int X, int Y, int D) {
        Y -= X;
        if (Y > 0) {
            if (Y % D == 0)
                return Y / D;
            return Y / D + 1;
        }
        return 0;
    }

    public static void Test() {
        ArrayList<int[]> a = new ArrayList<>();
        a.add(new int[]{10, 85, 30});
        a.add(new int[]{0, 10, 30});
        a.add(new int[]{0, 10, 1});

        for (int[] A : a) {
            int X = A[0];
            int Y = A[1];
            int D = A[2];
            System.out.print(Arrays.toString(A));
            System.out.print(": ");
            System.out.println(new FrogJmp().solution2(X, Y, D));
        }
    }

}
