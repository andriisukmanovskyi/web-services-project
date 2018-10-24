package com.epam.lab.rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("calculator")
public class RESTCalculator {
    private static final Logger LOG = LogManager.getLogger(RESTCalculator.class);

    private static final int DIVISION_BY_ZERO_ERROR_CODE = 110;

    // The number of zeros means the number of decimal places after comma (1000d means 3 decimal places)
    private static final double NUMBER_FOR_DECIMAL_PLACES_ROUNDING = 10000d;

    @GET
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(@QueryParam("firstNumber") double firstNumber, @QueryParam("secondNumber") double secondNumber) {
        LOG.info("REST calculator service: add operation");
        return getResultResponse(firstNumber + secondNumber);
    }

    @GET
    @Path("/subtract")
    @Produces(MediaType.APPLICATION_JSON)
    public Response subtract(@QueryParam("firstNumber") double firstNumber, @QueryParam("secondNumber") double secondNumber) {
        LOG.info("REST calculator service: subtract operation");
        return getResultResponse(firstNumber - secondNumber);
    }

    @GET
    @Path("/multiply")
    @Produces(MediaType.APPLICATION_JSON)
    public Response multiply(@QueryParam("firstNumber") double firstNumber, @QueryParam("secondNumber") double secondNumber) {
        LOG.info("REST calculator service: multiply operation");
        return getResultResponse(firstNumber * secondNumber);
    }

    @GET
    @Path("/divide")
    @Produces(MediaType.APPLICATION_JSON)
    public Response divide(@QueryParam("firstNumber") double firstNumber, @QueryParam("secondNumber") double secondNumber) {
        LOG.info("REST calculator service: divide operation");
        if (secondNumber == 0.0) {
            LOG.info("DIVISION BY ZERO!");
            return Response.status(DIVISION_BY_ZERO_ERROR_CODE).entity("Division by zero!").build();
        } else
            return getResultResponse(firstNumber / secondNumber);
    }

    @GET
    @Path("/percentage")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNumberPercentage(@QueryParam("firstNumber") double firstNumber, @QueryParam("secondNumber") double secondNumber) {
        LOG.info("REST calculator service: get percentage operation");
        return getResultResponse((secondNumber * 100) / firstNumber);
    }

    private double roundResultNumber(double resultNumber) {
        LOG.info("REST calculator service: round result number");
        return Math.round(resultNumber * NUMBER_FOR_DECIMAL_PLACES_ROUNDING) / NUMBER_FOR_DECIMAL_PLACES_ROUNDING;
    }

    private Response getResultResponse(double resultNumber) {
        return Response.ok().entity(roundResultNumber(resultNumber)).build();
    }
}