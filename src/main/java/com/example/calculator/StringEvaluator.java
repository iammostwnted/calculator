package com.example.calculator;

import java.util.Stack;

public class StringEvaluator {

    int evaluate(String expr) {
       // System.out.println("Processing string - " + expr);
        char[] tokens = expr.toCharArray();

        Stack<Integer> numbers = new Stack<Integer>();

        Stack<Character> operator = new Stack<Character>();

        for (int i = 0; i < tokens.length; i++) {
            // skip whitespace
            if (tokens[i] == ' ')
                continue;

            // push number to numbers stack
            if (tokens[i] >= '0' && tokens[i] <= '9') {
                StringBuffer sbuf = new StringBuffer();
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') {
                    sbuf.append(tokens[i++]);
                }
                i--;
                numbers.push(Integer.parseInt(sbuf.toString()));
            } else if (tokens[i] == '(') {
                operator.push(tokens[i]);
            } else if (tokens[i] == ')') {
                while (operator.peek() != '(')
                    numbers.push(performOperation(operator.pop(), numbers.pop(), numbers.pop()));
                operator.pop();
            } else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {

                while (!operator.empty() && hasPrecedence(tokens[i], operator.peek())) {
                    numbers.push(performOperation(operator.pop(), numbers.pop(), numbers.pop()));
                }
                // Push current token to 'ops'.
                operator.push(tokens[i]);
            }
        }
        // Entire expression has been parsed at this point, apply remaining
        // ops to remaining values
        while (!operator.empty())
            numbers.push(performOperation(operator.pop(), numbers.pop(), numbers.pop()));

        
        return numbers.pop();

    }

    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    public int performOperation(char op, int b, int a) {
        switch (op) {
        case '+':
            return a + b;
        case '-':
            return a - b;
        case '*':
            return a * b;
        case '/':
            if (b == 0)
                throw new UnsupportedOperationException("Cannot divide by zero");
            return a / b;
        }
        return 0;
    }
}
