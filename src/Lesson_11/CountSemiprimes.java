package Lesson_11;

public class CountSemiprimes {

    // https://codility.com/demo/results/trainingE48BMA-ZRU/
    // https://codility.com/demo/results/trainingTMUPAB-69Q/
    int[] getPrimes(int N) {
        int[] f = new int[N];
        int i = 2;
        while (i < N) {
            if (f[i] == 0) {
                long k = (long) i * i;
                while (k < N) {
                    f[(int) k] = i;
                    k += i;
                }
            }
            i++;
        }
        return f;
    }

    public int[] solution(int N, int[] P, int[] Q) {

        int[] primes = getPrimes(N + 1);
        int s = (int) Math.sqrt(N);

        // construct semi-primes arr                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
        int[] semiPrimes = new int[N + 1];
        for (int i = 2; i < N + 1; i++) {
            if (primes[i] == 0) {
                continue;
            }
            int j = 2;
            while (j * j <= i) {
                if (primes[j] == 0 && i % j == 0) {
                    int k = i / j;
                    if (primes[k] == 0) {
                        semiPrimes[j * k] = 1;
                    }
                }
                j++;
            }
        }

        int[] countPrimes = new int[N + 2];
        for (int i = 1; i < N + 2; i++) {
            countPrimes[i] = countPrimes[i - 1];
            if (semiPrimes[i - 1] == 1) {
                countPrimes[i]++;
            }
        }

        int[] retVal = new int[P.length];
        for (int i = 0; i < P.length; i++) {
            retVal[i] = countPrimes[Q[i] + 1] - countPrimes[P[i]];
        }

        return (retVal);
    }

    static int randomWithRange(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }

}
