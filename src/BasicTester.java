import java.io.IOException;

class BasicTester{
	public static void main(String[] args){

		Expression e1 = Expression.expressionFromInfix(new String[] {"y", "*", "(", "3", "+", "4", ")"});
		Expression e2 = Expression.expressionFromInfix(new String[] {"y", "*", "7"});


		System.out.println("e1: " + e1 + "   e2: " + e2);
		System.out.println("e1 == e2: " + e1.equals(e2));
		System.out.println("e2.toPostfix(): " + e2.toPostfix());

        String[] input2 = {"y", "4", "x", "0", "*", "+", "*"};

        try{
            e1.drawExpression("expr2.dot");
        } catch (IOException ioe){
            System.out.println("Could not generate expr2.dot!! :(");
        }
	}
}
