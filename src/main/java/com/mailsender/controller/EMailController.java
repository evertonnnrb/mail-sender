package com.mailsender.controller;

import com.mailsender.model.EmailMessageDto;
import com.mailsender.service.MailSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/email")
public class EMailController {

    private final MailSenderService service;

    @PostMapping("/send")
    public ResponseEntity<?> sendEmail(@Valid @RequestBody EmailMessageDto messageDto){
        service.senderEmail(messageDto);
        return ResponseEntity.ok(messageDto);
    }

}
