package Lesson_01_03;

public class TapeEquilibrium {

    public int solution(int[] A) {
        int len = A.length;
        int totalSum = 0;
        for (int i = 0; i < len; i++) {
            totalSum += A[i];
        }
        int left = 0, right = totalSum;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < len - 1; i++) {
            left += A[i];
            right -= A[i];
            int diff = Math.abs(left - right);
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        return minDiff;
    }

}
