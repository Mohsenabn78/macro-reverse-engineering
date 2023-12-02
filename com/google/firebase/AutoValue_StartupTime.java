package com.google.firebase;

/* loaded from: classes5.dex */
final class AutoValue_StartupTime extends StartupTime {

    /* renamed from: a  reason: collision with root package name */
    private final long f28692a;

    /* renamed from: b  reason: collision with root package name */
    private final long f28693b;

    /* renamed from: c  reason: collision with root package name */
    private final long f28694c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_StartupTime(long j4, long j5, long j6) {
        this.f28692a = j4;
        this.f28693b = j5;
        this.f28694c = j6;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StartupTime)) {
            return false;
        }
        StartupTime startupTime = (StartupTime) obj;
        if (this.f28692a == startupTime.getEpochMillis() && this.f28693b == startupTime.getElapsedRealtime() && this.f28694c == startupTime.getUptimeMillis()) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.StartupTime
    public long getElapsedRealtime() {
        return this.f28693b;
    }

    @Override // com.google.firebase.StartupTime
    public long getEpochMillis() {
        return this.f28692a;
    }

    @Override // com.google.firebase.StartupTime
    public long getUptimeMillis() {
        return this.f28694c;
    }

    public int hashCode() {
        long j4 = this.f28692a;
        long j5 = this.f28693b;
        long j6 = this.f28694c;
        return ((int) ((j6 >>> 32) ^ j6)) ^ ((((((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003);
    }

    public String toString() {
        return "StartupTime{epochMillis=" + this.f28692a + ", elapsedRealtime=" + this.f28693b + ", uptimeMillis=" + this.f28694c + "}";
    }
}
