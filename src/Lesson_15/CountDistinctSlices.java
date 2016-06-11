package Lesson_15;

import java.util.*;

public class CountDistinctSlices {

    // initial version : https://codility.com/demo/results/trainingY8C3W7-A6S/
    // using array of int, 66% (bad perf)
    // https://codility.com/demo/results/trainingASP5HD-S65/
    // changed to booleans to see...
    // got to a whooping 70% !
    // https://codility.com/demo/results/training9SYZ6E-ZCX/
    // changed to hashset -- got also 70%
    // with reset array -- back to 60%
    // https://codility.com/demo/results/training2AGT46-YAS/
    // then I saw the answer on the Internet. fuck.
    // https://codility.com/demo/results/trainingNWY5WH-U2X/
    // finally got 100%... but... such a bitter taste.
    public int solution(int M, int[] A) {
        int N = A.length;
        int tail = 0;
        int head = 0;
        int count = 0;
        int[] found = new int[M + 1];
        while (tail < N) {
            while (head < N && found[A[head]] == 0) {
                found[A[head]]++;
                head++;
            }
            count += head - tail;
            found[A[tail]] = 0;
            if (count > 1000000000) {
                return 1000000000;
            }
            tail++;
        }
        return count;
    }

    public static void Test() {
        CountDistinctSlices t = new CountDistinctSlices();
        ArrayList<int[]> a = new ArrayList<>();
        a.add(new int[]{3, 4, 5, 5, 2});
        for (int[] A : a) {
            System.out.print(Arrays.toString(A));
            System.out.print(": ");
            System.out.println(t.solution(6, A));
        }
    }
}
