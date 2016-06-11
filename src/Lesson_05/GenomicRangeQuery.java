package Lesson_05;

import java.util.*;

public class GenomicRangeQuery {

    /*
    public int getIndex(char c) {
        switch (c) {
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'G':
                return 2;
            case 'T':
                return 3;
            default:
                return -1;
        }
    }

    // 62% -- 0 performance -- 45 minutes;
    public int[] solution(String S, int[] P, int[] Q) {
        assert S.length() > 0 && S.length() <= 100000;
        assert P.length > 0 && P.length <= 50000;
        assert P.length == Q.length;
        int[] retVal = new int[P.length];
        for (int i = 0; i < P.length; i++) {
            boolean[] found = new boolean[4];
            for (int j = P[i]; j <= Q[i]; j++) {
                int index = getIndex(S.charAt(j));
                found[index] = true;
                if (index == 0) {
                    break;
                }
            }

            for (int j = 0; j < 4; j++) {
                if (found[j] == true) {
                    retVal[i] = j + 1;
                    break;
                }
            }
        }
        return retVal;
    }

    // took way too long to make
    // 79 minutes -- again 62% -- 0 performance
    public int[] solution2(String S, int[] P, int[] Q) {
        assert S.length() > 0 && S.length() <= 100000;
        assert P.length > 0 && P.length <= 50000;
        assert P.length == Q.length;
        int[] retVal = new int[P.length];
        for (int x = 0; x < S.length(); x++) {
            for (int K = 0; K < P.length; K++) {
                if (x < P[K] || x > Q[K]) {
                    continue;
                }
                int val = getIndex(S.charAt(x)) + 1;
                if (val < retVal[K] || retVal[K] == 0) {
                    retVal[K] = val;
                }
            }
        }
        return retVal;
    }

    //Correctness = 100% Performance = 33% Total = 75%
    public int[] solution3(String S, int[] P, int[] Q) {
        assert S.length() > 0 && S.length() <= 100000;
        assert P.length > 0 && P.length <= 50000;
        assert P.length == Q.length;
        int[] retVal = new int[P.length];
        for (int x = 0; x < S.length(); x++) {
            char c = S.charAt(x);
            if (c == 'T') {
                continue;
            }
            int impact = 4;

            for (int K = 0; K < P.length; K++) {
                if (retVal[K] == 1) {
                    continue;
                }
                if (x < P[K] || x > Q[K]) {
                    continue;
                }
                if (impact < retVal[K] || retVal[K] == 0) {
                    retVal[K] = impact;
                }
            }
        }
        return retVal;
    }

    ////////////////////////////////////////////////////////////////////////////
    // SOLUTION 4 
    ////////////////////////////////////////////////////////////////////////////
    // score = 37%.... hum....
    class Pair implements Comparable<Pair> {

        int p;
        int q;
        int k;
        int minImpact = 4;

        public Pair(int K, int P, int Q) {
            assert P <= Q;
            assert P >= 0;
            this.p = P;
            this.q = Q;
            this.k = K;
        }

        @Override
        public int compareTo(Pair o) {
            int i = Integer.compare(this.p, o.p);
            if (i == 0) {
                return Integer.compare(this.q, o.q);
            } else {
                return i;
            }
        }
    }

    public int[] solution4(String S, int[] P, int[] Q) {
        assert S.length() > 0 && S.length() <= 100000;
        assert P.length > 0 && P.length <= 50000;
        assert P.length == Q.length;
        Pair[] buffer = new Pair[P.length];
        int len = P.length;
        int K;
        for (K = 0; K < len; K++) {
            buffer[K] = new Pair(K, P[K], Q[K]);
        }
        Arrays.sort(buffer);

        K = 0;
        for (int x = 0; x < S.length(); x++) {
            while (K < len && (buffer[K].p > x || buffer[K].minImpact == 1)) {
                K++;
            }
            char c = S.charAt(x);
            int impact = GetImpact(c);
            for (int i = K; i < len; i++) {
                if (x > buffer[i].q) {
                    continue;
                }
                if (x < buffer[i].p) {
                    break;
                }
                if (buffer[i].minImpact > impact) {
                    buffer[i].minImpact = impact;
                }
            }
        }

        int[] retVal = new int[len];
        for (K = 0; K < len; K++) {
            retVal[buffer[K].k] = buffer[K].minImpact;
        }
        return retVal;
    }
    public int GetImpact(char c) {
        switch (c) {
            case 'A':
                return 1;
            case 'C':
                return 2;
            case 'G':
                return 3;
            default:
                return 4;
        }
    }*/
    ////////////////////////////////////////////////////////////////////////////
    // Solution5
    ////////////////////////////////////////////////////////////////////////////
    // got 100%
    // didnt get how prefix sum could apply until I saw the answer.
    // answer: multiple prefix sum works, trying it all together doesn't
    public int[] solution(String S, int[] P, int[] Q) {
        assert S.length() > 0 && S.length() <= 100000;
        assert P.length > 0 && P.length <= 50000;
        assert P.length == Q.length;
        int genLen = 4;
        int[] retVal = new int[P.length];
        int[][] genome = new int[S.length() + 1][genLen];

        for (int x = 0; x < S.length(); x++) {
            int val = GetIndex(S.charAt(x));
            for (int y = 0; y < genLen; y++) {
                genome[x + 1][y] = (y == val ? genome[x][y] + 1 : genome[x][y]);
            }
        }

        for (int K = 0; K < P.length; K++) {
            for (int y = 0; y < genLen; y++) {
                if ((genome[Q[K] + 1][y] - genome[P[K]][y]) > 0) {
                    retVal[K] = y + 1;
                    break;
                }
            }
        }
        return retVal;
    }

    /**
     * Returns the genomic value of the char (GATC)
     */
    public int GetIndex(char c) {
        switch (c) {
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'G':
                return 2;
            case 'T':
                return 4;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static void Test() {
        ArrayList<Input> inputs = new ArrayList<>();
        inputs.add(new Input("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6}));
        inputs.add(new Input("AAAAAAA", new int[]{2, 5, 0}, new int[]{4, 5, 6}));
        inputs.add(new Input("CCCCCCC", new int[]{2, 5, 0}, new int[]{4, 5, 6}));
        inputs.add(new Input("GGGGGGG", new int[]{2, 5, 0}, new int[]{4, 5, 6}));
        inputs.add(new Input("TTTTTTT", new int[]{2, 5, 0}, new int[]{4, 5, 6}));
        inputs.add(new Input("ACTTTT", new int[]{0, 1}, new int[]{0, 1}));

        for (Input input : inputs) {
            System.out.print(input.toString());
            System.out.print(": ");
            System.out.println(Arrays.toString(new GenomicRangeQuery().solution(
                    input.S, input.P, input.Q)));
        }
    }

    /**
    * A helper class to create inputs for this problem
    */
    static class Input {

        String S;
        int[] P;
        int[] Q;

        public Input(String S, int[] P, int[] Q) {
            this.S = S;
            this.P = P;
            this.Q = Q;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(S);
            sb.append(", ");
            sb.append(Arrays.toString(P));
            sb.append(", ");
            sb.append(Arrays.toString(Q));
            sb.append("]");
            return sb.toString();
        }
    }
}
