package com.google.firebase.heartbeatinfo;

import java.util.List;

/* loaded from: classes5.dex */
final class AutoValue_HeartBeatResult extends HeartBeatResult {

    /* renamed from: a  reason: collision with root package name */
    private final String f31422a;

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f31423b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_HeartBeatResult(String str, List<String> list) {
        if (str != null) {
            this.f31422a = str;
            if (list != null) {
                this.f31423b = list;
                return;
            }
            throw new NullPointerException("Null usedDates");
        }
        throw new NullPointerException("Null userAgent");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HeartBeatResult)) {
            return false;
        }
        HeartBeatResult heartBeatResult = (HeartBeatResult) obj;
        if (this.f31422a.equals(heartBeatResult.getUserAgent()) && this.f31423b.equals(heartBeatResult.getUsedDates())) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatResult
    public List<String> getUsedDates() {
        return this.f31423b;
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatResult
    public String getUserAgent() {
        return this.f31422a;
    }

    public int hashCode() {
        return ((this.f31422a.hashCode() ^ 1000003) * 1000003) ^ this.f31423b.hashCode();
    }

    public String toString() {
        return "HeartBeatResult{userAgent=" + this.f31422a + ", usedDates=" + this.f31423b + "}";
    }
}
