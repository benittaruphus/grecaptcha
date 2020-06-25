package com.ben.recaptcha;

import java.util.stream.Stream;


public enum RecaptchaResponseCode
{
	MISSING_SECRET("missing-input-secret"),
	INVALID_SECRET("invalid-input-secret"),
	MISSING_RESPONSE("missing-input-response"),
	INVALID_RESPONSE("invalid-input-response"),
	DUPLICATE("timeout-or-duplicate"),
	BAD_REQUEST("bad-request"),
	SUCCESS("success");
	
	private String value;

	RecaptchaResponseCode(String value)
	{
		this.value = value;
	}

	public String getValue()
	{
		return value;
	}

	public static RecaptchaResponseCode getEnumByString(String recaptchaResponse)
	{
		return Stream.of(RecaptchaResponseCode.values())
				.filter(s -> s.value.equals(recaptchaResponse)).findFirst().orElse(null);
	}
}
