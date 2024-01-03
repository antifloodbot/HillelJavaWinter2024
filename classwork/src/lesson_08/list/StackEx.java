package lesson_08.list;

import java.util.Stack;

public class StackEx { // LIFO
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>(); // create

        stack.add("One"); //add
        stack.add("Two"); //add
        stack.add(0, "Three");   //add

        System.out.println(stack);

        // [ stack -> element]
        System.out.println(stack.peek()); // look
        System.out.println(stack);
        String i = stack.pop();
        System.out.println(i);  // look + take
        System.out.println(stack);
//
        //  [element -> stack]
        stack.push("Four"); // add to top of stack add return element
        stack.add("Five");       // return true/false
        stack.push("Seven");
        System.out.println(stack);
        System.out.println(stack.peek());
    }
}
