package Lesson_07;

import java.util.*;

public class Nesting {

    public int solution(String S) {
        char[] str = S.toCharArray();
        int index = 0;
        for (char c : str) {
            index = (c == '(') ? index + 1 : index - 1;
            if (index < 0) {
                return 0;
            }
        }
        return (index == 0) ? 1 : 0;
    }

    public static void Test() {
        ArrayList<String> a = new ArrayList<>();
        a.add(")");
        a.add("(");
        a.add("()");
        a.add(")(");
        a.add("(()");
        a.add("())");
        a.add("(())");
        a.add("()()");

        for (String A : a) {
            System.out.print(A);
            System.out.print(": ");
            System.out.println(new Nesting().solution(A));
        }
    }
}
