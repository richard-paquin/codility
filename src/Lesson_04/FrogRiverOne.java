package Lesson_04;

public class FrogRiverOne {

    public int solution(int X, int[] A) {
        boolean[] hasLeaf = new boolean[X];
        for (int i = 0; i < A.length; i++) {
            int val = A[i] - 1; // zero based
            if (hasLeaf[val]) {
                continue; // already known
            }
            hasLeaf[val] = true;
            X--;
            if (X == 0) {
                return i;
            }
        }
        return -1;
    }

}
