package com.greatlearning.lab3;

import java.util.Scanner;
import java.util.Stack;

public class BalancingBrackets {

    public static boolean isBalanced(String brackets) {

        Stack<Character> bracketStack = new Stack<>();

        for (int i = 0; i < brackets.length(); i++) {
            char ch = brackets.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                bracketStack.push(ch);
                continue;
            }

            if (bracketStack.isEmpty())
                return false;

            if (ch == ')' || ch == '}' || ch == ']') {
                char top = bracketStack.pop();

                switch (ch) {
                    case ')':
                        if (top != '(')
                            return false;
                        break;
                    case '}':
                        if (top != '{')
                            return false;
                        break;
                    case ']':
                        if (top != '[')
                            return false;
                        break;
                    default:
                        break;
                }
            }

        }

        return (bracketStack.isEmpty());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string of barckets:");
        String brackets = sc.next();

        System.out.println(
                "The entered string " + (isBalanced(brackets) ? "has" : "does not contain") + " Balanced Brackets");

        sc.close();
    }
}
