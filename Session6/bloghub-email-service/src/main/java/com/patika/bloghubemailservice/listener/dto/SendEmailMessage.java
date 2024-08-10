package com.patika.bloghubemailservice.listener.dto;

import com.patika.bloghubemailservice.model.enums.EmailTemplate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendEmailMessage {

    private String to;

    private EmailTemplate emailTemplate;

}
