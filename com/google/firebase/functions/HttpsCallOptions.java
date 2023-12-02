package com.google.firebase.functions;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class HttpsCallOptions {

    /* renamed from: d  reason: collision with root package name */
    private static final TimeUnit f31382d = TimeUnit.SECONDS;

    /* renamed from: a  reason: collision with root package name */
    private long f31383a;

    /* renamed from: b  reason: collision with root package name */
    private TimeUnit f31384b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f31385c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpsCallOptions(HttpsCallableOptions httpsCallableOptions) {
        this.f31383a = 70L;
        this.f31384b = f31382d;
        this.f31385c = httpsCallableOptions.getLimitedUseAppCheckTokens();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OkHttpClient a(OkHttpClient okHttpClient) {
        return okHttpClient.newBuilder().callTimeout(this.f31383a, this.f31384b).readTimeout(this.f31383a, this.f31384b).build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return this.f31385c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long c() {
        return this.f31384b.toMillis(this.f31383a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(long j4, TimeUnit timeUnit) {
        this.f31383a = j4;
        this.f31384b = timeUnit;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpsCallOptions() {
        this.f31383a = 70L;
        this.f31384b = f31382d;
        this.f31385c = false;
    }
}
