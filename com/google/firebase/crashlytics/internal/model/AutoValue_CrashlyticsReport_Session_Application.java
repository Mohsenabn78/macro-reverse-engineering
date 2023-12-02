package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes5.dex */
final class AutoValue_CrashlyticsReport_Session_Application extends CrashlyticsReport.Session.Application {

    /* renamed from: a  reason: collision with root package name */
    private final String f29806a;

    /* renamed from: b  reason: collision with root package name */
    private final String f29807b;

    /* renamed from: c  reason: collision with root package name */
    private final String f29808c;

    /* renamed from: d  reason: collision with root package name */
    private final CrashlyticsReport.Session.Application.Organization f29809d;

    /* renamed from: e  reason: collision with root package name */
    private final String f29810e;

    /* renamed from: f  reason: collision with root package name */
    private final String f29811f;

    /* renamed from: g  reason: collision with root package name */
    private final String f29812g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class Builder extends CrashlyticsReport.Session.Application.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f29813a;

        /* renamed from: b  reason: collision with root package name */
        private String f29814b;

        /* renamed from: c  reason: collision with root package name */
        private String f29815c;

        /* renamed from: d  reason: collision with root package name */
        private CrashlyticsReport.Session.Application.Organization f29816d;

        /* renamed from: e  reason: collision with root package name */
        private String f29817e;

        /* renamed from: f  reason: collision with root package name */
        private String f29818f;

        /* renamed from: g  reason: collision with root package name */
        private String f29819g;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder
        public CrashlyticsReport.Session.Application build() {
            String str = "";
            if (this.f29813a == null) {
                str = " identifier";
            }
            if (this.f29814b == null) {
                str = str + " version";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Application(this.f29813a, this.f29814b, this.f29815c, this.f29816d, this.f29817e, this.f29818f, this.f29819g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder
        public CrashlyticsReport.Session.Application.Builder setDevelopmentPlatform(@Nullable String str) {
            this.f29818f = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder
        public CrashlyticsReport.Session.Application.Builder setDevelopmentPlatformVersion(@Nullable String str) {
            this.f29819g = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder
        public CrashlyticsReport.Session.Application.Builder setDisplayVersion(String str) {
            this.f29815c = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder
        public CrashlyticsReport.Session.Application.Builder setIdentifier(String str) {
            if (str != null) {
                this.f29813a = str;
                return this;
            }
            throw new NullPointerException("Null identifier");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder
        public CrashlyticsReport.Session.Application.Builder setInstallationUuid(String str) {
            this.f29817e = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder
        public CrashlyticsReport.Session.Application.Builder setOrganization(CrashlyticsReport.Session.Application.Organization organization) {
            this.f29816d = organization;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder
        public CrashlyticsReport.Session.Application.Builder setVersion(String str) {
            if (str != null) {
                this.f29814b = str;
                return this;
            }
            throw new NullPointerException("Null version");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder() {
        }

        private Builder(CrashlyticsReport.Session.Application application) {
            this.f29813a = application.getIdentifier();
            this.f29814b = application.getVersion();
            this.f29815c = application.getDisplayVersion();
            this.f29816d = application.getOrganization();
            this.f29817e = application.getInstallationUuid();
            this.f29818f = application.getDevelopmentPlatform();
            this.f29819g = application.getDevelopmentPlatformVersion();
        }
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application
    protected CrashlyticsReport.Session.Application.Builder a() {
        return new Builder(this);
    }

    public boolean equals(Object obj) {
        String str;
        CrashlyticsReport.Session.Application.Organization organization;
        String str2;
        String str3;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Application)) {
            return false;
        }
        CrashlyticsReport.Session.Application application = (CrashlyticsReport.Session.Application) obj;
        if (this.f29806a.equals(application.getIdentifier()) && this.f29807b.equals(application.getVersion()) && ((str = this.f29808c) != null ? str.equals(application.getDisplayVersion()) : application.getDisplayVersion() == null) && ((organization = this.f29809d) != null ? organization.equals(application.getOrganization()) : application.getOrganization() == null) && ((str2 = this.f29810e) != null ? str2.equals(application.getInstallationUuid()) : application.getInstallationUuid() == null) && ((str3 = this.f29811f) != null ? str3.equals(application.getDevelopmentPlatform()) : application.getDevelopmentPlatform() == null)) {
            String str4 = this.f29812g;
            if (str4 == null) {
                if (application.getDevelopmentPlatformVersion() == null) {
                    return true;
                }
            } else if (str4.equals(application.getDevelopmentPlatformVersion())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application
    @Nullable
    public String getDevelopmentPlatform() {
        return this.f29811f;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application
    @Nullable
    public String getDevelopmentPlatformVersion() {
        return this.f29812g;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application
    @Nullable
    public String getDisplayVersion() {
        return this.f29808c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application
    @NonNull
    public String getIdentifier() {
        return this.f29806a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application
    @Nullable
    public String getInstallationUuid() {
        return this.f29810e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application
    @Nullable
    public CrashlyticsReport.Session.Application.Organization getOrganization() {
        return this.f29809d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application
    @NonNull
    public String getVersion() {
        return this.f29807b;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5 = (((this.f29806a.hashCode() ^ 1000003) * 1000003) ^ this.f29807b.hashCode()) * 1000003;
        String str = this.f29808c;
        int i4 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i5 = (hashCode5 ^ hashCode) * 1000003;
        CrashlyticsReport.Session.Application.Organization organization = this.f29809d;
        if (organization == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = organization.hashCode();
        }
        int i6 = (i5 ^ hashCode2) * 1000003;
        String str2 = this.f29810e;
        if (str2 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str2.hashCode();
        }
        int i7 = (i6 ^ hashCode3) * 1000003;
        String str3 = this.f29811f;
        if (str3 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str3.hashCode();
        }
        int i8 = (i7 ^ hashCode4) * 1000003;
        String str4 = this.f29812g;
        if (str4 != null) {
            i4 = str4.hashCode();
        }
        return i8 ^ i4;
    }

    public String toString() {
        return "Application{identifier=" + this.f29806a + ", version=" + this.f29807b + ", displayVersion=" + this.f29808c + ", organization=" + this.f29809d + ", installationUuid=" + this.f29810e + ", developmentPlatform=" + this.f29811f + ", developmentPlatformVersion=" + this.f29812g + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Application(String str, String str2, @Nullable String str3, @Nullable CrashlyticsReport.Session.Application.Organization organization, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        this.f29806a = str;
        this.f29807b = str2;
        this.f29808c = str3;
        this.f29809d = organization;
        this.f29810e = str4;
        this.f29811f = str5;
        this.f29812g = str6;
    }
}
