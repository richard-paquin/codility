package Lesson_10;

import java.util.*;

public class CountFactors {

    public int solution(int N) {
        assert N > 0;
        if (N < 2) {
            return 1;
        }
        int count = 2;
        int s = (int) Math.sqrt(N);
        for (int i = 2; i <= s; i++) {
            if (N % i == 0) {
                count += 2;
            }
        }
        if (s * s == N) {
            count--;
        }
        return count;
    }

    public static void Test() {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(36);
        a.add(30);
        a.add(1);
        a.add(17);
        a.add(24);
        a.add(25);

        for (int A : a) {
            System.out.print(A);
            System.out.print(": ");
            System.out.println(new CountFactors().solution(A));
        }
    }
}