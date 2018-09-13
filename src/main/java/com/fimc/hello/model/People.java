package com.fimc.hello.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class People {


	    private String firstName;
	    private String lastName;
	    private String birthDate;

	    public People(String firstName, String lastName, String birthDate) {
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.birthDate = birthDate;
	    }

	}

