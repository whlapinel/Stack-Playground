/*
Assignment 4a - Stacks

INSTRUCTIONS:

Use repl.it to create a program that simulates the checking to see if a string  of parentheses is balance.

A string containing only parentheses is balanced if the following is true:
1. if it is an empty string
2. if it is not empty but has no parentheses eg. A,  B , AB is balanced
3. if every closing parentheses eg.  ), }, ] is preceded by its corresponding opening parentheses (,{,[
  eg.  (A) and {A} and [A], {}(), [{(C)}], ({(F)}) are all balanced
Examples of some unbalanced strings are: "{}(", "({)}", "[[", "}{" etc.
Given a string, determine if it is balanced or not.
In your main implement a boolean returning method called  isBalanced  that takes a string and determines whether it is balanced or not.
When you are finished submit the link to your repl.it
Note:
You are not required to implement any methods in the Stack class. You can use the Stack implementation in  java,util.
Here is a referenceLinks to an external site. that would help.*/

import java.util.*;

public class BalancedString {

    static boolean isBalanced(String expr) {

        Deque<Character> stack = new ArrayDeque<Character>();

        for (int i = 0; i < expr.length(); i++) {
            char x = expr.charAt(i);
            if (x == '(' || x == '[' || x == '{') {
                stack.push(x);
                continue;
            }

            //if you hit a close paren before you hit an open paren, you're NOT balanced
            if (stack.isEmpty() && (x == ')' || x == ']' || x == '}')) {
                return false;
            }

            char check;

            //check (last open-paren added) should be the opposite of 'x' when 'x' is a close-paren. else, unbalanced

            switch (x) {
                case ')':
                    check = stack.pop();
                    if (check == '{' || check == '[') {
                        return false;
                    }
                    break;

                case '}':
                    check = stack.pop();
                    if (check == '(' || check == '[') {
                        return false;
                    }
                    break;

                case ']':
                    check = stack.pop();
                    if (check == '(' || check == '{') {
                        return false;
                    }
                    break;
            }
        }

        // if stack is empty, string is balanced
        return (stack.isEmpty());
    }

    // Driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("(Type EXIT to end program).\n" +
                    "Enter string to check for balance or \"well-formedness\":");
            String expr = sc.nextLine();
            if (expr.equals("EXIT")) {
                run = false;
                continue;
            }

            if (isBalanced(expr))
                System.out.println("Your string is balanced.");
            else
                System.out.println("Your string is NOT balanced.");
        }
    }
}
