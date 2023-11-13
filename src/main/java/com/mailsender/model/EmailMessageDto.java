package com.mailsender.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public record EmailMessageDto(
        @NotBlank String owner,
        @NotBlank @Email String from,
        @NotBlank @Email String to,
        @NotBlank String title,
        @NotBlank String message) {
}
