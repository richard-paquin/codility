package Lesson_11;

import java.util.*;

public class CountNonDivisible {

    // https://codility.com/demo/results/training4F8XRY-898/
    // ... well... that didn't work...
    // https://codility.com/demo/results/trainingD6QSES-ZV5/
    // ....
    // spent way too much time calculating prime factors and not divisors
    // https://codility.com/demo/results/trainingESN3RV-MPJ/
    // and finally...
    // https://codility.com/demo/results/training3K2HBG-5GP/
    // the use of hashset is ugly & unnecessary
    Integer[] divisors(int x) {
        HashSet<Integer> pf = new HashSet<>();
        int i = 1;
        while (i * i <= x) {
            if (x % i == 0) {
                pf.add(i);
                pf.add(x / i);
            }
            i++;
        }
        Integer[] a = new Integer[pf.size()];

        return pf.toArray(a);
    }

    public int[] solution(int[] A) {
        int N = A.length;
        int[] occurences = new int[2 * N + 1];
        for (int i = 0; i < N; i++) {
            occurences[A[i]]++;
        }

        HashMap<Integer, Integer[]> div = new HashMap<>();
        int[] retVal = new int[N];
        for (int i = 0; i < N; i++) {
            int val = A[i];
            if (!div.containsKey((val))) {
                div.put(val, divisors(val));
            }
            int total = N;
            for (int d : div.get(val)) {
                total -= occurences[d];
            }
            retVal[i] = total;
        }
        return retVal;
    }

}
