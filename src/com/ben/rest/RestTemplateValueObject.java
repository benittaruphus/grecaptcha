package com.ben.rest;

import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class RestTemplateValueObject
{

	private HttpHeaders httpHeaders;

	private RestTemplate restTemplate;

	private UriComponentsBuilder uriComponentsBuilder;

	public HttpHeaders getHttpHeaders()
	{
		return httpHeaders;
	}

	public RestTemplate getRestTemplate()
	{
		return restTemplate;
	}

	public UriComponentsBuilder getUriComponentsBuilder()
	{
		return uriComponentsBuilder;
	}

	public void setHttpHeaders(HttpHeaders httpHeaders)
	{
		this.httpHeaders = httpHeaders;
	}

	public void setRestTemplate(RestTemplate restTemplate)
	{
		this.restTemplate = restTemplate;
	}

	public void setUriComponentsBuilder(UriComponentsBuilder uriComponentsBuilder)
	{
		this.uriComponentsBuilder = uriComponentsBuilder;
	}

}
