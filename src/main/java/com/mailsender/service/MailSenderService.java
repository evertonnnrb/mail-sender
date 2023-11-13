package com.mailsender.service;

import com.mailsender.model.EmailMessage;
import com.mailsender.model.EmailMessageDto;
import com.mailsender.repository.EmailMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class MailSenderService {

    private final JavaMailSender mailSender;
    private final EmailMessageRepository repository;

    public SimpleMailMessage senderEmail(EmailMessageDto dto) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(dto.from());
        message.setTo(dto.to());
        message.setSubject(dto.title());
        message.setText(dto.message());
        mailSender.send(message);
        EmailMessage email = new EmailMessage(dto);
        email.setSend(true);
        email.setSendDate(LocalDate.now());
        repository.save(email);
        return message;
    }
}
