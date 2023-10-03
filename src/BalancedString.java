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

        // Check Empty Stack
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
