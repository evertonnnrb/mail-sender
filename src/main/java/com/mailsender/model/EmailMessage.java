package com.mailsender.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EmailMessage {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String owner;

    @Column(name = "_from")
    private String from;

    @Column(name = "_to")
    private String to;
    private String title;

    @Column(columnDefinition = "TEXT")
    private String message;

    @Column(name = "mail_send")
    private boolean send;
    private LocalDate sendDate;

    public EmailMessage(EmailMessageDto dto) {
        this.owner = dto.owner();
        this.from = dto.from();
        this.to = dto.to();
        this.title = dto.title();
        this.message = dto.message();
    }
}
