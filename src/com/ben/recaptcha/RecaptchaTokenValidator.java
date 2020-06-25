package com.ben.recaptcha;

import java.util.List;

import com.ben.rest.RecaptchaRestTemplate;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import com.ben.rest.RestTemplateValueObject;
import com.ben.rest.RestCaller;

@Service
public class RecaptchaTokenValidator
{

	@Autowired
	RestTemplateBuilder restTemplateBuilder;

	@Autowired
	private RestCaller restCallMaker;

	@Autowired
	private RecaptchaRestTemplate recaptchaRestTemplate;

	public boolean verifyRecaptchaToken(String recaptchaToken)
	{

		RestTemplateValueObject recaptchaVO = recaptchaRestTemplate.getRecaptchaVerificationTemplate(recaptchaToken);
		RecaptchaResponse recaptchaResponse = restCallMaker.makeCall(recaptchaVO, HttpMethod.POST, null,
				RecaptchaResponse.class);

		if (recaptchaResponse.isSuccess())
		{
			List<String> errorCodes = recaptchaResponse.getErrorCodes();

			return CollectionUtils.isEmpty(errorCodes);
		}
		return false;
	}
}