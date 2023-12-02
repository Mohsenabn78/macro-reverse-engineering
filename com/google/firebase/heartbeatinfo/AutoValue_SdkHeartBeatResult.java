package com.google.firebase.heartbeatinfo;

/* loaded from: classes5.dex */
final class AutoValue_SdkHeartBeatResult extends SdkHeartBeatResult {

    /* renamed from: a  reason: collision with root package name */
    private final String f31424a;

    /* renamed from: b  reason: collision with root package name */
    private final long f31425b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_SdkHeartBeatResult(String str, long j4) {
        if (str != null) {
            this.f31424a = str;
            this.f31425b = j4;
            return;
        }
        throw new NullPointerException("Null sdkName");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SdkHeartBeatResult)) {
            return false;
        }
        SdkHeartBeatResult sdkHeartBeatResult = (SdkHeartBeatResult) obj;
        if (this.f31424a.equals(sdkHeartBeatResult.getSdkName()) && this.f31425b == sdkHeartBeatResult.getMillis()) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.heartbeatinfo.SdkHeartBeatResult
    public long getMillis() {
        return this.f31425b;
    }

    @Override // com.google.firebase.heartbeatinfo.SdkHeartBeatResult
    public String getSdkName() {
        return this.f31424a;
    }

    public int hashCode() {
        long j4 = this.f31425b;
        return ((this.f31424a.hashCode() ^ 1000003) * 1000003) ^ ((int) (j4 ^ (j4 >>> 32)));
    }

    public String toString() {
        return "SdkHeartBeatResult{sdkName=" + this.f31424a + ", millis=" + this.f31425b + "}";
    }
}
