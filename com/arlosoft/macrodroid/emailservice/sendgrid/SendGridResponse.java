package com.arlosoft.macrodroid.emailservice.sendgrid;

import androidx.annotation.Nullable;

/* loaded from: classes3.dex */
public class SendGridResponse {

    /* renamed from: a  reason: collision with root package name */
    private final int f11973a;

    /* renamed from: b  reason: collision with root package name */
    private final String f11974b;

    /* loaded from: classes3.dex */
    static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static SendGridResponse a(int i4, String str) {
            return SendGridResponse.b(i4, com.arlosoft.macrodroid.emailservice.sendgrid.a.a(str));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static SendGridResponse b(int i4) {
            return SendGridResponse.b(i4, null);
        }
    }

    private SendGridResponse(int i4, @Nullable String str) {
        this.f11973a = i4;
        this.f11974b = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SendGridResponse b(int i4, String str) {
        return new SendGridResponse(i4, str);
    }

    public int getCode() {
        return this.f11973a;
    }

    public String getErrorMessage() {
        return this.f11974b;
    }

    public boolean isSuccessful() {
        if (this.f11974b == null) {
            return true;
        }
        return false;
    }
}
