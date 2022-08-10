package com.masters.uj.communication.service;

import com.masters.uj.communication.model.EmailResponse;
import com.masters.uj.communication.model.SendRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class EmailService {
    private final Logger log = LoggerFactory.getLogger(EmailService.class);

    public EmailResponse sendEmail(SendRequest request) {
        log.info("sending email");
        log.info(request.getMessage());
        return new EmailResponse(false);
    }
}
