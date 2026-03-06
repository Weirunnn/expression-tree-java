import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Stack;

/*
 *  Note: the indentation and placment of {'s and }'s is somewhat
 * of a mess in this file.  That is on purpose to give you (the student)
 * a chance to see what it's like working in code that has arbitrary
 * and inconsistent style.  I encourage you to clean it up for your 
 * submission (and sanity!).
 * 
 * /

/**
 * A class representing an abstract arithmetic expression
 */
public abstract class Expression {
    /**
     * Creates a tree from an expression in postfix notation
     * 
     * @param postfix an array of Strings representing a postfix arithmetic
     *                expression
     * @return a new Expression that represents postfix
     */
    public static Expression expressionFromPostfix(String[] postfix) {
        ////// REPLACE WITH YOUR CODE
        Stack<Expression> stack = new Stack<Expression>();

        for (String token : postfix) {
            if (token.matches("-?\\d+")) {
                stack.push(new IntegerOperand(Integer.parseInt(token)));
            } else if (token.matches("[a-zA-Z]+")) {
                stack.push(new VariableOperand(token));
            } else {
                if (stack.size() < 2) {
                    throw new IllegalStateException("Invalid postfix expression");
                }
                Expression right = stack.pop();
                Expression left = stack.pop();

                switch (token) {
                    case "+":
                        stack.push(new SumExpression(left, right));
                        break;
                    case "-":
                        stack.push(new DifferenceExpression(left, right));
                        break;
                    case "*":
                        stack.push(new ProductExpression(left, right));
                        break;
                    case "/":
                        stack.push(new QuotientExpression(left, right));
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operation: " + token);
                }
            }
        }

        return stack.pop();
    }

    /**
     * @return a String that represents this expression in prefix notation.
     */
    public abstract String toPrefix();

    /**
     * @return a String that represents this expression in infix notation.
     */
    public abstract String toInfix();

    /**
     * @return a String that represents this expression in postfix notation.
     */
    public abstract String toPostfix();

    /**
     * @return a String that represents the expression in infix notation
     */
    @Override
    public String toString() {
        return toInfix();
    }

    /**
     * @return a new Expression mathematically equivalent to this one, but
     *         simplified.
     */
    public abstract Expression simplify();

    /**
     * Evaluates the expression given assignments of values to variables.
     * 
     * @param assignments a HashMap from Strings (variable names) to Integers
     *                    (values).
     * @return the result of evaluating the expression with the given variable
     *         assignments
     */
    public abstract int evaluate(HashMap<String, Integer> assignments);

    /**
     * @return a Set of the variables contained in this expression
     */
    public abstract Set<String> getVariables();

    @Override
    public abstract boolean equals(Object obj);

    /**
     * Prints the expression as a tree in DOT format for visualization
     * 
     * @param filename the name of the output file
     */
    public void drawExpression(String filename) throws IOException {
        BufferedWriter bw = null;
        FileWriter fw = new FileWriter(filename);
        bw = new BufferedWriter(fw);

        bw.write("graph Expression {\n");

        drawExprHelper(bw);

        bw.write("}\n");

        bw.close();
        fw.close();
    }

    /**
     * Recursively prints the vertices and edges of the expression tree for
     * visualization
     * 
     * @param bw the BufferedWriter to write to
     */
    protected abstract void drawExprHelper(BufferedWriter bw) throws IOException;
}

/**
 * A class representing an abstract operand
 */
abstract class Operand extends Expression {
}

/**
 * A class representing an expression containing only a single integer value
 */
class IntegerOperand extends Operand {
    protected int operand;

    /**
     * Create the expression
     * 
     * @param operand the integer value this expression represents
     */
    public IntegerOperand(int operand) {
        this.operand = operand;
    }

    /**
     * @return a String that represents this expression in prefix notation.
     */
    public String toPrefix() {
        /////// REPLACE WITH YOUR CODE
        return String.valueOf(operand);
    }

    /**
     * @return a String that represents this expression in postfix notation.
     */
    public String toPostfix() {
        /////// REPLACE WITH YOUR CODE
        return String.valueOf(operand);    }

    /**
     * @return a String that represents the expression in infix notation
     */
    public String toInfix() {
        ////// REPLACE WITH YOUR CODE
        return String.valueOf(operand);
    }

    /**
     * @return a new Expression mathematically equivalent to this one, but
     *         simplified.
     */
    public Expression simplify() {
        ////// REPLACE WITH YOUR CODE
        return new VariableOperand("not_yet_implemented");
    }

    /**
     * Evaluates the expression given assignments of values to variables.
     * 
     * @param assignments a HashMap from Strings (variable names) to Integers
     *                    (values).
     * @return the result of evaluating the expression with the given variable
     *         assignments
     */
    public int evaluate(HashMap<String, Integer> assignments) {
        ////// REPLACE WITH YOUR CODE
        return operand;  
    }

