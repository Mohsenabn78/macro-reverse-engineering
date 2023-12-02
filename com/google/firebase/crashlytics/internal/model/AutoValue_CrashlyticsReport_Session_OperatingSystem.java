package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes5.dex */
final class AutoValue_CrashlyticsReport_Session_OperatingSystem extends CrashlyticsReport.Session.OperatingSystem {

    /* renamed from: a  reason: collision with root package name */
    private final int f29924a;

    /* renamed from: b  reason: collision with root package name */
    private final String f29925b;

    /* renamed from: c  reason: collision with root package name */
    private final String f29926c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f29927d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class Builder extends CrashlyticsReport.Session.OperatingSystem.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Integer f29928a;

        /* renamed from: b  reason: collision with root package name */
        private String f29929b;

        /* renamed from: c  reason: collision with root package name */
        private String f29930c;

        /* renamed from: d  reason: collision with root package name */
        private Boolean f29931d;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder
        public CrashlyticsReport.Session.OperatingSystem build() {
            String str = "";
            if (this.f29928a == null) {
                str = " platform";
            }
            if (this.f29929b == null) {
                str = str + " version";
            }
            if (this.f29930c == null) {
                str = str + " buildVersion";
            }
            if (this.f29931d == null) {
                str = str + " jailbroken";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_OperatingSystem(this.f29928a.intValue(), this.f29929b, this.f29930c, this.f29931d.booleanValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder
        public CrashlyticsReport.Session.OperatingSystem.Builder setBuildVersion(String str) {
            if (str != null) {
                this.f29930c = str;
                return this;
            }
            throw new NullPointerException("Null buildVersion");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder
        public CrashlyticsReport.Session.OperatingSystem.Builder setJailbroken(boolean z3) {
            this.f29931d = Boolean.valueOf(z3);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder
        public CrashlyticsReport.Session.OperatingSystem.Builder setPlatform(int i4) {
            this.f29928a = Integer.valueOf(i4);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder
        public CrashlyticsReport.Session.OperatingSystem.Builder setVersion(String str) {
            if (str != null) {
                this.f29929b = str;
                return this;
            }
            throw new NullPointerException("Null version");
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.OperatingSystem)) {
            return false;
        }
        CrashlyticsReport.Session.OperatingSystem operatingSystem = (CrashlyticsReport.Session.OperatingSystem) obj;
        if (this.f29924a == operatingSystem.getPlatform() && this.f29925b.equals(operatingSystem.getVersion()) && this.f29926c.equals(operatingSystem.getBuildVersion()) && this.f29927d == operatingSystem.isJailbroken()) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem
    @NonNull
    public String getBuildVersion() {
        return this.f29926c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem
    public int getPlatform() {
        return this.f29924a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem
    @NonNull
    public String getVersion() {
        return this.f29925b;
    }

    public int hashCode() {
        int i4;
        int hashCode = (((((this.f29924a ^ 1000003) * 1000003) ^ this.f29925b.hashCode()) * 1000003) ^ this.f29926c.hashCode()) * 1000003;
        if (this.f29927d) {
            i4 = 1231;
        } else {
            i4 = 1237;
        }
        return hashCode ^ i4;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem
    public boolean isJailbroken() {
        return this.f29927d;
    }

    public String toString() {
        return "OperatingSystem{platform=" + this.f29924a + ", version=" + this.f29925b + ", buildVersion=" + this.f29926c + ", jailbroken=" + this.f29927d + "}";
    }

    private AutoValue_CrashlyticsReport_Session_OperatingSystem(int i4, String str, String str2, boolean z3) {
        this.f29924a = i4;
        this.f29925b = str;
        this.f29926c = str2;
        this.f29927d = z3;
    }
}
