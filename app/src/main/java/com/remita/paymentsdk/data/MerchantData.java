package com.remita.paymentsdk.data;

import java.io.Serializable;

public class MerchantData implements Serializable {
    private final String key;
    private final String url;
    private final String rrr;
    ;

    public static class Builder {
        private String key;
        private String url;
        private String rrr;

        public Builder() {
        }

        public Builder key(String key) {
            this.key = key;
            return this;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder rrr(String rrr) {
            this.rrr = rrr;
            return this;
        }

        public MerchantData build() {
            return new MerchantData(this);
        }
    }

    private MerchantData(Builder builder) {
        key = builder.key;
        url = builder.url;
        rrr = builder.rrr;
    }

    public String getKey() {
        return key;
    }

    public String getUrl() {
        return url;
    }

    public String getRRR() {
        return rrr;
    }


    @Override
    public String toString() {
        return "MerchantData{" +
                "key='" + key + '\'' +
                "url='" + url + '\'' +
                ", rrr='" + rrr + '\'' +
                '}';
    }
}
