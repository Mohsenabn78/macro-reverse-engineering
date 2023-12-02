package com.sun.mail.iap;

/* loaded from: classes6.dex */
public class ConnectionException extends ProtocolException {
    private static final long serialVersionUID = 5749739604257464727L;

    /* renamed from: b  reason: collision with root package name */
    private transient Protocol f37597b;

    public ConnectionException() {
    }

    public Protocol getProtocol() {
        return this.f37597b;
    }

    public ConnectionException(String str) {
        super(str);
    }

    public ConnectionException(Protocol protocol, Response response) {
        super(response);
        this.f37597b = protocol;
    }
}
