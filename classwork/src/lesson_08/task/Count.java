package lesson_08.task;

import java.util.Stack;

public class Count {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.peek();
                if ((top == '(' && c == ')') || (top == '[' && c == ']') || (top == '{' && c == '}')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "()[]{}()()[]{}";
        if (isValid(str)) {
            System.out.println("Расстановка скобок в строке правильная.");
        } else {
            System.out.println("Расстановка скобок в строке неправильная.");
        }
    }
}
