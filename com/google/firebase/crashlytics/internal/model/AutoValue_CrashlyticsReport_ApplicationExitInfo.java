package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes5.dex */
final class AutoValue_CrashlyticsReport_ApplicationExitInfo extends CrashlyticsReport.ApplicationExitInfo {

    /* renamed from: a  reason: collision with root package name */
    private final int f29746a;

    /* renamed from: b  reason: collision with root package name */
    private final String f29747b;

    /* renamed from: c  reason: collision with root package name */
    private final int f29748c;

    /* renamed from: d  reason: collision with root package name */
    private final int f29749d;

    /* renamed from: e  reason: collision with root package name */
    private final long f29750e;

    /* renamed from: f  reason: collision with root package name */
    private final long f29751f;

    /* renamed from: g  reason: collision with root package name */
    private final long f29752g;

    /* renamed from: h  reason: collision with root package name */
    private final String f29753h;

    /* renamed from: i  reason: collision with root package name */
    private final ImmutableList<CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch> f29754i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class Builder extends CrashlyticsReport.ApplicationExitInfo.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Integer f29755a;

        /* renamed from: b  reason: collision with root package name */
        private String f29756b;

        /* renamed from: c  reason: collision with root package name */
        private Integer f29757c;

        /* renamed from: d  reason: collision with root package name */
        private Integer f29758d;

        /* renamed from: e  reason: collision with root package name */
        private Long f29759e;

        /* renamed from: f  reason: collision with root package name */
        private Long f29760f;

        /* renamed from: g  reason: collision with root package name */
        private Long f29761g;

        /* renamed from: h  reason: collision with root package name */
        private String f29762h;

        /* renamed from: i  reason: collision with root package name */
        private ImmutableList<CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch> f29763i;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public CrashlyticsReport.ApplicationExitInfo build() {
            String str = "";
            if (this.f29755a == null) {
                str = " pid";
            }
            if (this.f29756b == null) {
                str = str + " processName";
            }
            if (this.f29757c == null) {
                str = str + " reasonCode";
            }
            if (this.f29758d == null) {
                str = str + " importance";
            }
            if (this.f29759e == null) {
                str = str + " pss";
            }
            if (this.f29760f == null) {
                str = str + " rss";
            }
            if (this.f29761g == null) {
                str = str + " timestamp";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_ApplicationExitInfo(this.f29755a.intValue(), this.f29756b, this.f29757c.intValue(), this.f29758d.intValue(), this.f29759e.longValue(), this.f29760f.longValue(), this.f29761g.longValue(), this.f29762h, this.f29763i);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public CrashlyticsReport.ApplicationExitInfo.Builder setBuildIdMappingForArch(@Nullable ImmutableList<CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch> immutableList) {
            this.f29763i = immutableList;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public CrashlyticsReport.ApplicationExitInfo.Builder setImportance(int i4) {
            this.f29758d = Integer.valueOf(i4);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public CrashlyticsReport.ApplicationExitInfo.Builder setPid(int i4) {
            this.f29755a = Integer.valueOf(i4);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public CrashlyticsReport.ApplicationExitInfo.Builder setProcessName(String str) {
            if (str != null) {
                this.f29756b = str;
                return this;
            }
            throw new NullPointerException("Null processName");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public CrashlyticsReport.ApplicationExitInfo.Builder setPss(long j4) {
            this.f29759e = Long.valueOf(j4);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public CrashlyticsReport.ApplicationExitInfo.Builder setReasonCode(int i4) {
            this.f29757c = Integer.valueOf(i4);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public CrashlyticsReport.ApplicationExitInfo.Builder setRss(long j4) {
            this.f29760f = Long.valueOf(j4);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public CrashlyticsReport.ApplicationExitInfo.Builder setTimestamp(long j4) {
            this.f29761g = Long.valueOf(j4);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public CrashlyticsReport.ApplicationExitInfo.Builder setTraceFile(@Nullable String str) {
            this.f29762h = str;
            return this;
        }
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.ApplicationExitInfo)) {
            return false;
        }
        CrashlyticsReport.ApplicationExitInfo applicationExitInfo = (CrashlyticsReport.ApplicationExitInfo) obj;
        if (this.f29746a == applicationExitInfo.getPid() && this.f29747b.equals(applicationExitInfo.getProcessName()) && this.f29748c == applicationExitInfo.getReasonCode() && this.f29749d == applicationExitInfo.getImportance() && this.f29750e == applicationExitInfo.getPss() && this.f29751f == applicationExitInfo.getRss() && this.f29752g == applicationExitInfo.getTimestamp() && ((str = this.f29753h) != null ? str.equals(applicationExitInfo.getTraceFile()) : applicationExitInfo.getTraceFile() == null)) {
            ImmutableList<CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch> immutableList = this.f29754i;
            if (immutableList == null) {
                if (applicationExitInfo.getBuildIdMappingForArch() == null) {
                    return true;
                }
            } else if (immutableList.equals(applicationExitInfo.getBuildIdMappingForArch())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    @Nullable
    public ImmutableList<CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch> getBuildIdMappingForArch() {
        return this.f29754i;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    @NonNull
    public int getImportance() {
        return this.f29749d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    @NonNull
    public int getPid() {
        return this.f29746a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    @NonNull
    public String getProcessName() {
        return this.f29747b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    @NonNull
    public long getPss() {
        return this.f29750e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    @NonNull
    public int getReasonCode() {
        return this.f29748c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    @NonNull
    public long getRss() {
        return this.f29751f;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    @NonNull
    public long getTimestamp() {
        return this.f29752g;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    @Nullable
    public String getTraceFile() {
        return this.f29753h;
    }

    public int hashCode() {
        int hashCode;
        long j4 = this.f29750e;
        long j5 = this.f29751f;
        long j6 = this.f29752g;
        int hashCode2 = (((((((((((((this.f29746a ^ 1000003) * 1000003) ^ this.f29747b.hashCode()) * 1000003) ^ this.f29748c) * 1000003) ^ this.f29749d) * 1000003) ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003) ^ ((int) (j6 ^ (j6 >>> 32)))) * 1000003;
        String str = this.f29753h;
        int i4 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i5 = (hashCode2 ^ hashCode) * 1000003;
        ImmutableList<CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch> immutableList = this.f29754i;
        if (immutableList != null) {
            i4 = immutableList.hashCode();
        }
        return i5 ^ i4;
    }

    public String toString() {
        return "ApplicationExitInfo{pid=" + this.f29746a + ", processName=" + this.f29747b + ", reasonCode=" + this.f29748c + ", importance=" + this.f29749d + ", pss=" + this.f29750e + ", rss=" + this.f29751f + ", timestamp=" + this.f29752g + ", traceFile=" + this.f29753h + ", buildIdMappingForArch=" + this.f29754i + "}";
    }

    private AutoValue_CrashlyticsReport_ApplicationExitInfo(int i4, String str, int i5, int i6, long j4, long j5, long j6, @Nullable String str2, @Nullable ImmutableList<CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch> immutableList) {
        this.f29746a = i4;
        this.f29747b = str;
        this.f29748c = i5;
        this.f29749d = i6;
        this.f29750e = j4;
        this.f29751f = j5;
        this.f29752g = j6;
        this.f29753h = str2;
        this.f29754i = immutableList;
    }
}
