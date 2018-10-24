package com.epam.lab.client.soap;

import com.epam.lab.client.CalculatorClient;
import com.epam.lab.client.exceptions.DivisionByZeroException;
import com.epam.lab.client.soap.service.sources.SOAPCalculator;
import com.epam.lab.client.soap.service.sources.SOAPCalculatorImpService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SOAPCalculatorClient implements CalculatorClient {
    private static final Logger LOG = LogManager.getLogger(SOAPCalculatorClient.class);

    private static final String DIVISION_BY_ZERO_ERROR = "ERROR: Division by zero!";

    SOAPCalculatorImpService calculatorService;
    SOAPCalculator calculator;

    public SOAPCalculatorClient() {
        LOG.info("SOAP client: started");
        calculatorService = new SOAPCalculatorImpService();
        calculator = calculatorService.getSOAPCalculatorImpPort();
    }

    public double add(double firstNumber, double secondNumber) {
        LOG.info("SOAP client: addition");
        return Double.valueOf(calculator.add(firstNumber, secondNumber));
    }

    public double subtract(double firstNumber, double secondNumber) {
        LOG.info("SOAP client: subtraction");
        return Double.valueOf(calculator.subtract(firstNumber, secondNumber));
    }

    public double multiply(double firstNumber, double secondNumber) {
        LOG.info("SOAP client: multiplication");
        return Double.valueOf(calculator.multiply(firstNumber, secondNumber));
    }

    public double divide(double firstNumber, double secondNumber) {
        LOG.info("SOAP client: division");
        String response = calculator.divide(firstNumber, secondNumber);
        if (response.equals(DIVISION_BY_ZERO_ERROR))
            throw new DivisionByZeroException();
        return Double.valueOf(response);
    }

    public double getNumberPercentage(double firstNumber, double secondNumber) {
        LOG.info("SOAP client: percentage");
        return Double.valueOf(calculator.getNumberPercentage(firstNumber, secondNumber));
    }
}