package com.mailsender.model;

import lombok.Data;

@Data
public class EmailMessage {

    private String owner;
    private String from;
    private String to;
    private String title;
    private String message;

}
