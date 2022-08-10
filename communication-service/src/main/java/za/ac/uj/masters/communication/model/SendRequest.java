package za.ac.uj.masters.communication.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SendRequest {

    @JsonProperty("email")
    private String email;
    @JsonProperty("mobileNumber")
    private String mobileNumber;
    @JsonProperty("deliveryType")
    private DeliveryType deliveryType;
    @JsonProperty("message")
    private String message;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
