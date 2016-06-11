package Lesson_09;

public class MaxProfit {

    public int solution(int[] A) {
        if (A.length == 1 || A.length == 0) {
            return 0;
        }
        int N = A.length;
        int[] profit = new int[N - 1];
        for (int i = 1; i < N; i++) {
            profit[i - 1] = A[i] - A[i - 1];
        }

        int maxProfit = 0;
        int bigMax = 0;
        for (int i = 0; i < N - 1; i++) {
            maxProfit += profit[i];
            if (maxProfit < 0) {
                maxProfit = 0;
            }
            if (maxProfit > bigMax) {
                bigMax = maxProfit;
            }
        }
        return bigMax;
    }

    public int solution2(int[] A) {
        int N = A.length;
        if (N < 2) {
            return 0;
        }
        int[] profit = new int[N - 1];
        for (int i = 1; i < N; i++) {
            profit[i - 1] = A[i] - A[i - 1];
        }
        int maxProfit = 0, currentProfit = 0;
        for (int i = 0; i < profit.length; i++) {
            currentProfit = Math.max(currentProfit + profit[i], 0);
            maxProfit = Math.max(currentProfit, maxProfit);
        }
        return maxProfit;
    }

}
