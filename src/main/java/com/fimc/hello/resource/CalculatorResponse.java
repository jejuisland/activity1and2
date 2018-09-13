package com.fimc.hello.resource;

import java.io.Serializable;

import com.fimc.hello.CalculatorNumber;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CalculatorResponse implements Serializable{


	public double Compute(CalculatorNumber calculatorNumber) {
	    double total=0;
		
		if (calculatorNumber.getOperator().equals("+")) {
			total = (calculatorNumber.getFirstnumber()+calculatorNumber.getSecondnumber());
		}
		else if (calculatorNumber.getOperator().equals("-")) {
			total = (calculatorNumber.getFirstnumber()-calculatorNumber.getSecondnumber());
		}
		else if (calculatorNumber.getOperator().equals("*")) {
			total = (calculatorNumber.getFirstnumber()*calculatorNumber.getSecondnumber());
		}
		else if (calculatorNumber.getOperator().equals("/")) {
			total = (calculatorNumber.getFirstnumber()/calculatorNumber.getSecondnumber());
		} 
		return total;
	}
	public String operatorAction(String action) {
		String method = "";
		
		switch (action) {
		case "+":
			method="added";
			break;
		case "-":
			method="subtracted";
			break;	
		case "*":
			method="multiplied";
			break;	
		case "/":
			method="divided";
			break;	
		default:
			method ="invalid operation" ;
			break;
			
		}
		
		
		return method;
	}
}
