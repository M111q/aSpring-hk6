package com.github.m111q.homework6.service;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class EmailService {

    @After("@annotation(MailAspect)")
    public void sendEmailMessage() {
        System.out.println("sendMail");
    }

}
