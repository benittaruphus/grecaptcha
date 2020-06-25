package com.ben.controller;

import com.ben.recaptcha.RecaptchaTokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/rest")
public class RecaptchaController {

    @Autowired
    private RecaptchaTokenValidator recaptchaTokenValidator;

    @PostMapping("/verifyrecaptcha")
    public boolean verifyRecaptcha(String recaptchaToken) {
        boolean verified = recaptchaTokenValidator.verifyRecaptchaToken(recaptchaToken);
        return verified;
    }

}