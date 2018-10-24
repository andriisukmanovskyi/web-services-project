package com.epam.lab;

import com.epam.lab.client.CalculatorClient;
import com.epam.lab.client.exceptions.DivisionByZeroException;
import com.epam.lab.factory.ClientFactory;
import com.epam.lab.client.type.ClientType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.epam.lab.test.data.TestData.*;
import static org.testng.Assert.assertEquals;

public class RESTCalculatorClientTest {

    private CalculatorClient calculatorClient;

    @BeforeTest
    public void initClient() {
        calculatorClient = ClientFactory.createCalculatorClient(ClientType.REST_CLIENT);
    }

    @Test
    public void testAddition() {
        assertEquals(calculatorClient.add(FIRST_TEST_NUMBER, SECOND_TEST_NUMBER), ADDITION_EXPECTED_RESULT);
    }

    @Test
    public void testSubtraction() {
        assertEquals(calculatorClient.subtract(FIRST_TEST_NUMBER, SECOND_TEST_NUMBER), SUBTRACTION_EXPECTED_RESULT);
    }

    @Test
    public void testMultiplication() {
        assertEquals(calculatorClient.multiply(FIRST_TEST_NUMBER, SECOND_TEST_NUMBER), MULTIPLICATION_EXPECTED_RESULT);
    }

    @Test
    public void testDivision() {
        assertEquals(calculatorClient.divide(FIRST_TEST_NUMBER, SECOND_TEST_NUMBER), DIVISION_EXPECTED_RESULT);
    }

    @Test(expectedExceptions = DivisionByZeroException.class)
    public void testDivisionByZero() {
        calculatorClient.divide(FIRST_TEST_NUMBER, SECOND_TEST_NUMBER_FOR_DIVISION_BY_ZERO);
    }

    @Test
    public void testPercentage() {
        assertEquals(calculatorClient.getNumberPercentage(FIRST_TEST_NUMBER, SECOND_TEST_NUMBER), PERCENTAGE_EXPECTED_RESULT);
    }
}