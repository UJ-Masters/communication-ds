package za.ac.uj.masters.communication.model;

import java.io.Serializable;

public class SmsResponse extends SendResponse implements Serializable {
    public SmsResponse(boolean result) {
        setResult(result);
    }
}
