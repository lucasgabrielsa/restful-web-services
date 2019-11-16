package com.lucas.rest.webservices.restfulwebservices.filters;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.lucas.rest.webservices.restfulwebservices.models.SomeBeam;

@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	public MappingJacksonValue retrieveSomeBean() {
		
		//Dynamic Filter
		SomeBeam someBeam = new SomeBeam("value1", "value2", "value3");
		
		MappingJacksonValue mapping = new MappingJacksonValue(someBeam);
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		
		mapping.setFilters(filters);
		
		return mapping;
	}
	
	@GetMapping("/filtering-list")
	public List<SomeBeam> retrieveSomeBeanList() {
		return Arrays.asList(new SomeBeam("value1", "value2", "value3"), new SomeBeam("value11", "value22", "value33"));
	}


}
