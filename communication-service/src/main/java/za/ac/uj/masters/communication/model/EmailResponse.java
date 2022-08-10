package za.ac.uj.masters.communication.model;

import java.io.Serializable;

public class EmailResponse extends SendResponse implements Serializable {
    public EmailResponse(boolean result) {
        this.setResult(result);
    }
}
