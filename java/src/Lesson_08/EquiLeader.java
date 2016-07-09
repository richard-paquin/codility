package Lesson_08;

public class EquiLeader {

    public int solution(int[] A) {
        int N = A.length;
        int[] leaderBeginEnd = new int[N];
        int[] leaderEndBegin = new int[N];
        int value = Integer.MAX_VALUE;
        int leaderStack = 0;
        for (int i = 0; i < N; i++) {
            if (leaderStack == 0) {
                value = A[i];
                leaderStack += 1;
            } else if (A[i] == value) {
                leaderStack += 1.0;
            } else {
                leaderStack--;
                if (leaderStack == 0) {
                    value = Integer.MAX_VALUE;
                }
            }
            leaderBeginEnd[i] = value;
        }
        value = Integer.MAX_VALUE;
        leaderStack = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (leaderStack == 0) {
                value = A[i];
                leaderStack += 1;
            } else if (A[i] == value) {
                leaderStack += 1.0;
            } else {
                leaderStack--;
                if (leaderStack == 0) {
                    value = Integer.MAX_VALUE;
                }
            }
            leaderEndBegin[i] = value;
        }
        int equi = 0;
        for (int i = 0; i < N - 1; i++) {
            if (leaderBeginEnd[i] == Integer.MAX_VALUE) {
                continue;
            }
            if (leaderEndBegin[i + 1] == leaderBeginEnd[i]) {
                equi += 1;
            }
        }
        return equi;
    }

}
