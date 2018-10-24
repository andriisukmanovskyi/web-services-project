package com.epam.lab.factory;

import com.epam.lab.client.CalculatorClient;
import com.epam.lab.client.type.ClientType;
import com.epam.lab.client.rest.RESTCalculatorClient;
import com.epam.lab.client.soap.SOAPCalculatorClient;

public class ClientFactory {
    public static CalculatorClient createCalculatorClient(ClientType clientType) {
        CalculatorClient calculatorClient = null;
        if (clientType.equals(ClientType.SOAP_CLIENT))
            calculatorClient = new SOAPCalculatorClient();
        else if (clientType.equals(ClientType.REST_CLIENT))
            calculatorClient = new RESTCalculatorClient();
        return calculatorClient;
    }
}