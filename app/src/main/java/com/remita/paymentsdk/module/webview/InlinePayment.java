package com.remita.paymentsdk.module.webview;

public class InlinePayment {
    public static String initRequest(String url, String key, String rrr) {

        String script ="<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n"
                + "<header><meta name=\"viewport\" content=\"initial-scale=1.0\"/>" +
                "</header>" +
                "<body  onload=\"makePayment()\">\n" +
                "    <script>\n" +
                "       function makePayment() {\n" +
                "       var paymentEngine = RmPaymentEngine.init({\n" +
                "\t\t\t\tkey:'" + key + "',\n" +
                "                \"processRrr\": \"" + true + "\",\n" +
                "\t\t\t\t\textendedData:" + "{ \n" +
                "\t\t\t\tcustomFields: [ \n" +
                "\t\t\t\t\t{ \n" +
                "\t\t\t\t\t\tname: \"rrr\", \n" +
                "\t\t\t\t\t\tvalue:'" + rrr + "'\n" +
                "\t\t\t\t\t} \n" +
                "\t\t\t\t ]\n" +
                "\t\t\t}" + ",\n" +
                "                    onSuccess: function (response) {\n" +
                "                        console.log(JSON.stringify(response));\n" +
                "                    },\n" +
                "                    onError: function (response) {\n" +
                "                        console.log(JSON.stringify(response));\n" +
                "                    },\n" +
                "                    onClose: function () {\n" +
                "                        console.log(\"onClose\");\n" +
                "                    },                 \n" +
                "                });\n" +
                "                paymentEngine.openIframe();\n" +
                "        }\n" +
                "    </script>\n" +
                "   \n" + "<script type=\"text/javascript\" src=\"" + url + "/payment/v1/remita-pay-inline.bundle.js\"></script>\n" +

                "</body>\n" +
                "\n" +
                "</html>\n";
        return script;
    }
}
