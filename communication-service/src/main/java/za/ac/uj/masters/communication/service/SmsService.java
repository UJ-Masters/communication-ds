package za.ac.uj.masters.communication.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.ac.uj.masters.communication.model.SendRequest;
import za.ac.uj.masters.communication.model.SmsResponse;

@Component
public class SmsService {
    private final Logger log = LoggerFactory.getLogger(SmsService.class);

    public SmsResponse sendSms(SendRequest request) {
        log.info("Sending Sms");
        return new SmsResponse(true);
    }
}