    /**
     * @return a Set of the variables contained in this expression
     */
    public Set<String> getVariables() {
        ////// REPLACE WITH YOUR CODE
        return new TreeSet<>();
    }

    /**
     * @param obj and Object to compare to
     * @return true if obj is a logically equivalent Expression
     */
    @Override
    public boolean equals(Object obj) {
        ///// REPLACE WITH YOUR CODE
        if (this == obj) return true; 
        if (obj == null || getClass() != obj.getClass()) return false;
        IntegerOperand other = (IntegerOperand) obj;
        return this.operand == other.operand; 
    }

    /**
     * Recursively prints the vertices and edges of the expression tree for
     * visualization
     * 
     * @param bw the BufferedWriter to write to
     */
    protected void drawExprHelper(BufferedWriter bw) throws IOException {
        bw.write("\tnode" + hashCode() + "[label=" + operand + "];\n");
    }
}

/**
 * A class representing an expression containing only a single variable
 */
class VariableOperand extends Operand {
    protected String variable;

    /**
     * Create the expression
     * 
     * @param variable the variable name contained with this expression
     */
    public VariableOperand(String variable) {
        this.variable = variable;
    }

    /**
     * @return a String that represents this expression in prefix notation.
     */
    public String toPrefix() {
        /////// REPLACE WITH YOUR CODE
        return variable;
    }

    /**
     * @return a String that represents this expression in postfix notation.
     */
    public String toPostfix() {
        /////// REPLACE WITH YOUR CODE
        return variable;
    }

    /**
     * @return a String that represents the expression in infix notation
     */
    public String toInfix() {
        ////// REPLACE WITH YOUR CODE
        return variable;
    }

    /**
     * @return a new Expression mathematically equivalent to this one, but
     *         simplified.
     */
    public Expression simplify() {
        ////// REPLACE WITH YOUR CODE
        return new VariableOperand("not_yet_implemented");
    }

    /**
     * Evaluates the expression given assignments of values to variables.
     * 
     * @param assignments a HashMap from Strings (variable names) to Integers
     *                    (values).
     * @return the result of evaluating the expression with the given variable
     *         assignments
     */
    public int evaluate(HashMap<String, Integer> assignments) {
        ////// REPLACE WITH YOUR CODE
        if (assignments.containsKey(variable)) {
            return assignments.get(variable);
        } else {
            throw new IllegalArgumentException("Variable " + variable + " not assigned.");
        }
    }

    /**
     * @return a Set of the variables contained in this expression
     */
    public Set<String> getVariables() {
        ////// REPLACE WITH YOUR CODE
        Set<String> vars = new TreeSet<>();
        vars.add(variable); 
        return vars;
    }

    /**
     * @param obj and Object to compare to
     * @return true if obj is a logically equivalent Expression
     */
    @Override
    public boolean equals(Object obj) {
        ///// REPLACE WITH YOUR CODE
        if (this == obj) return true; 
        if (obj == null || getClass() != obj.getClass()) return false; 
        VariableOperand other = (VariableOperand) obj;
        return this.variable.equals(other.variable); 
    }

    /**
     * Recursively prints the vertices and edges of the expression tree for
     * visualization
     * 
     * @param bw the BufferedWriter to write to
     */
    protected void drawExprHelper(BufferedWriter bw) throws IOException {
        bw.write("\tnode" + hashCode() + "[label=" + variable + "];\n");
    }
}

/**
 * A class representing an expression involving an operator
 */
abstract class OperatorExpression extends Expression {
    protected Expression left;
    protected Expression right;

    /**
     * Create the expression
     
     * @param left  the expression representing the left operand
     * @param right the expression representing the right operand
     */
    public OperatorExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * @return a string representing the operator
     */
    protected abstract String getOperator();

    /**
     * Recursively prints the vertices and edges of the expression tree for
     * visualization
     * 
     * @param bw the BufferedWriter to write to
     */
    protected void drawExprHelper(BufferedWriter bw) throws IOException {
        String rootID = "\tnode" + hashCode();
        bw.write(rootID + "[label=\"" + getOperator() + "\"];\n");

        bw.write(rootID + " -- node" + left.hashCode() + ";\n");
        bw.write(rootID + " -- node" + right.hashCode() + ";\n");
        left.drawExprHelper(bw);
        right.drawExprHelper(bw);
    }
}

/**
 * A class representing an expression involving an sum
 */
class SumExpression extends OperatorExpression {
    /**
     * Create the expression
     * 
     * @param left  the expression representing the left operand
     * @param right the expression representing the right operand
     */
    public SumExpression(Expression left, Expression right) {
        super(left, right);
    }

    /**
     * @return a string representing the operand
     */
    protected String getOperator() {
        return "+";
    }

