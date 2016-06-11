package Lesson_10;

import java.util.*;

public class Peaks {

    // https://codility.com/demo/results/trainingC73932-MUR/
    // https://codility.com/demo/results/training6SGF9W-UB6/
    // ...
    // https://codility.com/demo/results/training8XFUK6-E88/
    // even when finding a possible mistake, couldn't get it to 100%
    // ...
    // wondering if the problem is linked to the possibility that peaks needs a
    // length of N + 1...
    // FINALLY !
    // https://codility.com/demo/results/trainingFD545P-UJG/
    // 
    public int solution(int[] A) {
        int N = A.length;
        if (N < 3) {
            return 0;
        }

        // make prefix sum for peaks
        int[] sumPeaks = new int[N + 1];
        sumPeaks[0] = 0;
        for (int i = 1; i < N - 1; i++) {
            sumPeaks[i + 1] = sumPeaks[i];
            if ((A[i] > A[i - 1]) && (A[i] > A[i + 1])) {
                sumPeaks[i + 1]++;
            }
        }
        sumPeaks[N] = sumPeaks[N - 1];
        if (sumPeaks[N] == 0) {
            return 0;
        }

        // check for all vals of i
        int max = 0;
        int i = 1;
        while (i * i <= N) {
            if (N % i != 0) {
                i++;
                continue;
            }
            // check i
            if (i > max && checkBlocks(i, sumPeaks)) {
                max = i;
            }
            // check N / i
            if (N / i > max && checkBlocks(N / i, sumPeaks)) {
                max = N / i;
            }
            i++;
        }
        return max;
    }

    public boolean checkBlocks(int blocks, int[] sumPeaks) {
        int N = sumPeaks.length - 1;
        int blockLen = N / blocks;
        for (int j = 0; j < blocks; j++) {
            int blockBegin = blockLen * j;
            int blockEnd = blockLen * j + blockLen;
            if (sumPeaks[blockEnd] <= sumPeaks[blockBegin]) {
                return false;
            }
        }
        return true;
    }

    public static void Test() {
        ArrayList<int[]> a = new ArrayList<>();
        a.add(new int[]{1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2});
        a.add(new int[]{0, 2, 1, 1, 2, 3, 0, 1, 2, 1, 6, 2});
        a.add(new int[]{0, 2, 1, 1, 2, 3, 0, 1, 2, 1, 6, 2});
        a.add(new int[]{2, 1, 0, 2, 1, 0, 2, 1, 0, 2, 1, 0});
        a.add(new int[]{0, 1, 2, 0, 1, 2, 0, 1, 2, 0, 1, 2});
        a.add(new int[]{0, 1, 0});
        a.add(new int[]{0, 1, 1, 0});
        a.add(new int[]{1, 2, 3, 4, 5, 6});
        a.add(new int[]{6, 5, 4, 3, 2, 1});
        a.add(new int[]{1, 2, 3, 2, 1});
        a.add(new int[]{1, 2, 3, 3, 2, 1});
        a.add(new int[]{3, 2, 1, 2, 3});

        a.add(new int[]{1});
        a.add(new int[]{0, 1, 0, 1, 0});
        a.add(new int[]{0, 1, 0, 0, 1, 0, 0, 1, 0});
        a.add(new int[]{0, 0, 1, 0, 1, 0});
        for (int[] A : a) {
            System.out.print(Arrays.toString(A));
            System.out.print(": ");
            System.out.println(new Peaks().solution(A));
        }
    }
}