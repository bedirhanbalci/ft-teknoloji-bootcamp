package com.patika.bloghubemailservice.controller;

import com.patika.bloghubemailservice.model.enums.EmailTemplate;
import com.patika.bloghubemailservice.service.EmailTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/email-templates")
@RequiredArgsConstructor
public class EmailTemplateController {

    private final EmailTemplateService emailTemplateService;

    @PostMapping("/{email-template}")
    public EmailTemplate createTemplate(@PathVariable("email-template") EmailTemplate emailTemplate,
                                        @RequestBody String templateContent) {
        return emailTemplateService.createTemplate(emailTemplate, templateContent);
    }
}
