package za.ac.uj.masters.communication.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SmsRequest {
    @JsonProperty("to")
    private String to;

    @JsonProperty("message")
    private String message;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
