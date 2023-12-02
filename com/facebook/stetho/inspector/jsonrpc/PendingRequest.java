package com.facebook.stetho.inspector.jsonrpc;

import javax.annotation.Nullable;

/* loaded from: classes3.dex */
public class PendingRequest {
    @Nullable
    public final PendingRequestCallback callback;
    public final long requestId;

    public PendingRequest(long j4, @Nullable PendingRequestCallback pendingRequestCallback) {
        this.requestId = j4;
        this.callback = pendingRequestCallback;
    }
}
