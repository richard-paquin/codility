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

}
