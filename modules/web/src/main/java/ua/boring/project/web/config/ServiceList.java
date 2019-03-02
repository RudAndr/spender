package ua.boring.project.web.config;

public enum ServiceList {

    PAYMENT_SERVICE("payment-service"),
    RATE_SERVICE("currency-service");

    private String serviceName = "http://";

    ServiceList(String serviceName) {
        this.serviceName += serviceName;
    }

    public String getServiceName() {
        return serviceName;
    }
}
