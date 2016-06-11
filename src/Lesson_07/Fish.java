package Lesson_07;

import java.util.*;

public class Fish {

    public int solution(int[] A, int[] B) {
        int N = A.length;
        int safe = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (B[i] == 1) {
                stack.add(A[i]);
            } else if (stack.empty()) {
                safe += 1;
            } else {
                while (stack.peek() < A[i]) {
                    stack.pop();
                    if (stack.isEmpty()) {
                        safe += 1;
                        break;
                    }
                }
            }
        }

        return stack.size() + safe;
    }

    public static void Test() {
        int[] A, B;

        A = new int[]{4, 3, 2, 1, 5};
        B = new int[]{0, 1, 0, 0, 0};
        System.out.print(Arrays.toString(A) + Arrays.toString(B));
        System.out.print(": ");
        System.out.println(new Fish().solution(A, B));

        A = new int[]{4, 3, 2, 1, 5};
        B = new int[]{0, 0, 0, 1, 1};
        System.out.print(Arrays.toString(A) + Arrays.toString(B));
        System.out.print(": ");
        System.out.println(new Fish().solution(A, B));
    }
}
