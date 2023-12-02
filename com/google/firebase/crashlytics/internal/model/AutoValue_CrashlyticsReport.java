package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes5.dex */
final class AutoValue_CrashlyticsReport extends CrashlyticsReport {

    /* renamed from: b  reason: collision with root package name */
    private final String f29726b;

    /* renamed from: c  reason: collision with root package name */
    private final String f29727c;

    /* renamed from: d  reason: collision with root package name */
    private final int f29728d;

    /* renamed from: e  reason: collision with root package name */
    private final String f29729e;

    /* renamed from: f  reason: collision with root package name */
    private final String f29730f;

    /* renamed from: g  reason: collision with root package name */
    private final String f29731g;

    /* renamed from: h  reason: collision with root package name */
    private final String f29732h;

    /* renamed from: i  reason: collision with root package name */
    private final CrashlyticsReport.Session f29733i;

    /* renamed from: j  reason: collision with root package name */
    private final CrashlyticsReport.FilesPayload f29734j;

    /* renamed from: k  reason: collision with root package name */
    private final CrashlyticsReport.ApplicationExitInfo f29735k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class Builder extends CrashlyticsReport.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f29736a;

        /* renamed from: b  reason: collision with root package name */
        private String f29737b;

        /* renamed from: c  reason: collision with root package name */
        private Integer f29738c;

        /* renamed from: d  reason: collision with root package name */
        private String f29739d;

        /* renamed from: e  reason: collision with root package name */
        private String f29740e;

        /* renamed from: f  reason: collision with root package name */
        private String f29741f;

        /* renamed from: g  reason: collision with root package name */
        private String f29742g;

        /* renamed from: h  reason: collision with root package name */
        private CrashlyticsReport.Session f29743h;

        /* renamed from: i  reason: collision with root package name */
        private CrashlyticsReport.FilesPayload f29744i;

