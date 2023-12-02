package com.google.firebase.functions;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public class HttpsCallableReference {

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseFunctions f31391a;

    /* renamed from: b  reason: collision with root package name */
    private final String f31392b;

    /* renamed from: c  reason: collision with root package name */
    private final URL f31393c;

    /* renamed from: d  reason: collision with root package name */
    final HttpsCallOptions f31394d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpsCallableReference(FirebaseFunctions firebaseFunctions, String str, HttpsCallOptions httpsCallOptions) {
        this.f31391a = firebaseFunctions;
        this.f31392b = str;
        this.f31393c = null;
        this.f31394d = httpsCallOptions;
    }

    @NonNull
    public Task<HttpsCallableResult> call(@Nullable Object obj) {
        String str = this.f31392b;
        if (str != null) {
            return this.f31391a.h(str, obj, this.f31394d);
        }
        return this.f31391a.i(this.f31393c, obj, this.f31394d);
    }

    public long getTimeout() {
        return this.f31394d.c();
    }

    public void setTimeout(long j4, @NonNull TimeUnit timeUnit) {
        this.f31394d.d(j4, timeUnit);
    }

    @NonNull
    public HttpsCallableReference withTimeout(long j4, @NonNull TimeUnit timeUnit) {
        HttpsCallableReference httpsCallableReference = new HttpsCallableReference(this.f31391a, this.f31392b, this.f31394d);
        httpsCallableReference.setTimeout(j4, timeUnit);
        return httpsCallableReference;
    }

    @NonNull
    public Task<HttpsCallableResult> call() {
        String str = this.f31392b;
        if (str != null) {
            return this.f31391a.h(str, null, this.f31394d);
        }
        return this.f31391a.i(this.f31393c, null, this.f31394d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpsCallableReference(FirebaseFunctions firebaseFunctions, URL url, HttpsCallOptions httpsCallOptions) {
        this.f31391a = firebaseFunctions;
        this.f31392b = null;
        this.f31393c = url;
        this.f31394d = httpsCallOptions;
    }
}
