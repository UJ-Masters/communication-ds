package za.ac.uj.masters.communication.rest;

import com.masters.uj.communication.model.EmailResponse;
import com.masters.uj.communication.model.SendRequest;
import com.masters.uj.communication.model.SmsResponse;
import com.masters.uj.communication.service.EmailService;
import com.masters.uj.communication.service.SmsService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class CommunicationController {

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
