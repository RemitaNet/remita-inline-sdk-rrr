package com.remita.paymentsdk.module;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.remita.paymentsdk.R;
import com.remita.paymentsdk.core.RemitaInlinePaymentSDK;
import com.remita.paymentsdk.data.PaymentResponse;
import com.remita.paymentsdk.listener.RemitaGatewayPaymentResponseListener;
import com.remita.paymentsdk.util.JsonUtil;
import com.remita.paymentsdk.util.RIPGateway;

public class MainActivity extends AppCompatActivity implements RemitaGatewayPaymentResponseListener {

    Button btnProcessRRR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remita_activity_main);

        btnProcessRRR = findViewById(R.id.btnProcessRRR);
        btnProcessRRR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText etRRR = findViewById(R.id.etRRR);
                String enteredRRR = etRRR.getText().toString();

                String url = RIPGateway.Endpoint.DEMO;
                String api_key = "QzAwMDAxNjMwNzl8NDA4NDEyMjQ0MHw0ODZkYTZkOTE4NTVhNzMzZmIzZTM5MTU2ZDBjZDYxY2Y4MzY4ODQ1NzRkYzIyOTI2OWQzMTU1M2NlNzdkNGZkZGIyNjI1MzA1ZjZkNzkzYzM2NTE4NzUxNTI0OWVjYjAxODUyNGZmYTM3NjY3M2IwZWNjYTU3OWEwYjE5NGMyNQ==";

                String rrr = enteredRRR;

                RemitaInlinePaymentSDK remitaInlinePaymentSDK = RemitaInlinePaymentSDK.getInstance();
                remitaInlinePaymentSDK.setRemitaGatewayPaymentResponseListener(MainActivity.this);
                remitaInlinePaymentSDK.initiatePayment(MainActivity.this, url, api_key, rrr);
            }
        });
    }

    @Override
    public void onPaymentCompleted(PaymentResponse paymentResponse) {
        Log.v("+++ Response", JsonUtil.toJson(paymentResponse));
    }

    @Override
    public void onPaymentFailed(PaymentResponse paymentResponse) {
        Log.v("+++ Response", JsonUtil.toJson(paymentResponse));
    }
}
