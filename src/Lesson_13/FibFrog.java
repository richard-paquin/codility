package Lesson_13;

import java.util.*;

public class FibFrog {
    // we need to divide the array in sections which are additions of fibonacci numbers

    // https://codility.com/demo/results/trainingSTYHXU-Y9A/ (33%)
    // faster attempt:
    // https://codility.com/demo/results/trainingHGYDDZ-BN3/ (still 33%)
    // better with memory...
    // https://codility.com/demo/results/trainingVUNFAK-8F5/ (58%)
    // realised an error with -1
    // https://codility.com/demo/results/trainingTPASQA-8PM/
    // this got 75%. 
    // it could be improved by going in reverse !
    // ooohhh... I should redo it in reverse.
    // https://codility.com/demo/results/trainingZ8ZTFS-RF6/
    TreeSet<Integer> buildFib(int N) {
        TreeSet<Integer> a = new TreeSet<>();
        int x1 = 1;
        int x2 = 2;
        a.add(1);
        a.add(2);
        int x3;
        do {
            x3 = x2 + x1;
            a.add(x3);
            x1 = x2;
            x2 = x3;

        } while (x3 < N);
        return a;
    }

    public int solution(int[] A) {
        TreeSet<Integer> fib = buildFib(100000);
        int minJump = FrogJump(A, fib);
        return minJump == Integer.MAX_VALUE ? -1 : minJump;
    }

    public int FrogJump(int[] A, TreeSet<Integer> fib) {
        int begin = -1;
        int N = A.length;
        HashMap<Integer, Integer> mem = new HashMap<>();
        mem.put(N, 0);
        if (fib.contains(N - begin)) {
            return 1;
        }
        for (int i = N - 1; i >= begin; i--) {
            if (i == begin || A[i] == 1) {
                int minVal = Integer.MAX_VALUE;
                for (int x : mem.keySet()) {
                    if (fib.contains(x - i)) {
                        int val = mem.get(x) + 1;
                        minVal = Math.min(val, minVal);
                    }
                }
                if (minVal != Integer.MAX_VALUE) {
                    mem.put(i, minVal);
                }
            }
        }
        if (!mem.containsKey(begin)) {
            return -1;
        }
        return mem.get(begin);
    }

    ////////////////////////////////////////////////////////////////////////////
    // INITIAL FORWARD IMPLEMENTATION
    ////////////////////////////////////////////////////////////////////////////
    HashMap<Integer, Integer> memory = new HashMap<>();

    public int FrogJump(int[] A, TreeSet<Integer> fib, int begin) {
        int N = A.length;
        int minJumps = Integer.MAX_VALUE;
        if (fib.contains(N - begin)) { // can jump to end
            return 1;
        }
        for (int i : fib) {
            int next = i + begin;
            int jumps;
            if (next > N) {
                break;
            }
            if (A[next] != 1) {
                continue;
            }
            if (memory.containsKey(next)) {
                jumps = memory.get(next);
            } else {
                jumps = FrogJump(A, fib, next);
            }
            if (jumps == Integer.MAX_VALUE) { // impossible
                continue;
            }
            jumps += 1;
            minJumps = Math.min(jumps, minJumps);
            if (minJumps == 2) {
                break;
            }
        }

        memory.put(begin, minJumps);
        return minJumps;
    }

    public int solution2(int[] A) {
        TreeSet<Integer> fib = buildFib(100000);
        int minJump = FrogJump(A, fib, -1);
        return minJump == Integer.MAX_VALUE ? -1 : minJump;
    }

    ////////////////////////////////////////////////////////////////////////////
    //
    ////////////////////////////////////////////////////////////////////////////
    public int getRandElement(int[] array) {
        int pos = new Random().nextInt() % array.length;
        return array[pos];
    }

    public int[] buildUnbreakableFrogPath(int N) {
        TreeSet<Integer> f = buildFib(1000);
        Integer[] fib = f.toArray(new Integer[f.size()]);
        Arrays.sort(fib);
        ArrayList<Integer> jumps = new ArrayList<>();
        System.out.println("frog path of " + N + " elements");
        int pathSize = 0;
        for (int i = 0; i < N; i++) {
            int pos = new Random().nextInt(5) * 2;
            pathSize += fib[pos];
            if (pathSize > 100000) {
                pathSize -= pos;
                break;
            }
            jumps.add(fib[pos]);
        }
        System.out.println(Arrays.toString(jumps.toArray()));
        int[] path = new int[pathSize - 1];
        int pos = -1;
        for (int i : jumps) {
            pos += i;
            if (pos == pathSize - 1) {
                System.out.println("confirmed");
                break;
            }
            path[pos] = 1;
        }
        return path;
    }

    public int[] buildPureFrogPath(int N) {
        TreeSet<Integer> f = buildFib(1000);
        Integer[] fib = f.toArray(new Integer[f.size()]);
        ArrayList<Integer> jumps = new ArrayList<>();
        System.out.println("frog path of " + N + " elements");
        int pathSize = 0;
        for (int i = 0; i < N; i++) {
            int pos = new Random().nextInt(fib.length);
            pathSize += fib[pos];
            if (pathSize > 100000) {
                pathSize -= pos;
                break;
            }
            jumps.add(fib[pos]);
        }
        System.out.println(Arrays.toString(jumps.toArray()));
        int[] path = new int[pathSize - 1];
        int pos = -1;
        for (int i : jumps) {
            pos += i;
            if (pos == pathSize - 1) {
                System.out.println("confirmed");
                break;
            }
            path[pos] = 1;
        }
        return path;
    }

    public int[] buildPureFrogPath(int[] jumps) {
        System.out.println(Arrays.toString(jumps));
        int pathSize = 0;
        for (int i : jumps) {
            pathSize += i;
        }
        int[] path = new int[pathSize - 1];
        int pos = -1;
        for (int i : jumps) {
            pos += i;
            if (pos == pathSize - 1) {
                System.out.println("confirmed");
                break;
            }
            path[pos] = 1;
        }
        return path;
    }

    public int[] scrambleFrogPath(int[] frogPath) {
        int N = frogPath.length;
        for (int i = 0; i < 10; i++) {
            int pos = new Random().nextInt(N);
            frogPath[pos] = 1;
        }
        return frogPath;
    }

    public int[] buildScrambledFrogPath(int N) {
        int[] frogPath = buildPureFrogPath(N);
        frogPath = scrambleFrogPath(frogPath);
        return frogPath;
    }

    public static void Test() {
        FibFrog t = new FibFrog();
        ArrayList<int[]> a = new ArrayList<>();

        a.add(t.buildPureFrogPath(new int[]{8, 3, 3, 55, 8, 1, 3, 1, 21, 3}));
        a.add(new int[]{0, 0, 0});
        //a.add(t.buildPureFrogPath(2));
        // a.add(t.buildPureFrogPath(5));

        for (int i = 1; i < 1000; i++) {
            int count = 50;
            int[] frogPath = t.buildScrambledFrogPath(count);
            int result = t.solution(frogPath);
            if (result > count) {
                int x = 0;
            } else if (result < count) {
                System.out.println(result + " < " + count);
            }

        }
        for (int[] A : a) {
            System.out.print(Arrays.toString(A));
            System.out.println(": ");
            System.out.println(t.solution(A));
        }
    }
}
