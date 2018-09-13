package com.fimc.hello.resource;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Validation;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.fimc.hello.CalculatorNumber;
import com.fimc.hello.model.CalculatorResultResponse;
import com.fimc.hello.model.ValidationResponse;

@Component
@Path("/__calculator")
public class CalculatorResource {

	@POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response calculator(CalculatorNumber calculatorNumber) {
        CalculatorResultResponse calculatorResultResponse = new CalculatorResultResponse();
        CalculatorResponse calculatorResponse  =  new CalculatorResponse();
        ValidationResponse response = new ValidationResponse();
        
        if(calculatorResponse.operatorAction(calculatorNumber.getOperator()).equals("invalid operation")) {
        	response.setValidation("invalid method");
        	return Response.status(HttpServletResponse.SC_BAD_REQUEST).entity(response).build();
        }else {
        calculatorResultResponse.setTotal(calculatorResponse.Compute(calculatorNumber));
        calculatorResultResponse.setAction(calculatorResponse.operatorAction(calculatorNumber.getOperator()));
        return Response.ok().entity(calculatorResultResponse).build();
    }
	}
}
