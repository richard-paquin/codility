package Lesson_12;

// https://codility.com/demo/results/trainingBZFRMB-GWU/
// not perfectly performant...
public class ChocolatesByNumbers {

    public int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }

    // https://codility.com/demo/results/trainingW6E7T7-ZRA/
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

}
