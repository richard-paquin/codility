package Lesson_01_03;

public class CyclicRotation {

    public int[] solution(int[] A, int K) {
        int len = A.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[(i + K) % len] = A[i];
        }
        return result;
    }

}
