package com.google.api.client.http;

import com.google.api.client.util.BackOff;
import com.google.api.client.util.BackOffUtils;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Sleeper;
import java.io.IOException;

@Beta
/* loaded from: classes5.dex */
public class HttpBackOffUnsuccessfulResponseHandler implements HttpUnsuccessfulResponseHandler {

    /* renamed from: a  reason: collision with root package name */
    private final BackOff f25770a;

    /* renamed from: b  reason: collision with root package name */
    private BackOffRequired f25771b = BackOffRequired.ON_SERVER_ERROR;

    /* renamed from: c  reason: collision with root package name */
    private Sleeper f25772c = Sleeper.DEFAULT;

    @Beta
    /* loaded from: classes5.dex */
    public interface BackOffRequired {
        public static final BackOffRequired ALWAYS = new BackOffRequired() { // from class: com.google.api.client.http.HttpBackOffUnsuccessfulResponseHandler.BackOffRequired.1
            @Override // com.google.api.client.http.HttpBackOffUnsuccessfulResponseHandler.BackOffRequired
            public boolean isRequired(HttpResponse httpResponse) {
                return true;
            }
        };
        public static final BackOffRequired ON_SERVER_ERROR = new BackOffRequired() { // from class: com.google.api.client.http.HttpBackOffUnsuccessfulResponseHandler.BackOffRequired.2
            @Override // com.google.api.client.http.HttpBackOffUnsuccessfulResponseHandler.BackOffRequired
            public boolean isRequired(HttpResponse httpResponse) {
                if (httpResponse.getStatusCode() / 100 == 5) {
                    return true;
                }
                return false;
            }
        };

        boolean isRequired(HttpResponse httpResponse);
    }

    public HttpBackOffUnsuccessfulResponseHandler(BackOff backOff) {
        this.f25770a = (BackOff) Preconditions.checkNotNull(backOff);
    }

    public final BackOff getBackOff() {
        return this.f25770a;
    }

    public final BackOffRequired getBackOffRequired() {
        return this.f25771b;
    }

    public final Sleeper getSleeper() {
        return this.f25772c;
    }

    @Override // com.google.api.client.http.HttpUnsuccessfulResponseHandler
    public final boolean handleResponse(HttpRequest httpRequest, HttpResponse httpResponse, boolean z3) throws IOException {
        if (!z3 || !this.f25771b.isRequired(httpResponse)) {
            return false;
        }
        try {
            return BackOffUtils.next(this.f25772c, this.f25770a);
        } catch (InterruptedException unused) {
            return false;
        }
    }

    public HttpBackOffUnsuccessfulResponseHandler setBackOffRequired(BackOffRequired backOffRequired) {
        this.f25771b = (BackOffRequired) Preconditions.checkNotNull(backOffRequired);
        return this;
    }

    public HttpBackOffUnsuccessfulResponseHandler setSleeper(Sleeper sleeper) {
        this.f25772c = (Sleeper) Preconditions.checkNotNull(sleeper);
        return this;
    }
}
