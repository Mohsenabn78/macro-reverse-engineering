package com.arlosoft.macrodroid.emailservice.sendgrid;

import androidx.annotation.NonNull;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public class SendGrid {

    /* renamed from: a  reason: collision with root package name */
    private String f11958a;

    /* renamed from: b  reason: collision with root package name */
    private d f11959b = new d();

    private SendGrid(String str) {
        this.f11958a = a(str);
    }

    private String a(String str) {
        return String.format("Bearer %s", str);
    }

    public static SendGrid create(@NonNull String str) {
        return new SendGrid(str);
    }

    public Callable<SendGridResponse> send(@NonNull SendGridMail sendGridMail) {
        return this.f11959b.b("mail/send", this.f11958a, e.a(sendGridMail));
    }
}
