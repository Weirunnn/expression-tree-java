import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class TestExpressionSimplify {
    //---basic simplify---
    public String simpStr0 = "X 0 +";//x+0=x
    public String simpStr1 = "0 X +";//0+x=x
    public String simpStr2 = "X 1 *";//x*1=x
    public String simpStr3 = "1 X *";//1*x=x
    public String simpStr4 = "X 0 *";//x*0=0
    public String simpStr5 = "0 X *";//0*x=0
    public String simpStr6 = "0 X /";//0/x=0
    public String simpStr7 = "X 1 /";//x/1=x
    public String simpStr8 = "X X /";//x/x=1
    public String simpStr9 = "X 0 -";//x-0=x
    public String simpStr10 = "X X -";//x-x=0
    public String simpStr11 = "8 4 +";//12
    public String simpStr12 = "8 4 -";//4
    public String simpStr13 = "8 4 *";//24
    public String simpStr14 = "8 4 /";//2
    public ArrayList<String> postForBasicSimp(){
        ArrayList<String> post = new ArrayList<String>();
        post.add(simpStr0);
        post.add(simpStr1);
        post.add(simpStr2);
        post.add(simpStr3);
        post.add(simpStr4);
        post.add(simpStr5);
        post.add(simpStr6);
        post.add(simpStr7);
        post.add(simpStr8);
        post.add(simpStr9);
        post.add(simpStr10);
        post.add(simpStr11);
        post.add(simpStr12);
        post.add(simpStr13);
        post.add(simpStr14);
        return post;
    }
    public ArrayList<Expression> expressionsForBasicSimp(){
        ArrayList<String> post = postForBasicSimp();
        ArrayList<Expression> expressions = new ArrayList<Expression>();
        for(int i = 0; i < post.size(); i++){
            String s = post.get(i);
            Expression exp = Expression.expressionFromPostfix(s.split(" "));
            expressions.add(exp);
        }
        return expressions;
    }
    public ArrayList<Expression> basicSimplified(){
        ArrayList<Expression> answers = new ArrayList<Expression>();
        Expression x = Expression.expressionFromPostfix("X".split(" "));
        Expression one = Expression.expressionFromPostfix("1".split(" "));
        Expression zero = Expression.expressionFromPostfix("0".split(" "));
        answers.add(x);
	    answers.add(x);
	    answers.add(x);
	    answers.add(x);
	    answers.add(zero);
	    answers.add(zero);
	    answers.add(zero);
	    answers.add(x);
	    answers.add(one);
	    answers.add(x);
	    answers.add(zero);
	    answers.add(Expression.expressionFromPostfix("12".split(" ")));
	    answers.add(Expression.expressionFromPostfix("4".split(" ")));
	    answers.add(Expression.expressionFromPostfix("32".split(" ")));
	    answers.add(Expression.expressionFromPostfix("2".split(" ")));
        return answers;
    }
    @Test
    public void basic_simplify0(){
        ArrayList<Expression> expressions = expressionsForBasicSimp();
        ArrayList<Expression> expected = basicSimplified();
        assertEquals("'"+simpStr0+"': ",expected.get(0),expressions.get(0).simplify());
    }
    @Test
    public void basic_simplify1(){
        ArrayList<Expression> expressions = expressionsForBasicSimp();
        ArrayList<Expression> expected = basicSimplified();
        assertEquals("'"+simpStr1+"': ",expected.get(1),expressions.get(1).simplify());
    }
    @Test
    public void basic_simplify2(){
        ArrayList<Expression> expressions = expressionsForBasicSimp();
        ArrayList<Expression> expected = basicSimplified();
        assertEquals("'"+simpStr2+"': ",expected.get(2),expressions.get(2).simplify());
    }
    @Test
    public void basic_simplify3(){
        ArrayList<Expression> expressions = expressionsForBasicSimp();
        ArrayList<Expression> expected = basicSimplified();
        assertEquals("'"+simpStr3+"': ",expected.get(3),expressions.get(3).simplify());
    }
    @Test
    public void basic_simplify4(){
        ArrayList<Expression> expressions = expressionsForBasicSimp();
        ArrayList<Expression> expected = basicSimplified();
        assertEquals("'"+simpStr4+"': ",expected.get(4),expressions.get(4).simplify());
    }
    @Test
    public void basic_simplify5(){
        ArrayList<Expression> expressions = expressionsForBasicSimp();
        ArrayList<Expression> expected = basicSimplified();
        assertEquals("'"+simpStr5+"': ",expected.get(5),expressions.get(5).simplify());
    }
    @Test
    public void basic_simplify6(){
        ArrayList<Expression> expressions = expressionsForBasicSimp();
        ArrayList<Expression> expected = basicSimplified();
        assertEquals("'"+simpStr6+"': ",expected.get(6),expressions.get(6).simplify());
    }
    @Test
    public void basic_simplify7(){
        ArrayList<Expression> expressions = expressionsForBasicSimp();
        ArrayList<Expression> expected = basicSimplified();
        assertEquals("'"+simpStr7+"': ",expected.get(7),expressions.get(7).simplify());
    }
    @Test
    public void basic_simplify8(){
        ArrayList<Expression> expressions = expressionsForBasicSimp();
        ArrayList<Expression> expected = basicSimplified();
        assertEquals("'"+simpStr8+"': ",expected.get(8),expressions.get(8).simplify());
    }
    @Test
    public void basic_simplify9(){
        ArrayList<Expression> expressions = expressionsForBasicSimp();
        ArrayList<Expression> expected = basicSimplified();
        assertEquals("'"+simpStr9+"': ",expected.get(9),expressions.get(9).simplify());
    }
    @Test
    public void basic_simplify10(){
        ArrayList<Expression> expressions = expressionsForBasicSimp();
        ArrayList<Expression> expected = basicSimplified();
        assertEquals("'"+simpStr10+"': ",expected.get(10),expressions.get(10).simplify());
    }
    @Test
    public void basic_simplify11(){
        ArrayList<Expression> expressions = expressionsForBasicSimp();
        ArrayList<Expression> expected = basicSimplified();
        assertEquals("'"+simpStr11+"': ",expected.get(11),expressions.get(11).simplify());
    }
    @Test
    public void basic_simplify12(){
        ArrayList<Expression> expressions = expressionsForBasicSimp();
        ArrayList<Expression> expected = basicSimplified();
        assertEquals("'"+simpStr12+"': ",expected.get(12),expressions.get(12).simplify());
    }
    @Test
    public void basic_simplify13(){
        ArrayList<Expression> expressions = expressionsForBasicSimp();
        ArrayList<Expression> expected = basicSimplified();
        assertEquals("'"+simpStr13+"': ",expected.get(13),expressions.get(13).simplify());
    }
    @Test
    public void basic_simplify14(){
        ArrayList<Expression> expressions = expressionsForBasicSimp();
        ArrayList<Expression> expected = basicSimplified();
        assertEquals("'"+simpStr14+"': ",expected.get(14),expressions.get(14).simplify());
    }
    //--complex simplify--
    public ArrayList<Expression> complexSimplifyAnswers(){
        ArrayList<Expression> answers = new ArrayList<Expression>();
        Expression cde = Expression.expressionFromPostfix("C D +".split(" "));
        Expression cdx = Expression.expressionFromPostfix("C D + X +".split(" "));
        Expression xcd = Expression.expressionFromPostfix("X C D + +".split(" "));
        Expression cd1 = Expression.expressionFromPostfix("1 C D + +".split(" "));
        Expression onecd = Expression.expressionFromPostfix("1 C D + +".split(" "));
    
        for (int i = 0; i < 4; i++)
        {
            answers.add(cdx);
            answers.add(xcd);
        }
        for(int i = 0; i < 6; i++){
            answers.add(cde);
        }
            answers.add(cdx);
            answers.add(xcd);
            answers.add(cd1);
            answers.add(onecd);
            answers.add(cdx);
            answers.add(xcd);
            answers.add(cde);
            answers.add(cde);
        
            answers.add(Expression.expressionFromPostfix("C D + 12 +".split(" ")));
            answers.add(Expression.expressionFromPostfix("12 C D + +".split(" ")));
    
            answers.add(Expression.expressionFromPostfix("C D + 4 +".split(" ")));
            answers.add(Expression.expressionFromPostfix("4 C D + +".split(" ")));
        
            answers.add(Expression.expressionFromPostfix("C D + 32 +".split(" ")));
            answers.add(Expression.expressionFromPostfix("32 C D + +".split(" ")));
    
            answers.add(Expression.expressionFromPostfix("C D + 2 +".split(" ")));
            answers.add(Expression.expressionFromPostfix("2 C D + +".split(" ")));
        return answers;
    }
    public ArrayList<String> complexStr(){
        ArrayList<String> post = postForBasicSimp();
        //ArrayList<Expression> answers = complexSimplifyAnswers();
        String cd = "C D +";
        String plus = " +";
        ArrayList<String> complexStr = new ArrayList<String>();
        for (String s : post){
            String right = cd + " " + s + plus;
            String left = s + " " + cd + plus;
            complexStr.add(right);
            complexStr.add(left);
        }
        return complexStr;
    }
    public ArrayList<Expression> complexExp(){
        ArrayList<String> complexStr = complexStr();
        ArrayList<Expression> complex = new ArrayList<Expression>();
        for(int i = 0; i < complexStr.size(); i++){
            Expression exp = Expression.expressionFromPostfix(complexStr.get(i).split(" "));
            complex.add(exp);
        }
        return complex;
    }
    @Test
    public void complex_simplify0(){
        ArrayList<String> scenario = complexStr();
        ArrayList<Expression> complex = complexExp();
        ArrayList<Expression> answers = complexSimplifyAnswers();
        assertEquals("'"+scenario.get(0)+"': ",answers.get(0),complex.get(0).simplify());
    }
    @Test
    public void complex_simplify1(){
        ArrayList<String> scenario = complexStr();
        ArrayList<Expression> complex = complexExp();
        ArrayList<Expression> answers = complexSimplifyAnswers();
        assertEquals("'"+scenario.get(1)+"': ",answers.get(1),complex.get(1).simplify());
    }
    @Test
    public void complex_simplify2(){
        ArrayList<String> scenario = complexStr();
        ArrayList<Expression> complex = complexExp();
        ArrayList<Expression> answers = complexSimplifyAnswers();
        assertEquals("'"+scenario.get(2)+"': ",answers.get(2),complex.get(2).simplify());
    }
    @Test
    public void complex_simplify3(){
        ArrayList<String> scenario = complexStr();
        ArrayList<Expression> complex = complexExp();
        ArrayList<Expression> answers = complexSimplifyAnswers();
        assertEquals("'"+scenario.get(3)+"': ",answers.get(3),complex.get(3).simplify());
    }
    @Test
    public void complex_simplify4(){
        ArrayList<String> scenario = complexStr();
        ArrayList<Expression> complex = complexExp();
        ArrayList<Expression> answers = complexSimplifyAnswers();
        assertEquals("'"+scenario.get(4)+"': ",answers.get(4),complex.get(4).simplify());
    }
    @Test
    public void complex_simplify5(){
        ArrayList<String> scenario = complexStr();
        ArrayList<Expression> complex = complexExp();
        ArrayList<Expression> answers = complexSimplifyAnswers();
        assertEquals("'"+scenario.get(5)+"': ",answers.get(5),complex.get(5).simplify());
    }
    @Test
    public void complex_simplify6(){
        ArrayList<String> scenario = complexStr();
        ArrayList<Expression> complex = complexExp();
        ArrayList<Expression> answers = complexSimplifyAnswers();
        assertEquals("'"+scenario.get(6)+"': ",answers.get(6),complex.get(6).simplify());
    }
    @Test
    public void complex_simplify7(){
        ArrayList<String> scenario = complexStr();
        ArrayList<Expression> complex = complexExp();
        ArrayList<Expression> answers = complexSimplifyAnswers();
        assertEquals("'"+scenario.get(7)+"': ",answers.get(7),complex.get(7).simplify());
    }
    @Test
    public void complex_simplify8(){
        ArrayList<String> scenario = complexStr();
        ArrayList<Expression> complex = complexExp();
        ArrayList<Expression> answers = complexSimplifyAnswers();
        assertEquals("'"+scenario.get(8)+"': ",answers.get(8),complex.get(8).simplify());
    }
    @Test
    public void complex_simplify9(){
        ArrayList<String> scenario = complexStr();
        ArrayList<Expression> complex = complexExp();
        ArrayList<Expression> answers = complexSimplifyAnswers();
        assertEquals("'"+scenario.get(9)+"': ",answers.get(9),complex.get(9).simplify());
    }
    @Test
    public void complex_simplify10(){
        ArrayList<String> scenario = complexStr();
        ArrayList<Expression> complex = complexExp();
        ArrayList<Expression> answers = complexSimplifyAnswers();
        assertEquals("'"+scenario.get(10)+"': ",answers.get(10),complex.get(10).simplify());
    }
    @Test
    public void complex_simplify11(){
        ArrayList<String> scenario = complexStr();
        ArrayList<Expression> complex = complexExp();
        ArrayList<Expression> answers = complexSimplifyAnswers();
        assertEquals("'"+scenario.get(11)+"': ",answers.get(11),complex.get(11).simplify());
    }
    @Test
    public void complex_simplify12(){
        ArrayList<String> scenario = complexStr();
        ArrayList<Expression> complex = complexExp();
        ArrayList<Expression> answers = complexSimplifyAnswers();
        assertEquals("'"+scenario.get(12)+"': ",answers.get(12),complex.get(12).simplify());
    }
    @Test
    public void complex_simplify13(){
        ArrayList<String> scenario = complexStr();
        ArrayList<Expression> complex = complexExp();
        ArrayList<Expression> answers = complexSimplifyAnswers();
        assertEquals("'"+scenario.get(13)+"': ",answers.get(13),complex.get(13).simplify());
    }
    @Test
    public void complex_simplify14(){
        ArrayList<String> scenario = complexStr();
        ArrayList<Expression> complex = complexExp();
        ArrayList<Expression> answers = complexSimplifyAnswers();
        assertEquals("'"+scenario.get(14)+"': ",answers.get(14),complex.get(14).simplify());
    }
    @Test
    public void complex_simplify15(){
        ArrayList<String> scenario = complexStr();
        ArrayList<Expression> complex = complexExp();
        ArrayList<Expression> answers = complexSimplifyAnswers();
        assertEquals("'"+scenario.get(15)+"': ",answers.get(15),complex.get(15).simplify());
    }
    @Test
    public void complex_simplify16(){
        ArrayList<String> scenario = complexStr();
        ArrayList<Expression> complex = complexExp();
        ArrayList<Expression> answers = complexSimplifyAnswers();
        assertEquals("'"+scenario.get(16)+"': ",answers.get(16),complex.get(16).simplify());
    }
    @Test
    public void complex_simplify17(){
        ArrayList<String> scenario = complexStr();
        ArrayList<Expression> complex = complexExp();
        ArrayList<Expression> answers = complexSimplifyAnswers();
        assertEquals("'"+scenario.get(17)+"': ",answers.get(17),complex.get(17).simplify());
    }
    @Test
    public void complex_simplify18(){
        ArrayList<String> scenario = complexStr();
        ArrayList<Expression> complex = complexExp();
        ArrayList<Expression> answers = complexSimplifyAnswers();
        assertEquals("'"+scenario.get(18)+"': ",answers.get(18),complex.get(18).simplify());
    }
    @Test
    public void complex_simplify19(){
        ArrayList<String> scenario = complexStr();
        ArrayList<Expression> complex = complexExp();
        ArrayList<Expression> answers = complexSimplifyAnswers();
        assertEquals("'"+scenario.get(19)+"': ",answers.get(19),complex.get(19).simplify());
    }
    @Test
    public void complex_simplify20(){
        ArrayList<String> scenario = complexStr();
        ArrayList<Expression> complex = complexExp();
        ArrayList<Expression> answers = complexSimplifyAnswers();
        assertEquals("'"+scenario.get(20)+"': ",answers.get(20),complex.get(20).simplify());
    }
    @Test
    public void complex_simplify21(){
        ArrayList<String> scenario = complexStr();
        ArrayList<Expression> complex = complexExp();
        ArrayList<Expression> answers = complexSimplifyAnswers();
        assertEquals("'"+scenario.get(21)+"': ",answers.get(21),complex.get(21).simplify());
    }
    @Test
    public void complex_simplify22(){
        ArrayList<String> scenario = complexStr();
        ArrayList<Expression> complex = complexExp();
        ArrayList<Expression> answers = complexSimplifyAnswers();
        assertEquals("'"+scenario.get(22)+"': ",answers.get(22),complex.get(22).simplify());
    }
    @Test
    public void complex_simplify23(){
        ArrayList<String> scenario = complexStr();
        ArrayList<Expression> complex = complexExp();
        ArrayList<Expression> answers = complexSimplifyAnswers();
        assertEquals("'"+scenario.get(23)+"': ",answers.get(23),complex.get(23).simplify());
    }
    @Test
    public void complex_simplify24(){
        ArrayList<String> scenario = complexStr();
        ArrayList<Expression> complex = complexExp();
        ArrayList<Expression> answers = complexSimplifyAnswers();
        assertEquals("'"+scenario.get(24)+"': ",answers.get(24),complex.get(24).simplify());
    }
    @Test
    public void complex_simplify25(){
        ArrayList<String> scenario = complexStr();
        ArrayList<Expression> complex = complexExp();
        ArrayList<Expression> answers = complexSimplifyAnswers();
        assertEquals("'"+scenario.get(25)+"': ",answers.get(25),complex.get(25).simplify());
    }
    @Test
    public void complex_simplify26(){
        ArrayList<String> scenario = complexStr();
        ArrayList<Expression> complex = complexExp();
        ArrayList<Expression> answers = complexSimplifyAnswers();
        assertEquals("'"+scenario.get(26)+"': ",answers.get(26),complex.get(26).simplify());
    }
    @Test
    public void complex_simplify27(){
        ArrayList<String> scenario = complexStr();
        ArrayList<Expression> complex = complexExp();
        ArrayList<Expression> answers = complexSimplifyAnswers();
        assertEquals("'"+scenario.get(27)+"': ",answers.get(27),complex.get(27).simplify());
    }
    @Test
    public void complex_simplify28(){
        ArrayList<String> scenario = complexStr();
        ArrayList<Expression> complex = complexExp();
        ArrayList<Expression> answers = complexSimplifyAnswers();
        assertEquals("'"+scenario.get(28)+"': ",answers.get(28),complex.get(28).simplify());
    }
    @Test
    public void complex_simplify29(){
        ArrayList<String> scenario = complexStr();
        ArrayList<Expression> complex = complexExp();
        ArrayList<Expression> answers = complexSimplifyAnswers();
        assertEquals("'"+scenario.get(29)+"': ",answers.get(29),complex.get(29).simplify());
    }
}