        /* renamed from: j  reason: collision with root package name */
        private CrashlyticsReport.ApplicationExitInfo f29745j;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public CrashlyticsReport build() {
            String str = "";
            if (this.f29736a == null) {
                str = " sdkVersion";
            }
            if (this.f29737b == null) {
                str = str + " gmpAppId";
            }
            if (this.f29738c == null) {
                str = str + " platform";
            }
            if (this.f29739d == null) {
                str = str + " installationUuid";
            }
            if (this.f29741f == null) {
                str = str + " buildVersion";
            }
            if (this.f29742g == null) {
                str = str + " displayVersion";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport(this.f29736a, this.f29737b, this.f29738c.intValue(), this.f29739d, this.f29740e, this.f29741f, this.f29742g, this.f29743h, this.f29744i, this.f29745j);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public CrashlyticsReport.Builder setAppExitInfo(CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
            this.f29745j = applicationExitInfo;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public CrashlyticsReport.Builder setBuildVersion(String str) {
            if (str != null) {
                this.f29741f = str;
                return this;
            }
            throw new NullPointerException("Null buildVersion");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public CrashlyticsReport.Builder setDisplayVersion(String str) {
            if (str != null) {
                this.f29742g = str;
                return this;
            }
            throw new NullPointerException("Null displayVersion");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public CrashlyticsReport.Builder setFirebaseInstallationId(@Nullable String str) {
            this.f29740e = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public CrashlyticsReport.Builder setGmpAppId(String str) {
            if (str != null) {
                this.f29737b = str;
                return this;
            }
            throw new NullPointerException("Null gmpAppId");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public CrashlyticsReport.Builder setInstallationUuid(String str) {
            if (str != null) {
                this.f29739d = str;
                return this;
            }
            throw new NullPointerException("Null installationUuid");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public CrashlyticsReport.Builder setNdkPayload(CrashlyticsReport.FilesPayload filesPayload) {
            this.f29744i = filesPayload;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public CrashlyticsReport.Builder setPlatform(int i4) {
            this.f29738c = Integer.valueOf(i4);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public CrashlyticsReport.Builder setSdkVersion(String str) {
            if (str != null) {
                this.f29736a = str;
                return this;
            }
            throw new NullPointerException("Null sdkVersion");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public CrashlyticsReport.Builder setSession(CrashlyticsReport.Session session) {
            this.f29743h = session;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder() {
        }

        private Builder(CrashlyticsReport crashlyticsReport) {
            this.f29736a = crashlyticsReport.getSdkVersion();
            this.f29737b = crashlyticsReport.getGmpAppId();
            this.f29738c = Integer.valueOf(crashlyticsReport.getPlatform());
            this.f29739d = crashlyticsReport.getInstallationUuid();
            this.f29740e = crashlyticsReport.getFirebaseInstallationId();
            this.f29741f = crashlyticsReport.getBuildVersion();
            this.f29742g = crashlyticsReport.getDisplayVersion();
            this.f29743h = crashlyticsReport.getSession();
            this.f29744i = crashlyticsReport.getNdkPayload();
            this.f29745j = crashlyticsReport.getAppExitInfo();
        }
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    protected CrashlyticsReport.Builder b() {
        return new Builder(this);
    }

    public boolean equals(Object obj) {
        String str;
        CrashlyticsReport.Session session;
        CrashlyticsReport.FilesPayload filesPayload;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport)) {
            return false;
        }
        CrashlyticsReport crashlyticsReport = (CrashlyticsReport) obj;
        if (this.f29726b.equals(crashlyticsReport.getSdkVersion()) && this.f29727c.equals(crashlyticsReport.getGmpAppId()) && this.f29728d == crashlyticsReport.getPlatform() && this.f29729e.equals(crashlyticsReport.getInstallationUuid()) && ((str = this.f29730f) != null ? str.equals(crashlyticsReport.getFirebaseInstallationId()) : crashlyticsReport.getFirebaseInstallationId() == null) && this.f29731g.equals(crashlyticsReport.getBuildVersion()) && this.f29732h.equals(crashlyticsReport.getDisplayVersion()) && ((session = this.f29733i) != null ? session.equals(crashlyticsReport.getSession()) : crashlyticsReport.getSession() == null) && ((filesPayload = this.f29734j) != null ? filesPayload.equals(crashlyticsReport.getNdkPayload()) : crashlyticsReport.getNdkPayload() == null)) {
            CrashlyticsReport.ApplicationExitInfo applicationExitInfo = this.f29735k;
            if (applicationExitInfo == null) {
                if (crashlyticsReport.getAppExitInfo() == null) {
                    return true;
                }
            } else if (applicationExitInfo.equals(crashlyticsReport.getAppExitInfo())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    @Nullable
    public CrashlyticsReport.ApplicationExitInfo getAppExitInfo() {
        return this.f29735k;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    @NonNull
    public String getBuildVersion() {
        return this.f29731g;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    @NonNull
    public String getDisplayVersion() {
        return this.f29732h;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    @Nullable
    public String getFirebaseInstallationId() {
        return this.f29730f;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    @NonNull
    public String getGmpAppId() {
        return this.f29727c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    @NonNull
    public String getInstallationUuid() {
        return this.f29729e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    @Nullable
    public CrashlyticsReport.FilesPayload getNdkPayload() {
        return this.f29734j;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public int getPlatform() {
        return this.f29728d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    @NonNull
    public String getSdkVersion() {
        return this.f29726b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    @Nullable
    public CrashlyticsReport.Session getSession() {
        return this.f29733i;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4 = (((((((this.f29726b.hashCode() ^ 1000003) * 1000003) ^ this.f29727c.hashCode()) * 1000003) ^ this.f29728d) * 1000003) ^ this.f29729e.hashCode()) * 1000003;
        String str = this.f29730f;
        int i4 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int hashCode5 = (((((hashCode4 ^ hashCode) * 1000003) ^ this.f29731g.hashCode()) * 1000003) ^ this.f29732h.hashCode()) * 1000003;
        CrashlyticsReport.Session session = this.f29733i;
        if (session == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = session.hashCode();
        }
        int i5 = (hashCode5 ^ hashCode2) * 1000003;
        CrashlyticsReport.FilesPayload filesPayload = this.f29734j;
        if (filesPayload == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = filesPayload.hashCode();
        }
        int i6 = (i5 ^ hashCode3) * 1000003;
        CrashlyticsReport.ApplicationExitInfo applicationExitInfo = this.f29735k;
        if (applicationExitInfo != null) {
            i4 = applicationExitInfo.hashCode();
        }
        return i6 ^ i4;
    }

    public String toString() {
        return "CrashlyticsReport{sdkVersion=" + this.f29726b + ", gmpAppId=" + this.f29727c + ", platform=" + this.f29728d + ", installationUuid=" + this.f29729e + ", firebaseInstallationId=" + this.f29730f + ", buildVersion=" + this.f29731g + ", displayVersion=" + this.f29732h + ", session=" + this.f29733i + ", ndkPayload=" + this.f29734j + ", appExitInfo=" + this.f29735k + "}";
    }

    private AutoValue_CrashlyticsReport(String str, String str2, int i4, String str3, @Nullable String str4, String str5, String str6, @Nullable CrashlyticsReport.Session session, @Nullable CrashlyticsReport.FilesPayload filesPayload, @Nullable CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
        this.f29726b = str;
        this.f29727c = str2;
        this.f29728d = i4;
        this.f29729e = str3;
        this.f29730f = str4;
        this.f29731g = str5;
        this.f29732h = str6;
        this.f29733i = session;
        this.f29734j = filesPayload;
        this.f29735k = applicationExitInfo;
    }
}
