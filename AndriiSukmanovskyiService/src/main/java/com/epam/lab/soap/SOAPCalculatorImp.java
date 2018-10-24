package com.epam.lab.soap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.jws.WebService;

@WebService(endpointInterface = "com.epam.lab.soap.SOAPCalculator")
public class SOAPCalculatorImp implements SOAPCalculator {
    private static final Logger LOG = LogManager.getLogger(SOAPCalculatorImp.class);

    private static final String DIVISION_BY_ZERO_ERROR_MESSAGE = "ERROR: Division by zero!";

    // The number of zeros means the number of decimal places after comma (1000d means 3 decimal places)
    private static final double NUMBER_FOR_DECIMAL_PLACES_ROUNDING = 10000d;

    public String add(double firstNumber, double secondNumber) {
        LOG.info("Calculator service: add operation");
        return roundResultNumber(firstNumber + secondNumber);
    }

    public String subtract(double firstNumber, double secondNumber) {
        LOG.info("Calculator service: subtract operation");
        return roundResultNumber(firstNumber - secondNumber);
    }

    public String multiply(double firstNumber, double secondNumber) {
        LOG.info("Calculator service: multiply operation");
        return roundResultNumber(firstNumber * secondNumber);
    }

    public String divide(double firstNumber, double secondNumber) {
        LOG.info("Calculator service: divide operation");
        if (secondNumber == 0.0)
            return DIVISION_BY_ZERO_ERROR_MESSAGE;
        return roundResultNumber(firstNumber / secondNumber);
    }

    public String getNumberPercentage(double firstNumber, double secondNumber) {
        LOG.info("Calculator service: round result number");
        return roundResultNumber((secondNumber * 100) / firstNumber);
    }

    private String roundResultNumber(double resultNumber) {
        return String.valueOf(Math.round(resultNumber * NUMBER_FOR_DECIMAL_PLACES_ROUNDING) / NUMBER_FOR_DECIMAL_PLACES_ROUNDING);
    }
}