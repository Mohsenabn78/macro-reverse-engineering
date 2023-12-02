package com.facebook.stetho.inspector;

/* loaded from: classes3.dex */
public class MismatchedResponseException extends MessageHandlingException {
    public long mRequestId;

    public MismatchedResponseException(long j4) {
        super("Response for request id " + j4 + ", but no such request is pending");
        this.mRequestId = j4;
    }

    public long getRequestId() {
        return this.mRequestId;
    }
}