    /**
     * @return a String that represents this expression in prefix notation.
     */
    public String toPrefix() {
        /////// REPLACE WITH YOUR CODE
        return getOperator() + " " + left.toPrefix() + " " + right.toPrefix();
    }

    /**
     * @return a String that represents this expression in postfix notation.
     */
    public String toPostfix() {
        /////// REPLACE WITH YOUR CODE
        return left.toPostfix() + " " + right.toPostfix() + " " + getOperator();
    }

    /**
     * @return a String that represents the expression in infix notation
     */
    public String toInfix() {
        ////// REPLACE WITH YOUR CODE
        return "(" + left.toInfix() + " " + getOperator() + " " + right.toInfix() + ")";
    }

    /**
     * @return a new Expression mathematically equivalent to this one, but
     *         simplified.
     */
    public Expression simplify() {
        ////// REPLACE WITH YOUR CODE
        return new VariableOperand("not_yet_implemented");
    }

    /**
     * Evaluates the expression given assignments of values to variables.
     * 
     * @param assignments a HashMap from Strings (variable names) to Integers
     *                    (values).
     * @return the result of evaluating the expression with the given variable
     *         assignments
     */
    public int evaluate(HashMap<String, Integer> assignments) {
        ////// REPLACE WITH YOUR CODE
        int leftVal = left.evaluate(assignments);
        int rightVal = right.evaluate(assignments);
        return leftVal + rightVal; 
    }

    /**
     * @return a Set of the variables contained in this expression
     */
    public Set<String> getVariables() {
        ////// REPLACE WITH YOUR CODE
        Set<String> vars = new TreeSet<>(left.getVariables());
        vars.addAll(right.getVariables()); 
        return vars;
    }

    /**
     * @param obj and Object to compare to
     * @return true if obj is a logically equivalent Expression
     */
    @Override
    public boolean equals(Object obj) {
        ///// REPLACE WITH YOUR CODE
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SumExpression other = (SumExpression) obj;
        return (left.equals(other.left) && right.equals(other.right)) || 
               (left.equals(other.right) && right.equals(other.left));
    }
}

/**
 * A class representing an expression involving an differnce
 */
class DifferenceExpression extends OperatorExpression {
    /**
     * Create the expression
     * 
     * @param left  the expression representing the left operand
     * @param right the expression representing the right operand
     */
    public DifferenceExpression(Expression left, Expression right) {
        super(left, right);
    }

    /**
     * @return a string representing the operand
     */
    protected String getOperator() {
        return "-";
    }

    /**
     * @return a String that represents this expression in prefix notation.
     */
    public String toPrefix() {
        /////// REPLACE WITH YOUR CODE
        return getOperator() + " " + left.toPrefix() + " " + right.toPrefix();
    }

    /**
     * @return a String that represents this expression in postfix notation.
     */
    public String toPostfix() {
        /////// REPLACE WITH YOUR CODE
        return left.toPostfix() + " " + right.toPostfix() + " " + getOperator();
    }

    /**
     * @return a String that represents the expression in infix notation
     */
    public String toInfix() {
        ////// REPLACE WITH YOUR CODE
        return "(" + left.toInfix() + " " + getOperator() + " " + right.toInfix() + ")";
    }

    /**
     * @return a new Expression mathematically equivalent to this one, but
     *         simplified.
     */
    public Expression simplify() {
        ////// REPLACE WITH YOUR CODE
        return new VariableOperand("not_yet_implemented");
    }

    /**
     * Evaluates the expression given assignments of values to variables.
     * 
     * @param assignments a HashMap from Strings (variable names) to Integers
     *                    (values).
     * @return the result of evaluating the expression with the given variable
     *         assignments
     */
    public int evaluate(HashMap<String, Integer> assignments) {
        ////// REPLACE WITH YOUR CODE
        int leftVal = left.evaluate(assignments);
        int rightVal = right.evaluate(assignments);
        return leftVal - rightVal;
    }

    /**
     * @return a Set of the variables contained in this expression
     */
    public Set<String> getVariables() {
        ////// REPLACE WITH YOUR CODE
        Set<String> vars = new TreeSet<>(left.getVariables());
        vars.addAll(right.getVariables()); 
        return vars;
    }

    /**
     * @param obj and Object to compare to
     * @return true if obj is a logically equivalent Expression
     */
    @Override
    public boolean equals(Object obj) {
        ///// REPLACE WITH YOUR CODE
        if (this == obj) return true; 
        if (obj == null || getClass() != obj.getClass()) return false; 
    
        DifferenceExpression other = (DifferenceExpression) obj; 
        return left.equals(other.left) && right.equals(other.right); 
    }
}

/**
 * A class representing an expression involving a product
 */
