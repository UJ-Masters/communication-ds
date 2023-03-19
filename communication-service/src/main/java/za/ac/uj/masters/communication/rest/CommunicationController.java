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
        ExecutorService threadPool = Executors.newCachedThreadPool();
        try {
            Future<EmailResponse> emailTask = threadPool.submit(() -> emailService.sendEmail(request));
            if(!emailTask.isDone()){
                logger.info("sms task not done");
            }
            return emailTask.get();
        } catch (ExecutionException | InterruptedException e) {
            logger.error(e.getMessage());
        }  finally {
            threadPool.shutdown();
        }
        return null;
    }

    @PostMapping("/sms")
    @ResponseBody
    public SmsResponse sendSms(@RequestBody SendRequest request) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        try {
            Future<SmsResponse> smsTask = threadPool.submit(() -> smsService.sendSms(request));
            if(!smsTask.isDone()){
                logger.info("sms task not done");
            }
            return smsTask.get();
        } catch (ExecutionException | InterruptedException e) {
            logger.error(e.getMessage());
            throw new SomethingWentWrongException(e.getMessage());
        }  finally {
            threadPool.shutdown();
        }
    }
}