package Lesson_01_03;

public class FrogJmp {

    int solution(int X, int Y, int D) {
        Y -= X;
        int jump = 0;
        while (Y > 0) {
            Y -= D;
            jump++;
        }
        return jump;
    }

    int solution2(int X, int Y, int D) {
        Y -= X;
        if (Y > 0) {
            if (Y % D == 0) {
                return Y / D;
            }
            return Y / D + 1;
        }
        return 0;
    }

}
