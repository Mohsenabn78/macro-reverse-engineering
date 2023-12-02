package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes5.dex */
final class AutoValue_CrashlyticsReport_Session_Event_Device extends CrashlyticsReport.Session.Event.Device {

    /* renamed from: a  reason: collision with root package name */
    private final Double f29910a;

    /* renamed from: b  reason: collision with root package name */
    private final int f29911b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f29912c;

    /* renamed from: d  reason: collision with root package name */
    private final int f29913d;

    /* renamed from: e  reason: collision with root package name */
    private final long f29914e;

    /* renamed from: f  reason: collision with root package name */
    private final long f29915f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class Builder extends CrashlyticsReport.Session.Event.Device.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Double f29916a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f29917b;

        /* renamed from: c  reason: collision with root package name */
        private Boolean f29918c;

        /* renamed from: d  reason: collision with root package name */
        private Integer f29919d;

        /* renamed from: e  reason: collision with root package name */
        private Long f29920e;

        /* renamed from: f  reason: collision with root package name */
        private Long f29921f;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder
        public CrashlyticsReport.Session.Event.Device build() {
            String str = "";
            if (this.f29917b == null) {
                str = " batteryVelocity";
            }
            if (this.f29918c == null) {
                str = str + " proximityOn";
            }
            if (this.f29919d == null) {
                str = str + " orientation";
            }
            if (this.f29920e == null) {
                str = str + " ramUsed";
            }
            if (this.f29921f == null) {
                str = str + " diskUsed";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Event_Device(this.f29916a, this.f29917b.intValue(), this.f29918c.booleanValue(), this.f29919d.intValue(), this.f29920e.longValue(), this.f29921f.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder
        public CrashlyticsReport.Session.Event.Device.Builder setBatteryLevel(Double d4) {
            this.f29916a = d4;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder
        public CrashlyticsReport.Session.Event.Device.Builder setBatteryVelocity(int i4) {
            this.f29917b = Integer.valueOf(i4);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder
        public CrashlyticsReport.Session.Event.Device.Builder setDiskUsed(long j4) {
            this.f29921f = Long.valueOf(j4);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder
        public CrashlyticsReport.Session.Event.Device.Builder setOrientation(int i4) {
            this.f29919d = Integer.valueOf(i4);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder
        public CrashlyticsReport.Session.Event.Device.Builder setProximityOn(boolean z3) {
            this.f29918c = Boolean.valueOf(z3);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder
        public CrashlyticsReport.Session.Event.Device.Builder setRamUsed(long j4) {
            this.f29920e = Long.valueOf(j4);
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Device)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Device device = (CrashlyticsReport.Session.Event.Device) obj;
        Double d4 = this.f29910a;
        if (d4 != null ? d4.equals(device.getBatteryLevel()) : device.getBatteryLevel() == null) {
            if (this.f29911b == device.getBatteryVelocity() && this.f29912c == device.isProximityOn() && this.f29913d == device.getOrientation() && this.f29914e == device.getRamUsed() && this.f29915f == device.getDiskUsed()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device
    @Nullable
    public Double getBatteryLevel() {
        return this.f29910a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device
    public int getBatteryVelocity() {
        return this.f29911b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device
    public long getDiskUsed() {
        return this.f29915f;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device
    public int getOrientation() {
        return this.f29913d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device
    public long getRamUsed() {
        return this.f29914e;
    }

    public int hashCode() {
        int hashCode;
        int i4;
        Double d4 = this.f29910a;
        if (d4 == null) {
            hashCode = 0;
        } else {
            hashCode = d4.hashCode();
        }
        int i5 = (((hashCode ^ 1000003) * 1000003) ^ this.f29911b) * 1000003;
        if (this.f29912c) {
            i4 = 1231;
        } else {
            i4 = 1237;
        }
        long j4 = this.f29914e;
        long j5 = this.f29915f;
        return ((((((i5 ^ i4) * 1000003) ^ this.f29913d) * 1000003) ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)));
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device
    public boolean isProximityOn() {
        return this.f29912c;
    }

    public String toString() {
        return "Device{batteryLevel=" + this.f29910a + ", batteryVelocity=" + this.f29911b + ", proximityOn=" + this.f29912c + ", orientation=" + this.f29913d + ", ramUsed=" + this.f29914e + ", diskUsed=" + this.f29915f + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Event_Device(@Nullable Double d4, int i4, boolean z3, int i5, long j4, long j5) {
        this.f29910a = d4;
        this.f29911b = i4;
        this.f29912c = z3;
        this.f29913d = i5;
        this.f29914e = j4;
        this.f29915f = j5;
    }
}
