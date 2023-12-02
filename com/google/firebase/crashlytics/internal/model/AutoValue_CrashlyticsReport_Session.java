package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.encoders.annotations.Encodable;

/* loaded from: classes5.dex */
final class AutoValue_CrashlyticsReport_Session extends CrashlyticsReport.Session {

    /* renamed from: a  reason: collision with root package name */
    private final String f29782a;

    /* renamed from: b  reason: collision with root package name */
    private final String f29783b;

    /* renamed from: c  reason: collision with root package name */
    private final String f29784c;

    /* renamed from: d  reason: collision with root package name */
    private final long f29785d;

    /* renamed from: e  reason: collision with root package name */
    private final Long f29786e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f29787f;

    /* renamed from: g  reason: collision with root package name */
    private final CrashlyticsReport.Session.Application f29788g;

    /* renamed from: h  reason: collision with root package name */
    private final CrashlyticsReport.Session.User f29789h;

    /* renamed from: i  reason: collision with root package name */
    private final CrashlyticsReport.Session.OperatingSystem f29790i;

    /* renamed from: j  reason: collision with root package name */
    private final CrashlyticsReport.Session.Device f29791j;

    /* renamed from: k  reason: collision with root package name */
    private final ImmutableList<CrashlyticsReport.Session.Event> f29792k;

    /* renamed from: l  reason: collision with root package name */
    private final int f29793l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class Builder extends CrashlyticsReport.Session.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f29794a;

        /* renamed from: b  reason: collision with root package name */
        private String f29795b;

        /* renamed from: c  reason: collision with root package name */
        private String f29796c;

        /* renamed from: d  reason: collision with root package name */
        private Long f29797d;

        /* renamed from: e  reason: collision with root package name */
        private Long f29798e;

        /* renamed from: f  reason: collision with root package name */
        private Boolean f29799f;

        /* renamed from: g  reason: collision with root package name */
        private CrashlyticsReport.Session.Application f29800g;

        /* renamed from: h  reason: collision with root package name */
        private CrashlyticsReport.Session.User f29801h;

        /* renamed from: i  reason: collision with root package name */
        private CrashlyticsReport.Session.OperatingSystem f29802i;

        /* renamed from: j  reason: collision with root package name */
        private CrashlyticsReport.Session.Device f29803j;

        /* renamed from: k  reason: collision with root package name */
        private ImmutableList<CrashlyticsReport.Session.Event> f29804k;

