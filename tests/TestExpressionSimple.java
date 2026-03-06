import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class TestExpressionSimple {
    //----simple expression tests----
    public ArrayList<String> buildPostFix(){
        ArrayList<String> postfix = new ArrayList<String>();
        String [] vars = {"X", "Z"};
        String [] ops = {"+", "-", "*", "/"};
        for (int i = 0; i < vars.length; i++){
            for (String op : ops){
                if (i == 0){
                    postfix.add(vars[0] + " " + vars[1] + " " + op);
                }
                else{
                    postfix.add(vars[1] + " " + vars[0] + " " + op);
                }
            }
        }
        return postfix;
    }
    public ArrayList<String> buildInFix(){
        //X+Z, X-Z, X*Z, X/Z, Z+X, etc
        ArrayList<String> infix = new ArrayList<String>();
        String [] vars = {"X", "Z"};
        String [] ops = {"+", "-", "*", "/"};
        for (int i = 0; i < vars.length; i++){
            for (String op : ops){
                if (i == 0){
                    infix.add("( "+vars[0] + " " + op + " " + vars[1]+" )");
                }
                else{
                    infix.add("( "+ vars[1] + " " + op + " " + vars[0]+" )");
                }
            }
        }
        return infix;
    }
    //---can you make an expression---
    @Test
    public void makeExpression_simple(){
        ArrayList<String> postfix = buildPostFix();
        for(String each:postfix){
            try{
                Expression exp = Expression.expressionFromPostfix(each.split(" "));
                assertNotNull("Failed to make a simple expression. 'expressionFromPostfix()' is not functional. (most following tests will fail) (expect null pointer excpetions) ",exp);
            }catch(Exception e){
                System.out.println("Error creating simple postfix expression");
            }
        }
    }
    public ArrayList<Expression> makePostExpression_simple(){
        ArrayList<Expression> expressions = new ArrayList<Expression>();
        ArrayList<String> postfix = buildPostFix();
        for(String each:postfix){
            try{
                Expression exp = Expression.expressionFromPostfix(each.split(" "));
                expressions.add(exp);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return expressions;
    }
    //---toPostfix()---
    @Test
    public void toPostfix_simple(){
        ArrayList<Expression> expressions = makePostExpression_simple();
        ArrayList<String> postfix = buildPostFix();
        for(int i = 0; i < expressions.size(); i++){
            Expression exp = expressions.get(i);
            String ans = postfix.get(i);
            ans = ans.replaceAll("\\s+","");
            assertEquals("'"+exp+"': ",ans,exp.toPostfix().replaceAll("\\s+",""));
        }
    }
    //---toPrefix()---
    @Test
    public void toPrefix_simple(){
        ArrayList<Expression> expressions = makePostExpression_simple();
        ArrayList<String> postfix = buildPostFix();
        ArrayList<String> prefix = new ArrayList<String>();
        for(String str : postfix){
            String pre = str.substring(4)+" "+str.substring(0,3);
            prefix.add(pre);
        }
        for(int i = 0; i < expressions.size(); i++){
            Expression exp = expressions.get(i);
            String ans = prefix.get(i).replaceAll("\\s+", "");
            assertEquals("'"+exp+"': ",ans,exp.toPrefix().replaceAll("\\s+",""));
        }
    }
    //---toInfix()---
    @Test
    public void toInfix_simple(){
        ArrayList<Expression> expressions = makePostExpression_simple();
        ArrayList<String> infix = buildInFix();
        for(int i = 0; i < expressions.size(); i++){
            Expression exp = expressions.get(i);
            String ans = infix.get(i);
            ans = ans.replaceAll("\\s+", "");
            assertEquals("'"+exp+"': ",ans,exp.toInfix().replaceAll("\\s+",""));
        }
    }
    //---getVariables()---
    @Test
    public void getVariables_simple(){
        ArrayList<Expression> expressions = makePostExpression_simple();
        for(Expression exp : expressions){
            Set<String> vars = exp.getVariables();
            assertEquals(2,vars.size());
        }
    }   
    @Test
    public void simple_X_is_present(){
        ArrayList<Expression> expressions = makePostExpression_simple();
        for(Expression each : expressions){
            Set<String> var = each.getVariables();
            assertTrue(var.contains("X"));
        }
    }
    @Test
    public void simple_Z_is_present(){
        ArrayList<Expression> expressions = makePostExpression_simple();
        for(Expression each : expressions){
            Set<String> var = each.getVariables();
            assertTrue(var.contains("Z"));
        }
    }
    @Test
    public void simple_Y_not_present(){
        ArrayList<Expression> expressions = makePostExpression_simple();
        for(Expression each : expressions){
            Set<String> var = each.getVariables();
            assertFalse(var.contains("Y"));
        }
    }
    //---evaluate()---
    public HashMap<String,Integer> makeSimpleMap(){
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        map.put("X",16);
        map.put("Z",-8);
        return map;
    }
    public int[] answers = {8, 24, -128, -2, 8, -24, -128, 0};
    @Test
    public void simple_evaluate0(){
        ArrayList<Expression> expressions = makePostExpression_simple();
        HashMap<String,Integer> map = makeSimpleMap();
        assertEquals("'"+expressions.get(0)+"': ",answers[0],expressions.get(0).evaluate(map));
    }
    @Test
    public void simple_evaluate1(){
        ArrayList<Expression> expressions = makePostExpression_simple();
        HashMap<String,Integer> map = makeSimpleMap();
        assertEquals("'"+expressions.get(1)+"': ",answers[1],expressions.get(1).evaluate(map));
    }
    @Test
    public void simple_evaluate2(){
        ArrayList<Expression> expressions = makePostExpression_simple();
        HashMap<String,Integer> map = makeSimpleMap();
        assertEquals("'"+expressions.get(2)+"': ",answers[2],expressions.get(2).evaluate(map));
    }
    @Test
    public void simple_evaluate3(){
        ArrayList<Expression> expressions = makePostExpression_simple();
        HashMap<String,Integer> map = makeSimpleMap();
        assertEquals("'"+expressions.get(3)+"': ",answers[3],expressions.get(3).evaluate(map));
    }
    @Test
    public void simple_evaluate4(){
        ArrayList<Expression> expressions = makePostExpression_simple();
        HashMap<String,Integer> map = makeSimpleMap();
        assertEquals("'"+expressions.get(4)+"': ",answers[4],expressions.get(4).evaluate(map));
    }
    @Test
    public void simple_evaluate5(){
        ArrayList<Expression> expressions = makePostExpression_simple();
        HashMap<String,Integer> map = makeSimpleMap();
        assertEquals("'"+expressions.get(5)+"': ",answers[5],expressions.get(5).evaluate(map));
    }
    @Test
    public void simple_evaluate6(){
        ArrayList<Expression> expressions = makePostExpression_simple();
        HashMap<String,Integer> map = makeSimpleMap();
        assertEquals("'"+expressions.get(6)+"': ",answers[6],expressions.get(6).evaluate(map));
    }
    @Test
    public void simple_evaluate7(){
        ArrayList<Expression> expressions = makePostExpression_simple();
        HashMap<String,Integer> map = makeSimpleMap();
        assertEquals("'"+expressions.get(7)+"': ",answers[7],expressions.get(7).evaluate(map));
    }
    //---equals()---
    @Test
    public void compareToSelf(){
        Expression exp1 = makePostExpression_simple().get(0);
        Expression exp2 = makePostExpression_simple().get(0);
        assertTrue("'"+exp1+"' = '"+exp2+"'': ",exp1.equals(exp2));
    }
    @Test
    public void expressionNotString(){
        Expression exp1 = makePostExpression_simple().get(0);
        String str = buildPostFix().get(0);
        assertFalse("'"+exp1+"' != string '"+str+"'': ",exp1.equals(str));
    }
    @Test
    public void orderDoesntMatter(){
        String str1 = "X Z +";
        Expression exp1 = Expression.expressionFromPostfix(str1.split(" "));
        String str2 = "Z X +";
        Expression exp2 = Expression.expressionFromPostfix(str2.split(" "));
        assertTrue("'"+str1+"' = '"+str2+"'': ",exp1.equals(exp2));
    }
}
