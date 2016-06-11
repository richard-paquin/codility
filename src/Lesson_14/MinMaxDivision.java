package Lesson_14;

public class MinMaxDivision {

    public int solution(int K, int M, int[] A) {
        int N = A.length;
        int[] pSum = new int[N + 1];
        for (int i = 0; i < N; i++) {
            pSum[i + 1] = pSum[i] + A[i];
        }
        return -1;
    }

}
