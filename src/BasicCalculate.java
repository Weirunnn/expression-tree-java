
import java.util.Arrays;


public class BasicCalculate {
   public static void main(String[] args) {

    String[] test1input = {"x", "4", "+"};
    Expression test1result = Expression.expressionFromPostfix(test1input);
    System.out.println("Input: " + Arrays.toString(test1input));
    System.out.println("Prefix: "  + test1result.toPrefix());
    System.out.println("Infix: "  + test1result.toInfix());
    System.out.println("Postfix: "  + test1result.toPostfix());

   }
}