package Lesson_10;

public class Flags {

    // https://codility.com/demo/results/trainingSHTC9G-62U/
    public int solution(int[] A) {
        int N = A.length;
        if (N < 3) {
            return 0;
        }

        // this situation allows to avoid N+1 prefix sum
        int[] sumPeaks = new int[N];
        sumPeaks[0] = sumPeaks[1] = 0;
        for (int i = 1; i < N - 1; i++) {
            sumPeaks[i] = sumPeaks[i - 1];
            if ((A[i] > A[i - 1]) && (A[i] > A[i + 1])) {
                sumPeaks[i]++;
            }
        }
        sumPeaks[N - 1] = sumPeaks[N - 2];
        if (sumPeaks[N - 1] == 0) {
            return 0;
        }

        int maxFlags = 0;
        for (int K = 1; K * K < N; K++) {
            int usedFlags = 0;
            for (int i = 1; i < N - 1; i++) {
                if (sumPeaks[i] == sumPeaks[i - 1]) {
                    continue;
                }
                int begin = i;
                int end = begin + K;
                if (end < N && sumPeaks[begin] - sumPeaks[end] > 0) {
                    return maxFlags - 1;
                }
                if (end >= N && sumPeaks[begin] - sumPeaks[N - 1] > 0) {
                    return maxFlags - 1;
                }
                i = end - 1;
                usedFlags++;
                if (usedFlags == K) {
                    break;
                }
            }
            maxFlags = Math.max(maxFlags, usedFlags);
        }

        return maxFlags;
    }

}
