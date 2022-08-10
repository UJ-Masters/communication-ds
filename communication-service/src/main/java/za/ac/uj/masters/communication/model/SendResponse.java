package za.ac.uj.masters.communication.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class SendResponse implements Serializable {
    @JsonProperty("result")
    private boolean result;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
