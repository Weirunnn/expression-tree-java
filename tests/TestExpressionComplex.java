import org.junit.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Set;

public class TestExpressionComplex {
    //----complex expressions----
    public final String post1 = "X Y + 3 * 4 Z / + -6 -";
	public final String post2 = "1 2 3 * 2 / +";
	public final String post3 = "18 X / 3 Z * 1 + Z 2 - * +";

    public final String pre1 = "- + * + X Y 3 / 4 Z -6";
    public final String pre2 = "+ 1 / * 2 3 2";
    public final String pre3 = "+ / 18 X * + * 3 Z 1 - Z 2";

    public final String in1 = "( ( ( ( X + Y ) * 3 ) + ( 4 / Z ) ) - -6 )";
    public final String in2 = "( 1 + ( ( 2 * 3 ) / 2 ) )";
    public final String in3 = "( ( 18 / X ) + ( ( ( 3 * Z ) + 1 ) * ( Z - 2 ) ) )";
    //---can you make an expression--
    @Test
    public void makeExpression_complex(){
        try{
            Expression exp = Expression.expressionFromPostfix(post1.split(" "));
            assertNotNull("Failed to make a complex expression. 'expressionFromPostfix()' is not functional. (most following tests will fail)  (expect null pointer excpetions) ",exp);
        }catch(Exception e){
            System.out.println("Error creating simple postfix expression");
        }
    }
    public Expression complexPostExpression1(){
        Expression exp = Expression.expressionFromPostfix(post1.split(" "));
        return exp;
    }
    public Expression complexPostExpression2(){
        Expression exp = Expression.expressionFromPostfix(post2.split(" "));
        return exp;
    }
    public Expression complexPostExpression3(){
        Expression exp = Expression.expressionFromPostfix(post3.split(" "));
        return exp;
    }
    //---toPostfix()---
    @Test
    public void complex_toPostfix1(){
        Expression exp = complexPostExpression1();
        assertEquals("'"+exp+"': ",post1.replaceAll("\\s+",""),exp.toPostfix().replaceAll("\\s+",""));
    }
    @Test
    public void complex_toPostfix2(){
        Expression exp = complexPostExpression2();
        assertEquals("'"+exp+"': ",post2.replaceAll("\\s+",""),exp.toPostfix().replaceAll("\\s+",""));
    }
    @Test
    public void complex_toPostfix3(){
        Expression exp = complexPostExpression3();
        assertEquals("'"+exp+"': ",post3.replaceAll("\\s+",""),exp.toPostfix().replaceAll("\\s+",""));
    }
    //---toPrefix()---
    @Test
    public void complex_toPrefix1(){
        Expression exp = complexPostExpression1();
        assertEquals("'"+exp+"': ",pre1.replaceAll("\\s+",""),exp.toPrefix().replaceAll("\\s+",""));
    }
    @Test
    public void complex_toPrefix2(){
        Expression exp = complexPostExpression2();
        assertEquals("'"+exp+"': ",pre2.replaceAll("\\s+",""),exp.toPrefix().replaceAll("\\s+",""));
    }
    @Test
    public void complex_toPrefix3(){
        Expression exp = complexPostExpression3();
        assertEquals("'"+exp+"': ",pre3.replaceAll("\\s+",""),exp.toPrefix().replaceAll("\\s+",""));
    }
    //---toInfix()---
    @Test
    public void complex_toInfix1(){
        Expression exp = complexPostExpression1();
        assertEquals("'"+exp+"': ",in1.replaceAll("\\s+",""),exp.toInfix().replaceAll("\\s+",""));
    }
    @Test
    public void complex_toInfix2(){
        Expression exp = complexPostExpression2();
        assertEquals("'"+exp+"': ",in2.replaceAll("\\s+",""),exp.toInfix().replaceAll("\\s+",""));
    }
    @Test
    public void complex_toInfix3(){
        Expression exp = complexPostExpression3();
        assertEquals("'"+exp+"': ",in3.replaceAll("\\s+",""),exp.toInfix().replaceAll("\\s+",""));
    }
    //---variables---
    @Test
    public void getVariables_complex1(){
        Expression exp = complexPostExpression1();
        assertEquals("3 variables present ",3,exp.getVariables().size());
    }
    @Test
    public void checkVariables_complex1(){
        Expression exp = complexPostExpression1();
        Set<String> vars = exp.getVariables();
        assertTrue("X should be present in set ",vars.contains("X"));
        assertTrue("Y should be present in set ",vars.contains("Y"));
        assertTrue("Z should be present in set ",vars.contains("Z"));
    }
    @Test
    public void getVariables_complex2(){
        Expression exp = complexPostExpression2();
        assertEquals("No variables present in 2nd example expression ",0,exp.getVariables().size());
    }
    @Test
    public void checkVariables_complex2(){
        Expression exp = complexPostExpression2();
        Set<String> vars = exp.getVariables();
        assertFalse("X shouldn't be present in set ",vars.contains("X"));
        assertFalse("Y shouldn't be present in set ",vars.contains("Y"));
        assertFalse("Z shouldn't be present in set ",vars.contains("Z"));
    }
    @Test
    public void getVariables_complex3(){
        Expression exp = complexPostExpression3();
        assertEquals(2,exp.getVariables().size());
    }
    @Test
    public void checkVariables_complex3(){
        Expression exp = complexPostExpression3();
        Set<String> vars = exp.getVariables();
        assertTrue("X should be present in set ",vars.contains("X"));
        assertFalse("Y shouldn't be present in set ",vars.contains("Y"));
        assertTrue("Z should be present in set ",vars.contains("Z"));
    }
    //---evaluate()---
    public HashMap<String,Integer> makeMap1(){
        HashMap<String,Integer> map = new HashMap<String, Integer>();
        map.put("X",5);
        map.put("Y",-3);
        map.put("Z",2);
        return map;
    }
    public HashMap<String,Integer> makeMap2(){
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        map.put("X",3);
        map.put("Y",1);
        map.put("Z",5);
        return map;
    }
    @Test
    public void evaluate_complex1_map1(){
        Expression exp = complexPostExpression1();
        HashMap<String,Integer> map = makeMap1();
        assertEquals("'"+exp+"': ",14,exp.evaluate(map));
    }
    @Test
    public void evaluate_complex1_map2(){
        Expression exp = complexPostExpression1();
        HashMap<String,Integer> map = makeMap2();
        assertEquals("'"+exp+"': ",18,exp.evaluate(map));
    }
    @Test
    public void evaluate_complex2_map1(){
        Expression exp = complexPostExpression2();
        HashMap<String,Integer> map = makeMap1();
        assertEquals("'"+exp+"': ",4,exp.evaluate(map));
    }
    @Test
    public void evaluate_complex2_map2(){
        Expression exp = complexPostExpression2();
        HashMap<String,Integer> map = makeMap2();
        assertEquals("'"+exp+"': ",4,exp.evaluate(map));
    }
    @Test
    public void evaluate_complex3_map1(){
        Expression exp = complexPostExpression3();
        HashMap<String,Integer> map = makeMap1();
        assertEquals("'"+exp+"': ",3,exp.evaluate(map));
    }
    @Test
    public void evaluate_complex3_map2(){
        Expression exp = complexPostExpression3();
        HashMap<String,Integer> map = makeMap2();
        assertEquals("'"+exp+"': ",54,exp.evaluate(map));
    }
    //---equals()---
    @Test
    public void equals_compareToSelf(){
        Expression exp1 = complexPostExpression1();
        Expression exp2 = complexPostExpression1();
        assertTrue("'"+exp1+"' = '"+exp2+"'': ",exp1.equals(exp2));
    }
    @Test
    public void complexPost_stringNotExpression(){
        Expression exp = complexPostExpression1();
        assertFalse("'"+exp+"' != string '"+post1+"'': ",exp.equals(post1));
    }
    @Test
    public void complexPre_stringNotExpression(){
        Expression exp = complexPostExpression1();
        assertFalse("'"+exp+"' != string '"+pre1+"'': ",exp.equals(pre1));
    }
    @Test
    public void complexIn_stringNotExpression(){
        Expression exp = complexPostExpression1();
        assertFalse("'"+exp+"' != string '"+in1+"'': ",exp.equals(in1));
    }
    @Test
    public void equals_orderDoesntMatter1(){
        String thisPost1 = "x y * z +";
        String thisPost2 = "y x * z +";
        Expression exp1 = Expression.expressionFromPostfix(thisPost1.split(" "));
        Expression exp2 = Expression.expressionFromPostfix(thisPost2.split(" "));
        assertTrue("'"+thisPost1+"' = '"+thisPost2+"'': ",exp1.equals(exp2));
    }
    @Test
    public void equals_orderDoesntMatter2(){
        String thisPost1 = "1 2 3 * 2 / +";
        String thisPost2 = "1 3 2 * 2 / +";
        Expression exp1 = Expression.expressionFromPostfix(thisPost1.split(" "));
        Expression exp2 = Expression.expressionFromPostfix(thisPost2.split(" "));
        assertTrue("'"+thisPost1+"' = '"+thisPost2+"'': ",exp1.equals(exp2));
    }
}
