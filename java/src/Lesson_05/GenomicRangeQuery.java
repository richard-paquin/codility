package Lesson_05;

public class GenomicRangeQuery {

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
     *
     * @param c G-A-T-C
     * @return 2-0-3-1
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
                return 3;
            default:
                throw new IllegalArgumentException();
        }
    }

}
