package Lesson_15;

public class AbsDistinct {

    // screw it, we use a prev val, AND abs. that should do it !
    // https://codility.com/demo/results/trainingNVKT9U-KE8/
    // and finally
    // https://codility.com/demo/results/trainingT5MX54-9P3/
    // but I hate that casting...
    public int solution(int[] A) {
        int N = A.length;
        int head = N - 1;
        int tail = 0;
        int count = 1;
        int prevVal = A[0] == Integer.MIN_VALUE
                ? Integer.MIN_VALUE : Math.max(Math.abs(A[tail]), A[head]);
        while (tail <= head) {
            int t = Math.abs(A[tail]);
            int h = Math.abs(A[head]);
            if (t == prevVal) {
                tail++;
                continue;
            }
            if (h == prevVal) {
                head--;
                continue;
            }
            if (t >= h) {
                count++;
                prevVal = t;
                tail++;
            } else {
                count++;
                prevVal = h;
                head--;
            }
        }
        return count;
    }

    // https://codility.com/demo/results/trainingTNVXA3-FZ8/
    // m'eh...
    // https://codility.com/demo/results/trainingQUBVSB-XJ5/
    // what I learned from this : 
    // why the heck didn't I use abs before ?
    // thought I was being smart using sum to find opposites...
    // https://codility.com/demo/results/trainingAH58A7-A6U/
    public int solution2(int[] A) {
        int N = A.length;
        if (N < 2) {
            return 1;
        }
        int head = N - 1;
        int tail = 0;
        int count = 0;
        while (tail <= head) {
            // skip same values
            if (tail > 1 && A[tail] == A[tail - 1]) {
                tail++;
                continue;
            }
            if (head < N - 1 && A[head] == A[head + 1]) {
                head--;
                continue;
            }
            long atVal = Math.abs((long) A[tail]);
            long ahVal = Math.abs((long) A[head]);
            count += 1;
            if (atVal == ahVal) {
                tail++;
                head--;
            } else if (atVal > ahVal) {
                tail++;
            } else if (atVal < ahVal) {
                head--;
            }
        }
        return count;
    }

    /* 
    strategy: start at both ends
    move tail forward while A[tail+ 1] == A[tail]
    therefore move head backward while A[head - 1] == A[head]
    if A[tail] < 0
    if 
     */
    // 7% ??? oh crap.
    // https://codility.com/demo/results/training2CY36P-PHC/
    // 42% -- tabarnak.
    // https://codility.com/demo/results/trainingH3K35E-4EU/
    public int solution1(int[] A) {
        int N = A.length;
        if (N < 2) {
            return 1;
        }
        int head = N - 1;
        int tail = 0;
        int count = 1;
        while (tail <= head) {
            long hVal = A[head];
            long tVal = A[tail];
            long sum = tVal + hVal;
            if (sum == 0) {
                tail++;
                continue;
            }
            count++;
            if (sum < 0) {
                tail++;
            }
            if (sum > 0) {
                head--;
            }
        }
        return count;
    }
    
}
