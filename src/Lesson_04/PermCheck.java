package Lesson_04;

public class PermCheck {

    public int solution(int[] A) {
        int N = A.length;
        boolean[] found = new boolean[N];
        for (int i = 0; i < N; i++) {
            int val = A[i] - 1; //zero based
            if (val >= N) {
                return 0;
            }
            if (found[val]) {
                return 0;
            }
            found[val] = true;
        }
        return 1;
    }

}
