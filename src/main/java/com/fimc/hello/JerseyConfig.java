package com.fimc.hello;


import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.stereotype.Component;

import com.fimc.hello.resource.CalculatorResource;
import com.fimc.hello.resource.GtgResource;
import com.fimc.hello.resource.PeopleResource;

@Component
public class JerseyConfig extends ResourceConfig {
	
	public JerseyConfig() {
		register(GtgResource.class);
		register(CalculatorResource.class);
		register(PeopleResource.class);
		property(ServletProperties.FILTER_FORWARD_ON_404,true);
	}
}
