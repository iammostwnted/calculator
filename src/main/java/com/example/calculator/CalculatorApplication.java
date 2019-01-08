package com.example.calculator;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalculatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalculatorApplication.class, args);

        try {
            Input input = new Input();
            List<String> inputStrings = input.accept();
            StringEvaluator evaluator = new StringEvaluator();

            int counter = 1;
            for (String s : inputStrings) {
                try {
                    int output = evaluator.evaluate(s);
                    System.out.println("Case #" + counter + ": " + output);
                } catch (Exception e) {
                    System.out.println("Case #" + counter + ": INVALID EXPRESSION" );
                }finally {
                    counter++;  
                }
            }
            // inputStrings.stream().forEach(evaluator::evaluate);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
