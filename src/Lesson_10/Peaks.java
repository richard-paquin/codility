package Lesson_10;

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

}
