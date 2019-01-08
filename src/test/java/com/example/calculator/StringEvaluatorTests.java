package com.example.calculator;

import static org.junit.Assert.assertEquals;

import java.util.EmptyStackException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StringEvaluatorTests {

    @Test
    public void testForTwoOperand() {

        StringEvaluator eval = new StringEvaluator();
        int sum = eval.evaluate("(2+6)");
        assertEquals(8, sum);
    }
    @Test
    public void testForSingleOperand() {

        StringEvaluator eval = new StringEvaluator();
        int sum = eval.evaluate("(2)");
        assertEquals(2, sum);
    }
    @Test
    public void testForThreeOperand() {

        StringEvaluator eval = new StringEvaluator();
        int sum = eval.evaluate("(2+5*400)");
        assertEquals(2002, sum);
    }
    
    @Test(expected = EmptyStackException.class)
    public void testForInvalidExpression() {

        StringEvaluator eval = new StringEvaluator();
        eval.evaluate("8*+7");
        
    }

}
