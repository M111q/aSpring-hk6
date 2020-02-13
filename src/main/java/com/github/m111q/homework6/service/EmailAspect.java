package com.github.m111q.homework6.service;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmailAspect {

    private EmailServiceImpl emailServiceImpl;

    @After("@annotation(SendEmailAspect)")
    public void sendEmailMessage() {
        emailServiceImpl.sendEmail("send Mail");
    }
}
