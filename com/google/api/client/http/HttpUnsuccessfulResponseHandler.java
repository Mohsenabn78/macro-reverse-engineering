package com.google.api.client.http;

import java.io.IOException;

/* loaded from: classes5.dex */
public interface HttpUnsuccessfulResponseHandler {
    boolean handleResponse(HttpRequest httpRequest, HttpResponse httpResponse, boolean z3) throws IOException;
}
