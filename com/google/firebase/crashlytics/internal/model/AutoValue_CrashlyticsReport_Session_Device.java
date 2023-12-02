package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes5.dex */
final class AutoValue_CrashlyticsReport_Session_Device extends CrashlyticsReport.Session.Device {

    /* renamed from: a  reason: collision with root package name */
    private final int f29822a;

    /* renamed from: b  reason: collision with root package name */
    private final String f29823b;

    /* renamed from: c  reason: collision with root package name */
    private final int f29824c;

    /* renamed from: d  reason: collision with root package name */
    private final long f29825d;

    /* renamed from: e  reason: collision with root package name */
    private final long f29826e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f29827f;

    /* renamed from: g  reason: collision with root package name */
    private final int f29828g;

    /* renamed from: h  reason: collision with root package name */
    private final String f29829h;

    /* renamed from: i  reason: collision with root package name */
    private final String f29830i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class Builder extends CrashlyticsReport.Session.Device.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Integer f29831a;

        /* renamed from: b  reason: collision with root package name */
        private String f29832b;

        /* renamed from: c  reason: collision with root package name */
        private Integer f29833c;

        /* renamed from: d  reason: collision with root package name */
        private Long f29834d;

        /* renamed from: e  reason: collision with root package name */
        private Long f29835e;

        /* renamed from: f  reason: collision with root package name */
        private Boolean f29836f;

        /* renamed from: g  reason: collision with root package name */
        private Integer f29837g;

        /* renamed from: h  reason: collision with root package name */
        private String f29838h;

        /* renamed from: i  reason: collision with root package name */
        private String f29839i;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public CrashlyticsReport.Session.Device build() {
            String str = "";
            if (this.f29831a == null) {
                str = " arch";
            }
            if (this.f29832b == null) {
                str = str + " model";
            }
            if (this.f29833c == null) {
                str = str + " cores";
            }
            if (this.f29834d == null) {
                str = str + " ram";
            }
            if (this.f29835e == null) {
                str = str + " diskSpace";
            }
            if (this.f29836f == null) {
                str = str + " simulator";
            }
            if (this.f29837g == null) {
                str = str + " state";
            }
            if (this.f29838h == null) {
                str = str + " manufacturer";
            }
            if (this.f29839i == null) {
                str = str + " modelClass";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Device(this.f29831a.intValue(), this.f29832b, this.f29833c.intValue(), this.f29834d.longValue(), this.f29835e.longValue(), this.f29836f.booleanValue(), this.f29837g.intValue(), this.f29838h, this.f29839i);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public CrashlyticsReport.Session.Device.Builder setArch(int i4) {
            this.f29831a = Integer.valueOf(i4);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public CrashlyticsReport.Session.Device.Builder setCores(int i4) {
            this.f29833c = Integer.valueOf(i4);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public CrashlyticsReport.Session.Device.Builder setDiskSpace(long j4) {
            this.f29835e = Long.valueOf(j4);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public CrashlyticsReport.Session.Device.Builder setManufacturer(String str) {
            if (str != null) {
                this.f29838h = str;
                return this;
            }
            throw new NullPointerException("Null manufacturer");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public CrashlyticsReport.Session.Device.Builder setModel(String str) {
            if (str != null) {
                this.f29832b = str;
                return this;
            }
            throw new NullPointerException("Null model");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public CrashlyticsReport.Session.Device.Builder setModelClass(String str) {
            if (str != null) {
                this.f29839i = str;
                return this;
            }
            throw new NullPointerException("Null modelClass");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public CrashlyticsReport.Session.Device.Builder setRam(long j4) {
            this.f29834d = Long.valueOf(j4);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public CrashlyticsReport.Session.Device.Builder setSimulator(boolean z3) {
            this.f29836f = Boolean.valueOf(z3);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public CrashlyticsReport.Session.Device.Builder setState(int i4) {
            this.f29837g = Integer.valueOf(i4);
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Device)) {
            return false;
        }
        CrashlyticsReport.Session.Device device = (CrashlyticsReport.Session.Device) obj;
        if (this.f29822a == device.getArch() && this.f29823b.equals(device.getModel()) && this.f29824c == device.getCores() && this.f29825d == device.getRam() && this.f29826e == device.getDiskSpace() && this.f29827f == device.isSimulator() && this.f29828g == device.getState() && this.f29829h.equals(device.getManufacturer()) && this.f29830i.equals(device.getModelClass())) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    @NonNull
    public int getArch() {
        return this.f29822a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    public int getCores() {
        return this.f29824c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    public long getDiskSpace() {
        return this.f29826e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    @NonNull
    public String getManufacturer() {
        return this.f29829h;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    @NonNull
    public String getModel() {
        return this.f29823b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    @NonNull
    public String getModelClass() {
        return this.f29830i;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    public long getRam() {
        return this.f29825d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    public int getState() {
        return this.f29828g;
    }

    public int hashCode() {
        int i4;
        long j4 = this.f29825d;
        long j5 = this.f29826e;
        int hashCode = (((((((((this.f29822a ^ 1000003) * 1000003) ^ this.f29823b.hashCode()) * 1000003) ^ this.f29824c) * 1000003) ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003;
        if (this.f29827f) {
            i4 = 1231;
        } else {
            i4 = 1237;
        }
        return ((((((hashCode ^ i4) * 1000003) ^ this.f29828g) * 1000003) ^ this.f29829h.hashCode()) * 1000003) ^ this.f29830i.hashCode();
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    public boolean isSimulator() {
        return this.f29827f;
    }

    public String toString() {
        return "Device{arch=" + this.f29822a + ", model=" + this.f29823b + ", cores=" + this.f29824c + ", ram=" + this.f29825d + ", diskSpace=" + this.f29826e + ", simulator=" + this.f29827f + ", state=" + this.f29828g + ", manufacturer=" + this.f29829h + ", modelClass=" + this.f29830i + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Device(int i4, String str, int i5, long j4, long j5, boolean z3, int i6, String str2, String str3) {
        this.f29822a = i4;
        this.f29823b = str;
        this.f29824c = i5;
        this.f29825d = j4;
        this.f29826e = j5;
        this.f29827f = z3;
        this.f29828g = i6;
        this.f29829h = str2;
        this.f29830i = str3;
    }
}