class ProductExpression extends OperatorExpression {
    /**
     * Create the expression
     * 
     * @param left  the expression representing the left operand
     * @param right the expression representing the right operand
     */
    public ProductExpression(Expression left, Expression right) {
        super(left, right);
    }

    /**
     * @return a string representing the operand
     */
    protected String getOperator() {
        return "*";
    }

    /**
     * @return a String that represents this expression in prefix notation.
     */
    public String toPrefix() {
        /////// REPLACE WITH YOUR CODE
        return getOperator() + " " + left.toPrefix() + " " + right.toPrefix();
    }

    /**
     * @return a String that represents this expression in postfix notation.
     */
    public String toPostfix() {
        /////// REPLACE WITH YOUR CODE
        return left.toPostfix() + " " + right.toPostfix() + " " + getOperator();
    }

    /**
     * @return a String that represents the expression in infix notation
     */
    public String toInfix() {
        ////// REPLACE WITH YOUR CODE
        return "(" + left.toInfix() + " " + getOperator() + " " + right.toInfix() + ")";
    }

    /**
     * @return a new Expression mathematically equivalent to this one, but
     *         simplified.
     */
    public Expression simplify() {
        ////// REPLACE WITH YOUR CODE
        return new VariableOperand("not_yet_implemented");
    }

    /**
     * Evaluates the expression given assignments of values to variables.
     * 
     * @param assignments a HashMap from Strings (variable names) to Integers
     *                    (values).
     * @return the result of evaluating the expression with the given variable
     *         assignments
     */
    public int evaluate(HashMap<String, Integer> assignments) {
        ////// REPLACE WITH YOUR CODE
        int leftVal = left.evaluate(assignments);
        int rightVal = right.evaluate(assignments);
        return leftVal * rightVal;
    }

    /**
     * @return a Set of the variables contained in this expression
     */
    public Set<String> getVariables() {
        ////// REPLACE WITH YOUR CODE
        Set<String> vars = new TreeSet<>(left.getVariables());
        vars.addAll(right.getVariables()); 
        return vars;
    }

    /**
     * @param obj and Object to compare to
     * @return true if obj is a logically equivalent Expression
     */
    @Override
    public boolean equals(Object obj) {
        ///// REPLACE WITH YOUR CODE
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ProductExpression other = (ProductExpression) obj;
        return (left.equals(other.left) && right.equals(other.right)) ||
               (left.equals(other.right) && right.equals(other.left));
    }
}

/**
 * A class representing an expression involving a division
 */
class QuotientExpression extends OperatorExpression {
    /**
     * Create the expression
     * 
     * @param left  the expression representing the left operand
     * @param right the expression representing the right operand
     */
    public QuotientExpression(Expression left, Expression right) {
        super(left, right);
    }

    /**
     * @return a string representing the operand
     */
    protected String getOperator() {
        return "/";
    }

    /**
     * @return a String that represents this expression in prefix notation.
     */
    public String toPrefix() {
        /////// REPLACE WITH YOUR CODE
        return getOperator() + " " + left.toPrefix() + " " + right.toPrefix();
    }

    /**
     * @return a String that represents this expression in postfix notation.
     */
    public String toPostfix() {
        /////// REPLACE WITH YOUR CODE
        return left.toPostfix() + " " + right.toPostfix() + " " + getOperator();
    }

    /**
     * @return a String that represents the expression in infix notation
     */
    public String toInfix() {
        ////// REPLACE WITH YOUR CODE
        return "(" + left.toInfix() + " " + getOperator() + " " + right.toInfix() + ")";
    }

    /**
     * @return a new Expression mathematically equivalent to this one, but
     *         simplified.
     */
    public Expression simplify() {
        ////// REPLACE WITH YOUR CODE
        return new VariableOperand("not_yet_implemented");
    }

    /**
     * Evaluates the expression given assignments of values to variables.
     * 
     * @param assignments a HashMap from Strings (variable names) to Integers
     *                    (values).
     * @return the numerica result of evaluating the expression with the given
     *         variable assignments
     */
    public int evaluate(HashMap<String, Integer> assignments) {
        ////// REPLACE WITH YOUR CODE
        int leftVal = left.evaluate(assignments);
        int rightVal = right.evaluate(assignments);
        if (rightVal == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return leftVal / rightVal;
    }

    /**
     * @return a Set of the variables contained in this expression
     */
    public Set<String> getVariables() {
        ////// REPLACE WITH YOUR CODE
        Set<String> vars = new TreeSet<>(left.getVariables());
        vars.addAll(right.getVariables()); 
        return vars;
    }

    /**
     * @param obj and Object to compare to
     * @return true if obj is a logically equivalent Expression
     */
    @Override
    public boolean equals(Object obj) {
        ///// REPLACE WITH YOUR CODE
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        QuotientExpression other = (QuotientExpression) obj;
        return left.equals(other.left) && right.equals(other.right); 

    }
}
