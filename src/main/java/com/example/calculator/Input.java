package com.example.calculator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.util.StringUtils;

public class Input {

    List<String> accept() throws FileNotFoundException {

        System.out.println("Enter File path");
        Scanner scanner = new Scanner(System.in);

        String filePath = scanner.nextLine();
        scanner.close();
        if (StringUtils.isEmpty(filePath)) {
            throw new IllegalArgumentException("Invalid input...");
        }

        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }

        Scanner fileScanner = new Scanner(file);
        Integer numberOfLines = 0;

        if (fileScanner.hasNextLine()) {
            numberOfLines = Integer.parseInt(fileScanner.nextLine());
        }

        int counter = 0;
        List<String> expressions = new ArrayList<>();
        while (fileScanner.hasNextLine() && counter < numberOfLines) {
            expressions.add(fileScanner.nextLine());
            counter++;
        }
        fileScanner.close();

        return expressions;
    }
}
