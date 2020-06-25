package com.ben.recaptcha;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class RecaptchaResponse
{
	
	/*
	 * 
	 * {
  "success": true|false,
  "challenge_ts": timestamp,  // timestamp of the challenge load (ISO format yyyy-MM-dd'T'HH:mm:ssZZ)
  "hostname": string,         // the hostname of the site where the reCAPTCHA was solved
  "error-codes": [...]        // optional
	}
	 */
	
	@JsonProperty(value = "success")
	private boolean success;
	
	@JsonProperty(value = "challenge_ts")
	private String challengeTimeStamp;
	
	@JsonProperty(value = "hostname")
	private String hostname;
	
	@JsonProperty(value = "error-codes")
	private List<String> errorCodes;

	public boolean isSuccess()
	{
		return success;
	}

	public void setSuccess(boolean success)
	{
		this.success = success;
	}

	public String getChallengeTimeStamp()
	{
		return challengeTimeStamp;
	}

	public void setChallengeTimeStamp(String challengeTimeStamp)
	{
		this.challengeTimeStamp = challengeTimeStamp;
	}

	public String getHostname()
	{
		return hostname;
	}

	public void setHostname(String hostname)
	{
		this.hostname = hostname;
	}

	public List<String> getErrorCodes()
	{
		return errorCodes;
	}

	public void setErrorCodes(List<String> errorCodes)
	{
		this.errorCodes = errorCodes;
	}

}
