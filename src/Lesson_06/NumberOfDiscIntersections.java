package Lesson_06;

import java.util.*;

public class NumberOfDiscIntersections {

    // https://codility.com/demo/results/trainingQ2VG6F-WHP/
    // Note: this solution didn't get 100% in Python
    class Circle implements Comparable<Circle> {

        final long left;
        final long right;
        final long center;
        final long radius;

        Circle(int center, int radius) {
            this.center = center;
            this.radius = radius;
            // do calculation on long already
            this.left = this.center - this.radius;
            this.right = this.center + this.radius;
        }

        @Override
        public int compareTo(Circle o) {
            return Long.compare(this.left, o.left);
        }
    }

    // sort by most left value instead of center
    public int solution(int[] A) {
        int N = A.length;
        if (N < 2) {
            return 0;
        }
        Circle[] circles = new Circle[N];
        for (int i = 0; i < N; i++) {
            circles[i] = new Circle(i, A[i]);
        }
        Arrays.sort(circles);

        int count = 0;
        for (int i = 0; i < N - 1; i++) {
            int j = i + 1;
            while (j < N && circles[i].right >= circles[j].left) {
                j++;
                count++;
                if (count > 10000000) {
                    return -1;
                }
            }
        }
        return count;
    }

}
