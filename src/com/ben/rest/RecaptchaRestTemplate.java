package com.ben.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.ben.rest.RestTemplateValueObject;

@Service
public class RecaptchaRestTemplate
{

	@Value("${google.recaptcha.verify.url}")
	private String googleRecaptchaVerifyUrl;

	@Value("${google.recaptcha.secret}")
	private String googleRecaptchaSecret;

	@Autowired
	private RestTemplate restTemplate;

	public RestTemplateValueObject getRecaptchaVerificationTemplate(String recaptchaToken)
	{
		RestTemplateValueObject restTemplateObj = new RestTemplateValueObject();
		String url = new StringBuilder(googleRecaptchaVerifyUrl).append(recaptchaToken).toString();
		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(url)
				.queryParam("secret", googleRecaptchaSecret).queryParam("response", recaptchaToken);
		restTemplateObj.setRestTemplate(restTemplate);
		restTemplateObj.setUriComponentsBuilder(uriComponentsBuilder);
		return restTemplateObj;
	}

}
