package com.sun.mail.iap;

/* loaded from: classes6.dex */
public class ProtocolException extends Exception {
    private static final long serialVersionUID = -4360500807971797439L;

    /* renamed from: a  reason: collision with root package name */
    protected transient Response f37616a;

    public ProtocolException() {
        this.f37616a = null;
    }

    public Response getResponse() {
        return this.f37616a;
    }

    public ProtocolException(String str) {
        super(str);
        this.f37616a = null;
    }

    public ProtocolException(String str, Throwable th) {
        super(str, th);
        this.f37616a = null;
    }

    public ProtocolException(Response response) {
        super(response.toString());
        this.f37616a = response;
    }
}
