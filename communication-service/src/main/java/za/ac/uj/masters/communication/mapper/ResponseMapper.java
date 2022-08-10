package za.ac.uj.masters.communication.mapper;

import org.springframework.stereotype.Component;
import za.ac.uj.masters.communication.model.SmsResponse;

@Component
public class ResponseMapper {
    public SmsResponse map(boolean result) {
        return new SmsResponse(result);
    }
}
