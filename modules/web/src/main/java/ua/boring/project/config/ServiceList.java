package ua.boring.project.config;

public enum ServiceList {

    PAYMENT_SERVICE("payment-service"),
    RATE_SERVICE("rate-service");

    private String serviceName;

    ServiceList(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceName() {
        return serviceName;
    }
}
