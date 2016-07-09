package Lesson_01_03;

public class BinaryGap {

    public int maxGap(int N) {
        int maxGapSize = 0;
        int currentGapSize = 0;
        if (N < 1) {
            return 0;
        }
        while ((N & 1) == 0) {
            N = N >> 1;
        }
        while (N > 1) {
            if ((N & 1) == 0) { // is a 0
                currentGapSize += 1;
                if (currentGapSize > maxGapSize) {
                    maxGapSize = currentGapSize;
                }
            } else { // is a one
                currentGapSize = 0;
            }
            N = N >> 1;
        }
        return maxGapSize;
    }

}
