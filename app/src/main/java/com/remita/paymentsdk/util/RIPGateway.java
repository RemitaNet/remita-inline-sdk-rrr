package com.remita.paymentsdk.util;

public class RIPGateway {

    public interface Keys {
        String GLOBAL_CACHE_KEY = "global-cache-key";
        String MERCHANT_DETAILS = "merchant-details";
    }

    public interface Endpoint {
        String DEMO = "https://demo.remita.net";
        String PRODUCTION = "https://login.remita.net";
    }
}
