package Lesson_12;

public class CommonPrimeDivisors {

    int getGcdBin(int a, int b, int r) {
        if (a == b) {
            return a * r;
        } else if (b % 2 == 0 && a % 2 == 0) {
            return getGcdBin(a / 2, b / 2, r * 2);
        } else if (a % 2 == 0) {
            return getGcdBin(a / 2, b, r);
        } else if (b % 2 == 0) {
            return getGcdBin(a, b / 2, r);
        } else if (a > b) {
            return getGcdBin(a - b, b, r);
        } else {
            return getGcdBin(a, b - a, r);
        }
    }

    int getGcd(int N, int M) {
        return getGcdBin(N, M, 1);
    }

    // https://codility.com/demo/results/training8WA877-SVN/
    // 100%, first try, 1 hour. feels good.
    // improvement : probably no need to calculate all gcd like that.
    public int solution(int[] A, int[] B) {
        int count = 0;
        int N = A.length;
        for (int i = 0; i < N; i++) {
            int a = A[i];
            int b = B[i];
            int gcd = getGcd(a, b);
            a /= gcd;
            b /= gcd;

            int gcd2 = getGcd(a, gcd);
            while (gcd2 != 1) {
                a /= gcd2;
                gcd2 = getGcd(a, gcd);
            }
            if (a != 1) {
                continue;
            }
            gcd2 = getGcd(b, gcd);
            while (gcd2 != 1) {
                b /= gcd2;
                gcd2 = getGcd(b, gcd);
            }
            if (b != 1) {
                continue;
            }
            count++;
        }
        return count;
    }

}
