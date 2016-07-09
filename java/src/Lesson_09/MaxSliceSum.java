package Lesson_09;

public class MaxSliceSum {

    public int solution(int[] A) {
        int N = A.length;
        assert N > 0;
        if (N < 2) {
            return A[0];
        }
        int curMax = A[0];
        int totalMax = A[0];
        for (int i = 1; i < N; i++) {
            if (curMax + A[i] > A[i]) {
                curMax = curMax + A[i];
            } else {
                curMax = A[i];
            }
            totalMax = Math.max(curMax, totalMax);
        }
        return totalMax;
    }

}
