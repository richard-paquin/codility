package Lesson_01_03;

import java.util.*;

public class OddOccurrencesInArray {

    public int solution(int[] A) {
        int len = A.length;
        for (int i = 0; i < len; i++) {
            int val = A[i];
            if (val == Integer.MAX_VALUE) {
                continue;
            }
            boolean found = false;
            for (int j = i + 1; j < len; j++) {
                if (A[j] == val) {
                    A[j] = Integer.MAX_VALUE;
                    found = true;
                    break;
                }
            }
            if (!found) {
                return val;
            }
        }
        return -1;
    }

    public int solution2(int[] A) {
        TreeSet<Integer> t = new TreeSet<>();
        int len = A.length;
        for (int i = 0; i < len; i++) {
            int val = A[i];
            if (t.contains(val)) {
                t.remove(val);
            } else {
                t.add(val);
            }
        }
        assert t.size() == 1;
        return t.first();
    }

    public int solution3(int[] A) {
        Arrays.sort(A);
        for (int i = 0; i < A.length - 3; i += 2) {
            if (A[i] != A[i + 1]) {
                return A[i];
            }
        }
        return A[A.length - 1];
    }

}
