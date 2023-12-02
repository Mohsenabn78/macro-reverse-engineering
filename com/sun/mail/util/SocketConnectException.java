package com.sun.mail.util;

import java.io.IOException;

/* loaded from: classes6.dex */
public class SocketConnectException extends IOException {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long serialVersionUID = 3997871560538755463L;
    private int cto;
    private String host;
    private int port;

    public SocketConnectException(String str, Exception exc, String str2, int i4, int i5) {
        super(str);
        initCause(exc);
        this.host = str2;
        this.port = i4;
        this.cto = i5;
    }

    public int getConnectionTimeout() {
        return this.cto;
    }

    public Exception getException() {
        return (Exception) getCause();
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        return this.port;
    }
}
