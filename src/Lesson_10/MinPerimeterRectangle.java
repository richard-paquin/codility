package Lesson_10;

public class MinPerimeterRectangle {

    public int solution(int N) {
        int s = (int) Math.sqrt(N);
        if (s * s == N) {
            return 4 * s;
        }
        for (int i = s; i > 0; i--) {
            if (N % i == 0) {
                return 2 * (i + N / i);
            }
        }
        return -1;
    }

}
