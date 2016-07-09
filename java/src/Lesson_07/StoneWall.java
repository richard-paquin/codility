package Lesson_07;

import java.util.*;

public class StoneWall {

    public int solution(int[] H) {
        int N = H.length;
        Stack<Integer> stack = new Stack<>();
        int stackSum = 0;
        int blockCount = 0;
        for (int i = 0; i < N; i++) {
            while (stackSum > H[i]) {
                stackSum -= stack.pop();
            }
            H[i] -= stackSum;
            if (H[i] > 0) {
                stack.add(H[i]);
                stackSum += H[i];
                blockCount++;
            }
        }
        return blockCount;
    }

}
