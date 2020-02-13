package com.github.m111q.homework6.aspect;

import com.github.m111q.homework6.service.EmailService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmailAspect {

    private final String SOME_EMAIL = "***";
    private EmailService emailService;

    @Autowired
    public EmailAspect(EmailService emailService) {
        this.emailService = emailService;
    }

    @After("@annotation(SendEmailAspect)")
    public void sendEmailMessage() {
        emailService.sendEmail(SOME_EMAIL, "movielist info", "New Movie!");
    }
}
