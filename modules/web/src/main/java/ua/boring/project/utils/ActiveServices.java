package ua.boring.project.utils;

public enum ActiveServices {
    PAYMENT_SERVICE("payment-service");

    private String stringValue;

    ActiveServices(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getStringValue() {
        return stringValue;
    }
}
