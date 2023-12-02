package com.arlosoft.macrodroid.emailservice.sendgrid;

import com.arlosoft.macrodroid.emailservice.sendgrid.SendGridResponse;
import com.google.common.net.HttpHeaders;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SendGridCall.java */
/* loaded from: classes3.dex */
public class d {
    private SendGridResponse c(int i4, String str) {
        if (i4 >= 200 && i4 < 300) {
            return SendGridResponse.a.b(i4);
        }
        return SendGridResponse.a.a(i4, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ SendGridResponse d(String str, String str2, e eVar) throws Exception {
        InputStream errorStream;
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Authorization", str2);
        httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT, "application/json");
        httpURLConnection.setRequestProperty("Content-Type", "application/json; utf-8");
        OutputStream outputStream = httpURLConnection.getOutputStream();
        outputStream.write(eVar.e().toString().getBytes("UTF-8"));
        outputStream.close();
        try {
            errorStream = httpURLConnection.getInputStream();
        } catch (IOException unused) {
            errorStream = httpURLConnection.getErrorStream();
        }
        int responseCode = httpURLConnection.getResponseCode();
        String e4 = e(errorStream);
        httpURLConnection.disconnect();
        return c(responseCode, e4);
    }

    private String e(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb.append(readLine);
            } else {
                bufferedReader.close();
                return sb.toString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Callable<SendGridResponse> b(String str, final String str2, final e eVar) {
        final String format = String.format("%s%s", "https://sendgrid.com/v3/", str);
        return new Callable() { // from class: com.arlosoft.macrodroid.emailservice.sendgrid.c
            @Override // java.util.concurrent.Callable
            public final Object call() {
                SendGridResponse d4;
                d4 = d.this.d(format, str2, eVar);
                return d4;
            }
        };
    }
}
