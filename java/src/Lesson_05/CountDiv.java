package Lesson_05;

public class CountDiv {

    // 100% -- 1st attempt
    public int solution(int A, int B, int K) {
        assert A <= B;
        int count = B / K;
        int skipped = A / K;
        if (A % K == 0) {
            skipped -= 1;
        }
        return count - skipped;
    }

}
