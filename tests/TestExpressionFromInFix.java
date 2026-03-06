import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class TestExpressionFromInFix {
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

    //----simple infix expression tests----
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

    //---can you make an expression from infix---
    @Test
    public void makeExpression_simple(){
        ArrayList<String> infix = buildInFix();
        for(String each:infix){
            try{
                Expression exp = Expression.expressionFromPostfix(each.split(" "));
                assertNotNull("Failed to make a simple expression. 'expressionFromPostfix()' is not functional. (most following tests will fail) (expect null pointer excpetions) ",exp);
            }catch(Exception e){
                System.out.println("Error creating simple postfix expression");
            }
        }
    }
    public ArrayList<Expression> makeInfixExpression_simple(){
        ArrayList<Expression> expressions = new ArrayList<Expression>();
        ArrayList<String> infix = buildInFix();
        for(String each:infix){
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
        ArrayList<Expression> expressions = makeInfixExpression_simple();
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
        ArrayList<Expression> expressions = makeInfixExpression_simple();
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
        ArrayList<Expression> expressions = makeInfixExpression_simple();
        ArrayList<String> infix = buildInFix();
        for(int i = 0; i < expressions.size(); i++){
            Expression exp = expressions.get(i);
            String ans = infix.get(i);
            ans = ans.replaceAll("\\s+", "");
            assertEquals("'"+exp+"': ",ans,exp.toInfix().replaceAll("\\s+",""));
        }
    }
}