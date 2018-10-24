package com.epam.lab.client.rest;

import com.epam.lab.client.CalculatorClient;
import com.epam.lab.client.exceptions.DivisionByZeroException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.core.MediaType;

public class RESTCalculatorClient implements CalculatorClient {
    private static final Logger LOG = LogManager.getLogger(RESTCalculatorClient.class);

    private static final int DIVISION_BY_ZERO_ERROR_CODE = 110;

    private static final String CALCULATOR_URL = "http://localhost:8080/calculator-service/webapi/calculator/";
    private static final String CALCULATOR_OPERATION_ADDITION = "add";
    private static final String CALCULATOR_OPERATION_SUBTRACTION = "subtract";
    private static final String CALCULATOR_OPERATION_MULTIPLICATION = "multiply";
    private static final String CALCULATOR_OPERATION_DIVISION = "divide";
    private static final String CALCULATOR_OPERATION_PERCENTAGE = "percentage";
    private static final String CALCULATOR_OPERATION_PARAMETERS = "?firstNumber=%.4f&secondNumber=%.4f";

    Client client;
    WebResource webResource;
    ClientResponse response;

    public RESTCalculatorClient() {
        LOG.info("REST client started");
        client = Client.create();
    }

    public double add(double firstNumber, double secondNumber) {
        LOG.info("REST client: addition");
        return getResult(CALCULATOR_OPERATION_ADDITION, firstNumber, secondNumber);
    }

    public double subtract(double firstNumber, double secondNumber) {
        LOG.info("REST client: subtraction");
        return getResult(CALCULATOR_OPERATION_SUBTRACTION, firstNumber, secondNumber);
    }

    public double multiply(double firstNumber, double secondNumber) {
        LOG.info("REST client: multiplication");
        return getResult(CALCULATOR_OPERATION_MULTIPLICATION, firstNumber, secondNumber);
    }

    public double divide(double firstNumber, double secondNumber) {
        LOG.info("REST client: division");
        return getResult(CALCULATOR_OPERATION_DIVISION, firstNumber, secondNumber);
    }

    public double getNumberPercentage(double firstNumber, double secondNumber) {
        LOG.info("REST client: percentage");
        return getResult(CALCULATOR_OPERATION_PERCENTAGE, firstNumber, secondNumber);
    }

    private double getResult(String operation, double firstNumber, double secondNumber) {
        String parametersURL = String.format(
                CALCULATOR_OPERATION_PARAMETERS, firstNumber, secondNumber).replace(",", ".");
        String url = CALCULATOR_URL + operation + parametersURL;
        LOG.info("REST client: getting result for url=" + url);
        webResource = client.resource(url);
        response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        if (response.getStatus() == DIVISION_BY_ZERO_ERROR_CODE)
            throw new DivisionByZeroException();
        return Double.valueOf(response.getEntity(String.class));
    }
}