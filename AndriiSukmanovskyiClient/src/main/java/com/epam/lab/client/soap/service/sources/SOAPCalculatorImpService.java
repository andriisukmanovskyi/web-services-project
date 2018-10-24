
package com.epam.lab.client.soap.service.sources;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "SOAPCalculatorImpService", targetNamespace = "http://soap.lab.epam.com/", wsdlLocation = "http://localhost:8080/calculator-service/calcService?wsdl")
public class SOAPCalculatorImpService
    extends Service
{

    private final static URL SOAPCALCULATORIMPSERVICE_WSDL_LOCATION;
    private final static WebServiceException SOAPCALCULATORIMPSERVICE_EXCEPTION;
    private final static QName SOAPCALCULATORIMPSERVICE_QNAME = new QName("http://soap.lab.epam.com/", "SOAPCalculatorImpService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/calculator-service/calcService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SOAPCALCULATORIMPSERVICE_WSDL_LOCATION = url;
        SOAPCALCULATORIMPSERVICE_EXCEPTION = e;
    }

    public SOAPCalculatorImpService() {
        super(__getWsdlLocation(), SOAPCALCULATORIMPSERVICE_QNAME);
    }

    public SOAPCalculatorImpService(WebServiceFeature... features) {
        super(__getWsdlLocation(), SOAPCALCULATORIMPSERVICE_QNAME, features);
    }

    public SOAPCalculatorImpService(URL wsdlLocation) {
        super(wsdlLocation, SOAPCALCULATORIMPSERVICE_QNAME);
    }

    public SOAPCalculatorImpService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SOAPCALCULATORIMPSERVICE_QNAME, features);
    }

    public SOAPCalculatorImpService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SOAPCalculatorImpService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns SOAPCalculator
     */
    @WebEndpoint(name = "SOAPCalculatorImpPort")
    public SOAPCalculator getSOAPCalculatorImpPort() {
        return super.getPort(new QName("http://soap.lab.epam.com/", "SOAPCalculatorImpPort"), SOAPCalculator.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SOAPCalculator
     */
    @WebEndpoint(name = "SOAPCalculatorImpPort")
    public SOAPCalculator getSOAPCalculatorImpPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://soap.lab.epam.com/", "SOAPCalculatorImpPort"), SOAPCalculator.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SOAPCALCULATORIMPSERVICE_EXCEPTION!= null) {
            throw SOAPCALCULATORIMPSERVICE_EXCEPTION;
        }
        return SOAPCALCULATORIMPSERVICE_WSDL_LOCATION;
    }

}
