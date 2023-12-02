package com.arlosoft.macrodroid.emailservice.sendgrid;

import android.os.AsyncTask;
import com.arlosoft.macrodroid.emailservice.sendgrid.SendGridResponse;

/* loaded from: classes3.dex */
public class SendTask extends AsyncTask<Void, Void, SendGridResponse> {

    /* renamed from: a  reason: collision with root package name */
    private final SendGrid f11975a;

    /* renamed from: b  reason: collision with root package name */
    private final SendGridMail f11976b;

    public SendTask(SendGrid sendGrid, SendGridMail sendGridMail) {
        this.f11975a = sendGrid;
        this.f11976b = sendGridMail;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public SendGridResponse doInBackground(Void... voidArr) {
        try {
            return this.f11975a.send(this.f11976b).call();
        } catch (Exception e4) {
            e4.printStackTrace();
            return SendGridResponse.a.a(0, e4.getMessage());
        }
    }
}
