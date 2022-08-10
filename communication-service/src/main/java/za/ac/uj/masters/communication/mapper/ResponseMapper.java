package za.ac.uj.masters.communication.mapper;

import com.masters.uj.communication.model.SmsResponse;
import org.springframework.stereotype.Component;

@Component
public class ResponseMapper {
    public SmsResponse map(boolean result) {
        return new SmsResponse(result);
    }
}
