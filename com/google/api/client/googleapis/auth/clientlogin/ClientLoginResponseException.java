package com.google.api.client.googleapis.auth.clientlogin;

import com.google.api.client.googleapis.auth.clientlogin.ClientLogin;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.util.Beta;

@Beta
/* loaded from: classes5.dex */
public class ClientLoginResponseException extends HttpResponseException {
    private static final long serialVersionUID = 4974317674023010928L;

    /* renamed from: b  reason: collision with root package name */
    private final transient ClientLogin.ErrorInfo f25554b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ClientLoginResponseException(HttpResponseException.Builder builder, ClientLogin.ErrorInfo errorInfo) {
        super(builder);
        this.f25554b = errorInfo;
    }

    public final ClientLogin.ErrorInfo getDetails() {
        return this.f25554b;
    }
}
