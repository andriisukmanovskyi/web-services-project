package com.epam.lab.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface SOAPCalculator {
    @WebMethod
    String add(double firstNumber, double secondNumber);

    @WebMethod
    String subtract(double firstNumber, double secondNumber);

    @WebMethod
    String multiply(double firstNumber, double secondNumber);

    @WebMethod
    String divide(double firstNumber, double secondNumber);

    @WebMethod
    String getNumberPercentage(double firstNumber, double secondNumber);
}