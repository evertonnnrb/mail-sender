package com.mailsender.service;

import com.mailsender.model.EmailMessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailSenderService {

    private final JavaMailSender mailSender;

    public void senderEmail(EmailMessageDto dto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(dto.from());
        message.setTo(dto.to());
        message.setSubject(dto.title());
        message.setText(dto.message());
        mailSender.send(message);
    }
}
