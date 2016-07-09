package Lesson_05;

public class PassingCars {

    // A[0] = 0   A[1] = 1   A[2] = 0   A[3] = 1   A[4] = 1
    // Five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).
    public int solution(int[] A) {
        int count = 0;
        int crossings = 0;
        int leftBound = 0;
        // ignore west cars traveling west
        while (leftBound < A.length && A[leftBound] == 1) {
            leftBound += 1;
        }
        for (int x = A.length - 1; x >= leftBound; x--) {
            if (A[x] == 1) {
                count += 1;
            } else {
                // will naturally ignore east cars traveling east
                crossings += count;
                if (crossings > 1000000000) {
                    return -1;
                }
            }
        }
        return crossings;
    }

}
