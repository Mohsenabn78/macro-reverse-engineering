package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes5.dex */
final class AutoValue_CrashlyticsReport_Session_Event extends CrashlyticsReport.Session.Event {

    /* renamed from: a  reason: collision with root package name */
    private final long f29840a;

    /* renamed from: b  reason: collision with root package name */
    private final String f29841b;

    /* renamed from: c  reason: collision with root package name */
    private final CrashlyticsReport.Session.Event.Application f29842c;

    /* renamed from: d  reason: collision with root package name */
    private final CrashlyticsReport.Session.Event.Device f29843d;

    /* renamed from: e  reason: collision with root package name */
    private final CrashlyticsReport.Session.Event.Log f29844e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class Builder extends CrashlyticsReport.Session.Event.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Long f29845a;

        /* renamed from: b  reason: collision with root package name */
        private String f29846b;

        /* renamed from: c  reason: collision with root package name */
        private CrashlyticsReport.Session.Event.Application f29847c;

        /* renamed from: d  reason: collision with root package name */
        private CrashlyticsReport.Session.Event.Device f29848d;

        /* renamed from: e  reason: collision with root package name */
        private CrashlyticsReport.Session.Event.Log f29849e;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder
        public CrashlyticsReport.Session.Event build() {
            String str = "";
            if (this.f29845a == null) {
                str = " timestamp";
            }
            if (this.f29846b == null) {
                str = str + " type";
            }
            if (this.f29847c == null) {
                str = str + " app";
            }
            if (this.f29848d == null) {
                str = str + " device";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Event(this.f29845a.longValue(), this.f29846b, this.f29847c, this.f29848d, this.f29849e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder
        public CrashlyticsReport.Session.Event.Builder setApp(CrashlyticsReport.Session.Event.Application application) {
            if (application != null) {
                this.f29847c = application;
                return this;
            }
            throw new NullPointerException("Null app");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder
        public CrashlyticsReport.Session.Event.Builder setDevice(CrashlyticsReport.Session.Event.Device device) {
            if (device != null) {
                this.f29848d = device;
                return this;
            }
            throw new NullPointerException("Null device");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder
        public CrashlyticsReport.Session.Event.Builder setLog(CrashlyticsReport.Session.Event.Log log) {
            this.f29849e = log;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder
        public CrashlyticsReport.Session.Event.Builder setTimestamp(long j4) {
            this.f29845a = Long.valueOf(j4);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder
        public CrashlyticsReport.Session.Event.Builder setType(String str) {
            if (str != null) {
                this.f29846b = str;
                return this;
            }
            throw new NullPointerException("Null type");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder() {
        }

        private Builder(CrashlyticsReport.Session.Event event) {
            this.f29845a = Long.valueOf(event.getTimestamp());
            this.f29846b = event.getType();
            this.f29847c = event.getApp();
            this.f29848d = event.getDevice();
            this.f29849e = event.getLog();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event)) {
            return false;
        }
        CrashlyticsReport.Session.Event event = (CrashlyticsReport.Session.Event) obj;
        if (this.f29840a == event.getTimestamp() && this.f29841b.equals(event.getType()) && this.f29842c.equals(event.getApp()) && this.f29843d.equals(event.getDevice())) {
            CrashlyticsReport.Session.Event.Log log = this.f29844e;
            if (log == null) {
                if (event.getLog() == null) {
                    return true;
                }
            } else if (log.equals(event.getLog())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event
    @NonNull
    public CrashlyticsReport.Session.Event.Application getApp() {
        return this.f29842c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event
    @NonNull
    public CrashlyticsReport.Session.Event.Device getDevice() {
        return this.f29843d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event
    @Nullable
    public CrashlyticsReport.Session.Event.Log getLog() {
        return this.f29844e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event
    public long getTimestamp() {
        return this.f29840a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event
    @NonNull
    public String getType() {
        return this.f29841b;
    }

    public int hashCode() {
        int hashCode;
        long j4 = this.f29840a;
        int hashCode2 = (((((((((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003) ^ this.f29841b.hashCode()) * 1000003) ^ this.f29842c.hashCode()) * 1000003) ^ this.f29843d.hashCode()) * 1000003;
        CrashlyticsReport.Session.Event.Log log = this.f29844e;
        if (log == null) {
            hashCode = 0;
        } else {
            hashCode = log.hashCode();
        }
        return hashCode ^ hashCode2;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event
    public CrashlyticsReport.Session.Event.Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        return "Event{timestamp=" + this.f29840a + ", type=" + this.f29841b + ", app=" + this.f29842c + ", device=" + this.f29843d + ", log=" + this.f29844e + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Event(long j4, String str, CrashlyticsReport.Session.Event.Application application, CrashlyticsReport.Session.Event.Device device, @Nullable CrashlyticsReport.Session.Event.Log log) {
        this.f29840a = j4;
        this.f29841b = str;
        this.f29842c = application;
        this.f29843d = device;
        this.f29844e = log;
    }
}
