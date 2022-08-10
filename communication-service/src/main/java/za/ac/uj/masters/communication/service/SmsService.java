package za.ac.uj.masters.communication.service;

import com.masters.uj.communication.model.SendRequest;
import com.masters.uj.communication.model.SmsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SmsService {
    private final Logger log = LoggerFactory.getLogger(SmsService.class);

    public SmsResponse sendSms(SendRequest request) {
        log.info("Sending Sms");
        return new SmsResponse(true);
    }
}
