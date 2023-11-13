package com.mailsender;

import com.mailsender.model.EmailMessageDto;
import com.mailsender.service.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class MailSenderApplication {

    @Autowired
    MailSenderService mailSenderService;

    public static void main(String[] args) {
        SpringApplication.run(MailSenderApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void sendMail() {
        EmailMessageDto dto = new EmailMessageDto("APLLICATION", "nnrb.suporte@gmail.com", "everton.nnrb@gmail.com",
                "TESTE MAIL SENDER", "TRYING SEND A EMAIL WITH SPRING APPLICATION");
        mailSenderService.senderEmail(dto);
    }
}
