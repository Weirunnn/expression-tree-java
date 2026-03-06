# Expression Tree (Java)

This project implements an arithmetic expression tree in Java.

The program builds a binary tree from a postfix expression and supports
multiple operations such as traversal, evaluation, simplification, and
variable detection.

## Features

- Build expression trees from postfix notation
- Convert expressions to prefix, infix, and postfix formats
- Evaluate expressions with variable values
- Simplify expressions using algebraic rules
- Detect variables used in expressions
- Compare expressions with commutativity for + and *

## Example

Postfix expression:

y 4 x 0 * + *

Tree representation:

        *
       / \
      y   +
         / \
        4   *
           / \
          x   0

## Project Structure

src/ – Java source code  
tests/ – assignment test files  
docs/ – assignment description  

## Author

Weiran Zeng
