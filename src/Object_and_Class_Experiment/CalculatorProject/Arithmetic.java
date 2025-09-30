package Object_and_Class_Experiment.CalculatorProject;

import java.util.Stack;

public class Arithmetic {
    private String expr;

    // 构造方法
    public Arithmetic(String expr) {
        this.expr = expr;
    }

    public String getExpr() {
        return expr;
    }

    public void setExpr(String expr) {
        this.expr = expr;
    }

    public int getResult() {
        return evaluateExpression(expr);
    }

    private int evaluateExpression(String expression) {
        Stack<Integer> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            if (token.length() == 0) {
                continue;
            } else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
                while (!operatorStack.isEmpty() &&
                        (operatorStack.peek() == '+' || operatorStack.peek() == '-' ||
                                operatorStack.peek() == '*' || operatorStack.peek() == '/')) {
                    processAnOperator(operandStack, operatorStack);
                }
                operatorStack.push(token.charAt(0));
            } else if (token.charAt(0) == '*' || token.charAt(0) == '/') {
                while (!operatorStack.isEmpty() &&
                        (operatorStack.peek() == '*' || operatorStack.peek() == '/')) {
                    processAnOperator(operandStack, operatorStack);
                }
                operatorStack.push(token.charAt(0));
            } else if (token.charAt(0) == '(') {
                operatorStack.push('(');
            } else if (token.charAt(0) == ')') {
                while (operatorStack.peek() != '(') {
                    processAnOperator(operandStack, operatorStack);
                }
                operatorStack.pop(); // 弹出左括号
            } else {
                operandStack.push(Integer.parseInt(token));
            }
        }

        while (!operatorStack.isEmpty()) {
            processAnOperator(operandStack, operatorStack);
        }

        return operandStack.pop();
    }

    private void processAnOperator(Stack<Integer> operandStack, Stack<Character> operatorStack) {
        char op = operatorStack.pop();
        int op2 = operandStack.pop();
        int op1 = operandStack.pop();

        switch (op) {
            case '+':
                operandStack.push(op1 + op2);
                break;
            case '-':
                operandStack.push(op1 - op2);
                break;
            case '*':
                operandStack.push(op1 * op2);
                break;
            case '/':
                operandStack.push(op1 / op2); // 整数除法
                break;
        }
    }
}
