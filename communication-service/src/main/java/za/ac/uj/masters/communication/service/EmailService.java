package za.ac.uj.masters.communication.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.ac.uj.masters.communication.model.EmailResponse;
import za.ac.uj.masters.communication.model.SendRequest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Component
public class EmailService {
    private final Logger log = LoggerFactory.getLogger(EmailService.class);

    public EmailResponse sendEmail(SendRequest request)  {
        log.info("sending email");
        log.info(request.getMessage());

        return new EmailResponse(false);
    }
}
