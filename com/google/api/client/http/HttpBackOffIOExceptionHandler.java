package com.google.api.client.http;

import com.google.api.client.util.BackOff;
import com.google.api.client.util.BackOffUtils;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Sleeper;
import java.io.IOException;

@Beta
/* loaded from: classes5.dex */
public class HttpBackOffIOExceptionHandler implements HttpIOExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private final BackOff f25768a;

    /* renamed from: b  reason: collision with root package name */
    private Sleeper f25769b = Sleeper.DEFAULT;

    public HttpBackOffIOExceptionHandler(BackOff backOff) {
        this.f25768a = (BackOff) Preconditions.checkNotNull(backOff);
    }

    public final BackOff getBackOff() {
        return this.f25768a;
    }

    public final Sleeper getSleeper() {
        return this.f25769b;
    }

    @Override // com.google.api.client.http.HttpIOExceptionHandler
    public boolean handleIOException(HttpRequest httpRequest, boolean z3) throws IOException {
        if (!z3) {
            return false;
        }
        try {
            return BackOffUtils.next(this.f25769b, this.f25768a);
        } catch (InterruptedException unused) {
            return false;
        }
    }

    public HttpBackOffIOExceptionHandler setSleeper(Sleeper sleeper) {
        this.f25769b = (Sleeper) Preconditions.checkNotNull(sleeper);
        return this;
    }
}
