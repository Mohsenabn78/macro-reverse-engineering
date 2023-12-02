package com.google.api.client.googleapis.services;

import java.io.IOException;

/* loaded from: classes5.dex */
public class CommonGoogleClientRequestInitializer implements GoogleClientRequestInitializer {

    /* renamed from: a  reason: collision with root package name */
    private final String f25729a;

    /* renamed from: b  reason: collision with root package name */
    private final String f25730b;

    public CommonGoogleClientRequestInitializer() {
        this(null);
    }

    public final String getKey() {
        return this.f25729a;
    }

    public final String getUserIp() {
        return this.f25730b;
    }

    @Override // com.google.api.client.googleapis.services.GoogleClientRequestInitializer
    public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
        String str = this.f25729a;
        if (str != null) {
            abstractGoogleClientRequest.put("key", (Object) str);
        }
        String str2 = this.f25730b;
        if (str2 != null) {
            abstractGoogleClientRequest.put("userIp", (Object) str2);
        }
    }

    public CommonGoogleClientRequestInitializer(String str) {
        this(str, null);
    }

    public CommonGoogleClientRequestInitializer(String str, String str2) {
        this.f25729a = str;
        this.f25730b = str2;
    }
}
