package com.sun.mail.iap;

/* loaded from: classes6.dex */
public class LiteralException extends ProtocolException {
    private static final long serialVersionUID = -6919179828339609913L;

    public LiteralException(Response response) {
        super(response.toString());
        this.f37616a = response;
    }
}
