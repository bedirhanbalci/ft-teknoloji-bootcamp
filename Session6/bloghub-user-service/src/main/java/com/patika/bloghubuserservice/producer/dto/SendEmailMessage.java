package com.patika.bloghubuserservice.producer.dto;

import com.patika.bloghubuserservice.client.email.service.dto.request.enums.EmailTemplate;
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
