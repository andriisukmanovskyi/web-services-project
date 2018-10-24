package com.epam.lab.client;

public interface CalculatorClient {
    double add(double firstNumber, double secondNumber);

    double subtract(double firstNumber, double secondNumber);

    double multiply(double firstNumber, double secondNumber);

    double divide(double firstNumber, double secondNumber);

    double getNumberPercentage(double firstNumber, double secondNumber);
}