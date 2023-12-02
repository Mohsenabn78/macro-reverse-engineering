package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.StaticSessionData;

/* loaded from: classes5.dex */
final class AutoValue_StaticSessionData_DeviceData extends StaticSessionData.DeviceData {

    /* renamed from: a  reason: collision with root package name */
    private final int f29943a;

    /* renamed from: b  reason: collision with root package name */
    private final String f29944b;

    /* renamed from: c  reason: collision with root package name */
    private final int f29945c;

    /* renamed from: d  reason: collision with root package name */
    private final long f29946d;

    /* renamed from: e  reason: collision with root package name */
    private final long f29947e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f29948f;

    /* renamed from: g  reason: collision with root package name */
    private final int f29949g;

    /* renamed from: h  reason: collision with root package name */
    private final String f29950h;

    /* renamed from: i  reason: collision with root package name */
    private final String f29951i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_StaticSessionData_DeviceData(int i4, String str, int i5, long j4, long j5, boolean z3, int i6, String str2, String str3) {
        this.f29943a = i4;
        if (str != null) {
            this.f29944b = str;
            this.f29945c = i5;
            this.f29946d = j4;
            this.f29947e = j5;
            this.f29948f = z3;
            this.f29949g = i6;
            if (str2 != null) {
                this.f29950h = str2;
                if (str3 != null) {
                    this.f29951i = str3;
                    return;
                }
                throw new NullPointerException("Null modelClass");
            }
            throw new NullPointerException("Null manufacturer");
        }
        throw new NullPointerException("Null model");
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public int arch() {
        return this.f29943a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public int availableProcessors() {
        return this.f29945c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public long diskSpace() {
        return this.f29947e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StaticSessionData.DeviceData)) {
            return false;
        }
        StaticSessionData.DeviceData deviceData = (StaticSessionData.DeviceData) obj;
        if (this.f29943a == deviceData.arch() && this.f29944b.equals(deviceData.model()) && this.f29945c == deviceData.availableProcessors() && this.f29946d == deviceData.totalRam() && this.f29947e == deviceData.diskSpace() && this.f29948f == deviceData.isEmulator() && this.f29949g == deviceData.state() && this.f29950h.equals(deviceData.manufacturer()) && this.f29951i.equals(deviceData.modelClass())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i4;
        long j4 = this.f29946d;
        long j5 = this.f29947e;
        int hashCode = (((((((((this.f29943a ^ 1000003) * 1000003) ^ this.f29944b.hashCode()) * 1000003) ^ this.f29945c) * 1000003) ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003;
        if (this.f29948f) {
            i4 = 1231;
        } else {
            i4 = 1237;
        }
        return ((((((hashCode ^ i4) * 1000003) ^ this.f29949g) * 1000003) ^ this.f29950h.hashCode()) * 1000003) ^ this.f29951i.hashCode();
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public boolean isEmulator() {
        return this.f29948f;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public String manufacturer() {
        return this.f29950h;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public String model() {
        return this.f29944b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public String modelClass() {
        return this.f29951i;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public int state() {
        return this.f29949g;
    }

    public String toString() {
        return "DeviceData{arch=" + this.f29943a + ", model=" + this.f29944b + ", availableProcessors=" + this.f29945c + ", totalRam=" + this.f29946d + ", diskSpace=" + this.f29947e + ", isEmulator=" + this.f29948f + ", state=" + this.f29949g + ", manufacturer=" + this.f29950h + ", modelClass=" + this.f29951i + "}";
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public long totalRam() {
        return this.f29946d;
    }
}
