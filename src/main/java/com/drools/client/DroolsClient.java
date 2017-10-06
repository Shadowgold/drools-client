package com.drools.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;


import com.backend.dto.DTOInferirCategoria;

@Component
public class DroolsClient {
	
	@Autowired
	private RestOperations restOperations;
	private final String url;
	
	@Autowired
	public DroolsClient(@Value("${backend.service.url}")final String url) {
		this.url = url;
	}
	public DTOInferirCategoria getDTOInferirCategoria(final int backendNumber) {
		return restOperations.getForObject(url, DTOInferirCategoria.class, backendNumber);
	}
	
}
