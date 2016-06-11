package Lesson_04;

import java.util.*;

public class MissingInteger {

    // 77 %
//    public int solution2(int[] A) {
//        int N = A.length;
//        boolean[] found = new boolean[N];
//        for (int i = 0; i < N; i++) {
//            int val = A[i] - 1; // zero based
//            if (val < 0 || val > N - 1) {
//                continue;
//            }
//            found[val] = true;
//        }
//        for (int i = 0; i < N; i++) {
//            if (!found[i]) {
//                return i + 1;
//            }
//        }
//        return -1;
//    }
    
    // 100% but ugly
    public int solution(int[] A) {
        int N = A.length;
        Arrays.sort(A);
        boolean passedZero = false;
        int i = -1;
        int expected = 1;
        int val = Integer.MAX_VALUE;
        while (++i < N) {
            if (A[i] == val) {
                continue;
            }
            val = A[i]; // zero based
            if (!passedZero) {
                if (val < 1) {
                    continue;
                }
                passedZero = true;
            }
            if (val != expected) {
                return expected;
            }
            expected++;
        }
        if (!passedZero) {
            return 1;
        }
        return A[N - 1] + 1;
    }

    public static void Test() {
        ArrayList<int[]> a = new ArrayList<>();
        a.add(new int[]{1, 3, 6, 4, 1, 2});
        a.add(new int[]{4});
        a.add(new int[]{0});
        a.add(new int[]{-1});
        a.add(new int[]{-1, -2, -3});
        a.add(new int[]{4, 1, 3, 2});
        a.add(new int[]{4, 1, 3});
        a.add(new int[]{1, 2, 1});
        a.add(new int[]{0, 0, 0});
        a.add(new int[]{9, 9, 1});
        a.add(new int[]{1, 1, 1, 2, 2, 2, -2, -2});
        a.add(new int[]{-1, -1, 1, 2, 2});

        for (int[] A : a) {
            System.out.print(Arrays.toString(A));
            System.out.print(": ");
            System.out.println(new MissingInteger().solution(A));
        }
    }
}
