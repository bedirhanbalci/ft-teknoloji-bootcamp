package com.patika.bloghubservice.dto.producer;

import com.patika.bloghubservice.client.email.service.dto.request.enums.EmailTemplate;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendEmailMessage {

    private String to;

    private EmailTemplate emailTemplate;

}
