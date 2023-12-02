package com.koushikdutta.async;

/* loaded from: classes6.dex */
public class AsyncSSLException extends Exception {
    private boolean mIgnore;

    public AsyncSSLException(Throwable th) {
        super("Peer not trusted by any of the system trust managers.", th);
        this.mIgnore = false;
    }

    public boolean getIgnore() {
        return this.mIgnore;
    }

    public void setIgnore(boolean z3) {
        this.mIgnore = z3;
    }
}
