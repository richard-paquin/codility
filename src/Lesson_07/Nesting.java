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
}
