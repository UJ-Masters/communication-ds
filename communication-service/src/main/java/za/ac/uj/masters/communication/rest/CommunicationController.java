package za.ac.uj.masters.communication.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import za.ac.uj.masters.communication.exception.SomethingWentWrongException;
import za.ac.uj.masters.communication.model.EmailResponse;
import za.ac.uj.masters.communication.model.SendRequest;
import za.ac.uj.masters.communication.model.SmsResponse;
import za.ac.uj.masters.communication.service.EmailService;
import za.ac.uj.masters.communication.service.SmsService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@RestController
@CrossOrigin("*")
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class CommunicationController {

    private Logger logger = LoggerFactory.getLogger(CommunicationController.class);

    private final EmailService emailService;
    private final SmsService smsService;

    public CommunicationController(final EmailService emailService,
                                   final SmsService smsService) {
        this.emailService = emailService;
        this.smsService = smsService;
    }

    @PostMapping("/email")
    @ResponseBody
    public EmailResponse sendEmail(@RequestBody SendRequest request) {
        return emailService.sendEmail(request);
    }

    @PostMapping("/sms")
    @ResponseBody
    public SmsResponse sendSms(@RequestBody SendRequest request) {
        return smsService.sendSms(request);
    }
}
