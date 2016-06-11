package Lesson_05;

import java.util.*;

public class PassingCars {

    // A[0] = 0   A[1] = 1   A[2] = 0   A[3] = 1   A[4] = 1
    // Five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).
    public int solution(int[] A) {
        int count = 0;
        int crossings = 0;
        int leftBound = 0;
        // ignore west cars traveling west
        while (leftBound < A.length && A[leftBound] == 1) {
            leftBound += 1;
        }
        for (int x = A.length - 1; x >= leftBound; x--) {
            if (A[x] == 1) {
                count += 1;
            } else {
                // will naturally ignore east cars traveling east
                crossings += count;
                if (crossings > 1000000000) {
                    return -1;
                }
            }
        }
        return crossings;
    }

    public static void Test() {
        ArrayList<int[]> a = new ArrayList<>();
        a.add(new int[]{0});
        a.add(new int[]{1});
        a.add(new int[]{0, 1});
        a.add(new int[]{1, 0});
        a.add(new int[]{1, 1});
        a.add(new int[]{0, 0});
        a.add(new int[]{1, 1, 1, 1, 0});
        a.add(new int[]{0, 1, 1, 1, 1});
        a.add(new int[]{1, 0, 0, 0, 0});
        a.add(new int[]{0, 0, 0, 0, 1});
//        a.add(new int[]{2, 1});
//        a.add(new int[]{1, 2, 3});
//        a.add(new int[]{-1, 0, 1});
//        a.add(new int[]{-2, -1, 0});
//        a.add(new int[]{-2, -1, 1});
//        a.add(new int[]{-3, -2, -1});
        a.add(new int[]{0, 1, 0, 1, 1});

        for (int[] A : a) {
            System.out.print(Arrays.toString(A));
            System.out.print(": ");
            System.out.println(new PassingCars().solution(A));
        }
    }
}
