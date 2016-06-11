package Lesson_12;

import java.util.*;

public class ChocolatesByNumbers {

    /*
    // https://codility.com/demo/results/trainingBZFRMB-GWU/
    // not perfectly performant...
    public int solution1(int N, int M) {
        int count = 0;
        int X = 0;
        do {
            X += N;
            count += X / M;
            X = X % M; //leftovers
        } while (X != 0);
        return count;
    }
     */
    public int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }

    // thtps://codility.com/demo/results/trainingW6E7T7-ZRA/
    // this gets 100%
    public int solution2(int N, int M) {
        return N / gcd(N, M);
    }

    public int gcdBin(int a, int b, int e) {
        if (a == b) {
            return a * e;
        } else if (a == 1 || b == 1) {
            return e;
        } else if (a % 2 == 0 && b % 2 == 0) {
            return gcdBin(a / 2, b / 2, e * 2);
        } else if (a % 2 == 0) {
            return gcdBin(a / 2, b, e);
        } else if (b % 2 == 0) {
            return gcdBin(a, b / 2, e);
        } else if (a > b) {
            return gcdBin(a - b, b, e);
        } else {
            return gcdBin(a, b - a, e);
        }
    }

    // https://codility.com/demo/results/training8Y2MZ3-4GM/
    // also gets 100%
    public int solution(int N, int M) {
        return N / gcdBin(N, M, 1);
    }

    public static void Test() {

        ChocolatesByNumbers t = new ChocolatesByNumbers();
//        System.out.println(t.gcd(25, 100));
//        System.out.println(t.gcd(25, 60));

        ArrayList<int[]> array = new ArrayList<>();
        array.add(new int[]{10, 4});
        array.add(new int[]{1, 1});
        array.add(new int[]{7, 1});
        array.add(new int[]{8, 2});

        for (int[] A : array) {
            System.out.print(Arrays.toString(A));
            System.out.print(": ");
            int a = A[0];
            int b = A[1];
            System.out.println(t.solution(a, b));
            //System.out.println(t.solution1(a, b));
            System.out.println(t.solution2(a, b));
        }
    }
}
