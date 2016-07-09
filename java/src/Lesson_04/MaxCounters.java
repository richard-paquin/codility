package Lesson_04;

public class MaxCounters {

    // 100% -- 1st attempt (yay)
    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int currentMin = 0; // dont iterate on all values for A[K] >= N
        int currentMax = 0;
        for (int X : A) {
            X--; // zero based
            if (X >= N) {
                currentMin = currentMax;
            } else {
                counters[X] = Math.max(currentMin + 1, counters[X] + 1);
                if (counters[X] > currentMax) {
                    currentMax = counters[X];
                }
            }
        }
        for (int i = 0; i < N; i++) {
            counters[i] = Math.max(currentMin, counters[i]);
        }
        return counters;
    }

}
