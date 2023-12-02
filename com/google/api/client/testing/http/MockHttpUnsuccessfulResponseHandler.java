package com.google.api.client.testing.http;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpUnsuccessfulResponseHandler;
import com.google.api.client.util.Beta;
import java.io.IOException;

@Beta
/* loaded from: classes5.dex */
public class MockHttpUnsuccessfulResponseHandler implements HttpUnsuccessfulResponseHandler {

    /* renamed from: a  reason: collision with root package name */
    private boolean f26023a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f26024b;

    public MockHttpUnsuccessfulResponseHandler(boolean z3) {
        this.f26024b = z3;
    }

    @Override // com.google.api.client.http.HttpUnsuccessfulResponseHandler
    public boolean handleResponse(HttpRequest httpRequest, HttpResponse httpResponse, boolean z3) throws IOException {
        this.f26023a = true;
        return this.f26024b;
    }

    public boolean isCalled() {
        return this.f26023a;
    }
}
