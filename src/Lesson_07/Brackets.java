package Lesson_07;

import java.util.*;

public class Brackets {

    public int solution(String S) {
        Stack<Character> stack = new Stack<>();
        char[] str = S.toCharArray();
        Character d;
        for (char c : str) {
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.empty() || stack.pop() != '(') {
                        return 0;
                    }
                    break;
                case '}':
                    if (stack.empty() || stack.pop() != '{') {
                        return 0;
                    }
                    break;
                case ']':
                    if (stack.empty() || stack.pop() != '[') {
                        return 0;
                    }
                    break;
                default:
                    break;
            }
        }
        return stack.empty() ? 1 : 0;
    }

    public static void Test() {
        ArrayList<String> a = new ArrayList<>();
        a.add("}()[]");
        a.add("{}()[]");
        a.add("{(})[]");
        for (String A : a) {
            System.out.print(A);
            System.out.print(": ");
            System.out.println(new Brackets().solution(A));
        }
    }
}
