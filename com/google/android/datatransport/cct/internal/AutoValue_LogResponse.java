package com.google.android.datatransport.cct.internal;

/* loaded from: classes.dex */
final class AutoValue_LogResponse extends LogResponse {

    /* renamed from: a  reason: collision with root package name */
    private final long f18597a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_LogResponse(long j4) {
        this.f18597a = j4;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof LogResponse) && this.f18597a == ((LogResponse) obj).getNextRequestWaitMillis()) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.datatransport.cct.internal.LogResponse
    public long getNextRequestWaitMillis() {
        return this.f18597a;
    }

    public int hashCode() {
        long j4 = this.f18597a;
        return 1000003 ^ ((int) (j4 ^ (j4 >>> 32)));
    }

    public String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.f18597a + "}";
    }
}
