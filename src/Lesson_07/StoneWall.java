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

    public static void Test() {
        ArrayList<int[]> a = new ArrayList<>();
        a.add(new int[]{8, 8, 5, 7, 9, 8, 7, 4, 8});
        a.add(new int[]{0});
        a.add(new int[]{1});
        a.add(new int[]{1, 1});
        a.add(new int[]{1, 2});
        a.add(new int[]{2, 1});
        a.add(new int[]{1, 2, 3});
        a.add(new int[]{-1, 0, 1});
        a.add(new int[]{-2, -1, 0});
        a.add(new int[]{-2, -1, 1});
        a.add(new int[]{-3, -2, -1});

        for (int[] A : a) {
            System.out.print(Arrays.toString(A));
            System.out.print(": ");
            System.out.println(new StoneWall().solution(A));
            break;
        }
    }
}
