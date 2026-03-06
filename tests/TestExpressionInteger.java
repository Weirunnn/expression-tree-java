
import org.junit.*;
import static org.junit.Assert.*;

import java.util.HashMap;

public class TestExpressionInteger {
    //----single-item integer expressions----
    public final String str1 = "0";
    public final String str2 = "14";
    public final String str3 = "-2";
    public final HashMap<String,Integer> dummyMap = new HashMap<String,Integer>();
    //---can you make an expression---
    @Test
    public void makePostExpression_singleInteger(){
        try{
            Expression exp1 = Expression.expressionFromPostfix(str1.split(" "));
            assertNotNull("Failed to make a single integer expression. 'expressionFromPostfix()' is not functional. (most following tests will fail) (expect null pointer excpetions) ",exp1);
        } catch(Exception e){
            System.out.println("Error creating expressions with expressionFromPostfix");
        }
    }
    public Expression makeExp1(){
        Expression exp1 = Expression.expressionFromPostfix(str1.split(" "));
        return exp1;
    }
    public Expression makeExp2(){
        Expression exp2 = Expression.expressionFromPostfix(str2.split(" "));
        return exp2;
    }
    public Expression makeExp3(){
        Expression exp3 = Expression.expressionFromPostfix(str3.split(" "));
        return exp3;
    }
    //---toPostFix()---
    @Test
    public void toPostFix1_singleItem(){
        Expression exp = makeExp1();
        assertEquals(str1,exp.toPostfix());
    }
    @Test
    public void toPostFix2_singleItem(){
        Expression exp = makeExp2();
        assertEquals(str2,exp.toPostfix());
    }
    @Test
    public void toPostFix3_singleItem(){
        Expression exp = makeExp3();
        assertEquals(str3,exp.toPostfix());
    }
    //---toPreFix()---
    @Test
    public void toPrefix1_singleItem(){
        Expression exp = makeExp1();
        assertEquals(str1,exp.toPrefix());
    }
    @Test
    public void toPrefix2_singleItem(){
        Expression exp = makeExp2();
        assertEquals(str2,exp.toPrefix());
    }
    @Test
    public void toPrefix3_singleItem(){
        Expression exp = makeExp3();
        assertEquals(str3,exp.toPrefix());
    }
    //---toInfix()---
    @Test
    public void toInfix1_singleItem(){
        Expression exp = makeExp1();
        assertEquals(str1,exp.toInfix());
    }
    @Test
    public void toInfix2_singleItem(){
        Expression exp = makeExp2();
        assertEquals(str2,exp.toInfix());
    }
    @Test
    public void toInfix3_singleItem(){
        Expression exp = makeExp3();
        assertEquals(str3,exp.toInfix());
    }
    //---variables---
    @Test
    public void getVariables1_singleItem(){
        Expression exp = makeExp1();
        assertEquals(0,exp.getVariables().size());
    }
    @Test
    public void getVariables2_singleItem(){
        Expression exp = makeExp2();
        assertEquals(0,exp.getVariables().size());
    }
    @Test
    public void getVariables3_singleItem(){
        Expression exp = makeExp3();
        assertEquals(0,exp.getVariables().size());
    }
    //---evaluate()---
    @Test
    public void evaluate1_singleItem(){
        Expression exp = makeExp1();
        assertEquals(0,exp.evaluate(dummyMap));
    }
    @Test
    public void evaluate2_singleItem(){
        Expression exp = makeExp2();
        assertEquals(14,exp.evaluate(dummyMap));
    }
    @Test
    public void evaluate3_singleItem(){
        Expression exp = makeExp3();
        assertEquals(-2,exp.evaluate(dummyMap));
    }
    //---equals()---
    @Test
    public void equals_compareToSelf(){
        Expression exp = makeExp1();
        Expression exp2 = makeExp1();
        assertTrue(exp.equals(exp2));
    }
    @Test
    public void equals_2IntegerOperands(){
        Expression exp1 = makeExp1();
        Expression exp2 = makeExp2();
        assertFalse(exp1.equals(exp2));
    }
    @Test
    public void equals_IntegerOperandToString(){
        Expression exp = makeExp1();
        assertFalse(exp.equals("0"));
    }
    @Test
    public void equals_IntegerOperandToInt(){
        Expression exp = makeExp1();
        assertFalse(exp.equals(0));
    }
    //---simplify()---
    @Test
    public void simplify_singleItem(){
        Expression exp = makeExp1();
        Expression simple = exp.simplify();
        assertEquals(exp,simple);
    }    
}