        /* renamed from: l  reason: collision with root package name */
        private Integer f29805l;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session build() {
            String str = "";
            if (this.f29794a == null) {
                str = " generator";
            }
            if (this.f29795b == null) {
                str = str + " identifier";
            }
            if (this.f29797d == null) {
                str = str + " startedAt";
            }
            if (this.f29799f == null) {
                str = str + " crashed";
            }
            if (this.f29800g == null) {
                str = str + " app";
            }
            if (this.f29805l == null) {
                str = str + " generatorType";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session(this.f29794a, this.f29795b, this.f29796c, this.f29797d.longValue(), this.f29798e, this.f29799f.booleanValue(), this.f29800g, this.f29801h, this.f29802i, this.f29803j, this.f29804k, this.f29805l.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder setApp(CrashlyticsReport.Session.Application application) {
            if (application != null) {
                this.f29800g = application;
                return this;
            }
            throw new NullPointerException("Null app");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder setAppQualitySessionId(@Nullable String str) {
            this.f29796c = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder setCrashed(boolean z3) {
            this.f29799f = Boolean.valueOf(z3);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder setDevice(CrashlyticsReport.Session.Device device) {
            this.f29803j = device;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder setEndedAt(Long l4) {
            this.f29798e = l4;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder setEvents(ImmutableList<CrashlyticsReport.Session.Event> immutableList) {
            this.f29804k = immutableList;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder setGenerator(String str) {
            if (str != null) {
                this.f29794a = str;
                return this;
            }
            throw new NullPointerException("Null generator");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder setGeneratorType(int i4) {
            this.f29805l = Integer.valueOf(i4);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder setIdentifier(String str) {
            if (str != null) {
                this.f29795b = str;
                return this;
            }
            throw new NullPointerException("Null identifier");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder setOs(CrashlyticsReport.Session.OperatingSystem operatingSystem) {
            this.f29802i = operatingSystem;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder setStartedAt(long j4) {
            this.f29797d = Long.valueOf(j4);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder setUser(CrashlyticsReport.Session.User user) {
            this.f29801h = user;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder() {
        }

        private Builder(CrashlyticsReport.Session session) {
            this.f29794a = session.getGenerator();
            this.f29795b = session.getIdentifier();
            this.f29796c = session.getAppQualitySessionId();
            this.f29797d = Long.valueOf(session.getStartedAt());
            this.f29798e = session.getEndedAt();
            this.f29799f = Boolean.valueOf(session.isCrashed());
            this.f29800g = session.getApp();
            this.f29801h = session.getUser();
            this.f29802i = session.getOs();
            this.f29803j = session.getDevice();
            this.f29804k = session.getEvents();
            this.f29805l = Integer.valueOf(session.getGeneratorType());
        }
    }

    public boolean equals(Object obj) {
        String str;
        Long l4;
        CrashlyticsReport.Session.User user;
        CrashlyticsReport.Session.OperatingSystem operatingSystem;
        CrashlyticsReport.Session.Device device;
        ImmutableList<CrashlyticsReport.Session.Event> immutableList;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session)) {
            return false;
        }
        CrashlyticsReport.Session session = (CrashlyticsReport.Session) obj;
        if (this.f29782a.equals(session.getGenerator()) && this.f29783b.equals(session.getIdentifier()) && ((str = this.f29784c) != null ? str.equals(session.getAppQualitySessionId()) : session.getAppQualitySessionId() == null) && this.f29785d == session.getStartedAt() && ((l4 = this.f29786e) != null ? l4.equals(session.getEndedAt()) : session.getEndedAt() == null) && this.f29787f == session.isCrashed() && this.f29788g.equals(session.getApp()) && ((user = this.f29789h) != null ? user.equals(session.getUser()) : session.getUser() == null) && ((operatingSystem = this.f29790i) != null ? operatingSystem.equals(session.getOs()) : session.getOs() == null) && ((device = this.f29791j) != null ? device.equals(session.getDevice()) : session.getDevice() == null) && ((immutableList = this.f29792k) != null ? immutableList.equals(session.getEvents()) : session.getEvents() == null) && this.f29793l == session.getGeneratorType()) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    @NonNull
    public CrashlyticsReport.Session.Application getApp() {
        return this.f29788g;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    @Nullable
    public String getAppQualitySessionId() {
        return this.f29784c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    @Nullable
    public CrashlyticsReport.Session.Device getDevice() {
        return this.f29791j;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    @Nullable
    public Long getEndedAt() {
        return this.f29786e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    @Nullable
    public ImmutableList<CrashlyticsReport.Session.Event> getEvents() {
        return this.f29792k;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    @NonNull
    public String getGenerator() {
        return this.f29782a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public int getGeneratorType() {
        return this.f29793l;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    @NonNull
    @Encodable.Ignore
    public String getIdentifier() {
        return this.f29783b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    @Nullable
    public CrashlyticsReport.Session.OperatingSystem getOs() {
        return this.f29790i;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public long getStartedAt() {
        return this.f29785d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    @Nullable
    public CrashlyticsReport.Session.User getUser() {
        return this.f29789h;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int i4;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6 = (((this.f29782a.hashCode() ^ 1000003) * 1000003) ^ this.f29783b.hashCode()) * 1000003;
        String str = this.f29784c;
        int i5 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        long j4 = this.f29785d;
        int i6 = (((hashCode6 ^ hashCode) * 1000003) ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003;
        Long l4 = this.f29786e;
        if (l4 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = l4.hashCode();
        }
        int i7 = (i6 ^ hashCode2) * 1000003;
        if (this.f29787f) {
            i4 = 1231;
        } else {
            i4 = 1237;
        }
        int hashCode7 = (((i7 ^ i4) * 1000003) ^ this.f29788g.hashCode()) * 1000003;
        CrashlyticsReport.Session.User user = this.f29789h;
        if (user == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = user.hashCode();
        }
        int i8 = (hashCode7 ^ hashCode3) * 1000003;
        CrashlyticsReport.Session.OperatingSystem operatingSystem = this.f29790i;
        if (operatingSystem == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = operatingSystem.hashCode();
        }
        int i9 = (i8 ^ hashCode4) * 1000003;
        CrashlyticsReport.Session.Device device = this.f29791j;
        if (device == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = device.hashCode();
        }
        int i10 = (i9 ^ hashCode5) * 1000003;
        ImmutableList<CrashlyticsReport.Session.Event> immutableList = this.f29792k;
        if (immutableList != null) {
            i5 = immutableList.hashCode();
        }
        return ((i10 ^ i5) * 1000003) ^ this.f29793l;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public boolean isCrashed() {
        return this.f29787f;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public CrashlyticsReport.Session.Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        return "Session{generator=" + this.f29782a + ", identifier=" + this.f29783b + ", appQualitySessionId=" + this.f29784c + ", startedAt=" + this.f29785d + ", endedAt=" + this.f29786e + ", crashed=" + this.f29787f + ", app=" + this.f29788g + ", user=" + this.f29789h + ", os=" + this.f29790i + ", device=" + this.f29791j + ", events=" + this.f29792k + ", generatorType=" + this.f29793l + "}";
    }

    private AutoValue_CrashlyticsReport_Session(String str, String str2, @Nullable String str3, long j4, @Nullable Long l4, boolean z3, CrashlyticsReport.Session.Application application, @Nullable CrashlyticsReport.Session.User user, @Nullable CrashlyticsReport.Session.OperatingSystem operatingSystem, @Nullable CrashlyticsReport.Session.Device device, @Nullable ImmutableList<CrashlyticsReport.Session.Event> immutableList, int i4) {
        this.f29782a = str;
        this.f29783b = str2;
        this.f29784c = str3;
        this.f29785d = j4;
        this.f29786e = l4;
        this.f29787f = z3;
        this.f29788g = application;
        this.f29789h = user;
        this.f29790i = operatingSystem;
        this.f29791j = device;
        this.f29792k = immutableList;
        this.f29793l = i4;
    }
}
