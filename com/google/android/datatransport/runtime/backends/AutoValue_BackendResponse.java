package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.backends.BackendResponse;

/* loaded from: classes.dex */
final class AutoValue_BackendResponse extends BackendResponse {

    /* renamed from: a  reason: collision with root package name */
    private final BackendResponse.Status f18700a;

    /* renamed from: b  reason: collision with root package name */
    private final long f18701b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_BackendResponse(BackendResponse.Status status, long j4) {
        if (status != null) {
            this.f18700a = status;
            this.f18701b = j4;
            return;
        }
        throw new NullPointerException("Null status");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BackendResponse)) {
            return false;
        }
        BackendResponse backendResponse = (BackendResponse) obj;
        if (this.f18700a.equals(backendResponse.getStatus()) && this.f18701b == backendResponse.getNextRequestWaitMillis()) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendResponse
    public long getNextRequestWaitMillis() {
        return this.f18701b;
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendResponse
    public BackendResponse.Status getStatus() {
        return this.f18700a;
    }

    public int hashCode() {
        long j4 = this.f18701b;
        return ((this.f18700a.hashCode() ^ 1000003) * 1000003) ^ ((int) (j4 ^ (j4 >>> 32)));
    }

    public String toString() {
        return "BackendResponse{status=" + this.f18700a + ", nextRequestWaitMillis=" + this.f18701b + "}";
    }
}
