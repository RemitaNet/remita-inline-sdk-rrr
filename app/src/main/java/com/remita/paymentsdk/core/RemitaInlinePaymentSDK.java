package com.remita.paymentsdk.core;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import com.remita.paymentsdk.data.MerchantData;
import com.remita.paymentsdk.data.PaymentResponse;
import com.remita.paymentsdk.listener.RemitaGatewayPaymentResponseListener;
import com.remita.paymentsdk.module.webview.InlinePaymentActivity;
import com.remita.paymentsdk.util.RIPGateway;
import com.remita.paymentsdk.util.StringUtils;

public class RemitaInlinePaymentSDK {

    public RemitaGatewayPaymentResponseListener remitaGatewayPaymentResponseListener;

    private static RemitaInlinePaymentSDK remitaInlinePaymentSDK;

    public static RemitaInlinePaymentSDK getInstance() {
        if (remitaInlinePaymentSDK == null) {
            synchronized (RemitaInlinePaymentSDK.class) {
                remitaInlinePaymentSDK = new RemitaInlinePaymentSDK();
            }
        }
        return remitaInlinePaymentSDK;
    }

    public void setRemitaGatewayPaymentResponseListener(RemitaGatewayPaymentResponseListener remitaGatewayPaymentResponseListener) {
        this.remitaGatewayPaymentResponseListener = remitaGatewayPaymentResponseListener;
    }

    public RemitaGatewayPaymentResponseListener getRemitaGatewayPaymentResponseListener() {
        return remitaGatewayPaymentResponseListener;
    }

    public void initiatePayment(Activity activity, String url, String api_key, String rrr) {

        if (StringUtils.isEmpty(rrr)) {
            Log.e(RemitaInlinePaymentSDK.class.getName(), "Please enter an rrr");
            return;
        }
        if (Long.parseLong(rrr) <= 12) {
            Log.e(RemitaInlinePaymentSDK.class.getName(), "Invalid rrr");
            return;
        }
        RemitaInlinePaymentSDK.getInstance().getRemitaGatewayPaymentResponseListener().onPaymentCompleted(new PaymentResponse());

        MerchantData merchantData = new MerchantData.Builder()
                .rrr(rrr)
                .key(api_key)
                .url(url)
                .build();

        Intent intent = new Intent(activity, InlinePaymentActivity.class);
        intent.putExtra(RIPGateway.Keys.MERCHANT_DETAILS, merchantData);
        activity.startActivity(intent);
    }
}
