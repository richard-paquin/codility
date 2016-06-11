package Lesson_05;

import java.util.*;

public class CountDiv {

    // 100% -- 1st attempt
    public int solution(int A, int B, int K) {
        assert A <= B;
        int count = B / K;
        int skipped = A / K;
        if (A % K == 0) {
            skipped -= 1;
        }
        return count - skipped;
    }

    public static void Test() {
        ArrayList<int[]> inputs = new ArrayList<>();
        inputs.add(new int[]{6, 11, 2});
        inputs.add(new int[]{1, 10, 1});
        inputs.add(new int[]{1, 10, 2});
        inputs.add(new int[]{1, 2, 1});
        inputs.add(new int[]{1, 2, 2});
        inputs.add(new int[]{1, 1, 2});
        inputs.add(new int[]{2, 3, 2});
        inputs.add(new int[]{2, 4, 2});
        inputs.add(new int[]{2000000000, 2000000000, 1});
        inputs.add(new int[]{2000000000, 2000000000, 2000000000});
        inputs.add(new int[]{0, 2000000000, 1});
        inputs.add(new int[]{0, 2000000000, 2000000000});
//        a.add(new int[]{-1, 0, 1});
//        a.add(new int[]{-2, -1, 0});
//        a.add(new int[]{-2, -1, 1});
//        a.add(new int[]{-3, -2, -1});

        for (int[] input : inputs) {
            System.out.print(Arrays.toString(input));
            int A = input[0];
            int B = input[1];
            int K = input[2];
            System.out.print(": ");
            System.out.println(new CountDiv().solution(A, B, K));
        }
    }
}
