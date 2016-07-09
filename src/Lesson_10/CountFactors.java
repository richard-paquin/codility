package Lesson_10;

public class CountFactors {

    public int solution(int N) {
        assert N > 0;
        if (N < 2) {
            return 1;
        }
        int count = 2;
        int s = (int) Math.sqrt(N);
        for (int i = 2; i <= s; i++) {
            if (N % i == 0) {
                count += 2;
            }
        }
        if (s * s == N) {
            count--;
        }
        return count;
    }
}
